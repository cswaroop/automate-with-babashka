#!/usr/bin/env bb
;; -*- mode: clojure -*-
;; https://gitlab.com/blak3mill3r/emacs-ludicrous-speed/-/blob/master/bin/els-cloner
(ns els-cloner
  (:import (java.net ServerSocket)
           (java.io InputStreamReader)
           (clojure.lang LineNumberingPushbackReader))
  (:require [clojure.string :as str]
            [clojure.java.io :as io]
            [clojure.core.async :as a]
            [clojure.java.shell :refer [sh]]))

(def config-defaults
  {:x-display ":0.0"
   :cloner-host "localhost"
   :cloner-port 9911
   :home-dir "/home"
   :logfile "/var/log/els-cloner.log"})

(def config (merge config-defaults (read-string (slurp "/etc/els-cloner.edn"))))

(def log (clojure.java.io/writer (:logfile config) :append true))
(def els-user-home-dir (str (:home-dir config) "/" (:user config)))
(defn els-dir [] (or (:els-dir config) (str els-user-home-dir "/.els")))
(defn els-bin-dir [] (str (els-dir) "/bin"))
(defn criu-images-dir [] (str (els-dir) "/.images"))
(defn criu-current-image-dir [] (str (criu-images-dir) "/mine"))
(defn shenv-file [] (str (els-bin-dir) "/env"))

;; replicate some EDN config values as bash environment variables for the helper scripts
(defn shenv []
  (str
   "export EMACS_BINARY=" (:emacs-binary config)
   "\nexport USER=" (:user config)
   "\nexport CLONER_HOST=" (:cloner-host config)
   "\nexport CLONER_PORT=" (:cloner-port config)
   "\nexport EMACS_SERVER_SOCKET_DIR=" (:emacs-server-socket-dir config)))

(spit (shenv-file) (shenv))

(def cloner-tcp-port 9911)
(defn emacs-socket-dir [] (-> config :emacs-server-socket-dir))
(defn emacs-dir [] (or (:emacs-dir config) (str els-user-home-dir "/.emacs.d")))
(defn criu-restore-log-file [] (str "/var/log/els-cloner-restore.log"))
(defn emacs-socket
  ([] (emacs-socket "server"))
  ([name] (str (emacs-socket-dir) "/" name)))
(def cloner-actions (a/chan 1))
(def warm-emacs-pid (atom nil))

(defn kill-warm-one []
  (when-let [warm-pid @warm-emacs-pid]
    (println "First killing warm pid="warm-pid)
    (println (:out (sh "kill" warm-pid)))
    (flush)))

(-> (Runtime/getRuntime) (.addShutdownHook (Thread. kill-warm-one)))

(defn on-thread [f] (doto (new Thread f) (.start)))

(defn is-socket-there? [socket] (.exists (File. socket)))
(defn await-socket [socket] (loop [] (when-not (is-socket-there? socket) (Thread/sleep 50) (recur)))) ;; FIXME need a timeout
(defn pid-of-socket [socket]
  ;; FIXME add bail
  (try
    (-> (sh "lsof" "-Fp" socket) :out (str/split #"\n") first (subs 1))
    (catch Exception e (pid-of-socket socket))))

(defn rebake-launch-emacs []
  (println "Starting emacs daemon...")
  (let [{:keys [exit err out]} (sh "su" (:user config) "-c" "./els-rebake-launch-emacs" :dir (els-bin-dir))]
    (when-not (zero? exit) (throw (ex-info "ERROR: Could not start emacs daemon for cloning!" {:err err})))
    (println out)
    (println err)))

(defn do-rebake []
  (println "Rebaking...")
  (kill-warm-one)
  (sh "rm" "-rf" (criu-current-image-dir))
  (sh "mkdir" (criu-current-image-dir))
  (rebake-launch-emacs)
  (println "Done. Awaiting socket..." (emacs-socket))
  (Thread/sleep 250)
  (await-socket (emacs-socket)) 
  (println "Done. Awaiting socket..." (emacs-socket) " IS THERE")
  (let [pid (pid-of-socket (emacs-socket))]
    (println "Done. Criu dump pid="pid)
    (println (sh "criu" "dump" "-t" pid "-o" "dump.log" :dir (criu-current-image-dir)))
    (println "Done. Log is "(criu-current-image-dir)"/dump.log")
    (println "Remove dangling socket")
    (sh "rm" "-f" (emacs-socket))))

(defn do-criu-restore
  "Restore a CRIU snapshot of a freshly started emacs-server process"
  []
  (when-not (.exists (File. (criu-current-image-dir)))
    (println "No image available.")
    (do-rebake))
  (let [p (a/thread (sh "criu-ns" "restore" "-d" "-vvv" "-o" (criu-restore-log-file) :dir (criu-current-image-dir)))]
    (println "Restored; log in " (criu-restore-log-file))
    (await-socket (emacs-socket))
    (println "New warm pid = " (reset! warm-emacs-pid (pid-of-socket (emacs-socket))))))

(defn create-server 
  [accept-fn port]
  (let [ss (new ServerSocket port)]
    (on-thread #(when-not (. ss (isClosed))
                  (try (accept-fn (. ss (accept))) (catch Exception e))
                  (recur)))
    ss))

(defn cloner-service
  "Reads one EDN form from the socket and puts that value on a channel, then closes the socket"
  [sock]
  (let [ins (. sock (getInputStream))
        e (read (new LineNumberingPushbackReader (new InputStreamReader ins)))]
    ;; strange, this namespaced keyword (which is returned by edamame for eof) is unparseable?
    ;; :edamame.impl.parser/eof
    ;; so instead of testing if the value read is that keyword, we just test if it is a Keyword
    ;; otherwise it's a message for the service...
    (when-not (= clojure.lang.Keyword (type e))
      (a/put! cloner-actions e)
      (.close sock))))

(declare do-cloning)
(defmulti enact (fn [action]  (:command action)))

;; base64 is used to avoid bash string escaping issues
(defmethod enact :clone [{:keys [name pid args dir]}]
  (let [args (-> (java.util.Base64/getDecoder) (.decode args) (String.))]
    (do-cloning name pid args dir)))

(defmethod enact :rebake [_] (do-rebake) (do-criu-restore))

(defn service-loop [] (loop [] (enact (a/<!! cloner-actions)) (recur)))

(def nvhost "localhost")
(def nvport 9281)
(defn inform-nv-of-pid-replacement [pid replacement-pid]
  (println "Informing nv of pid replacement " pid replacement-pid)
  (flush)
  (with-open [s (java.net.Socket. nvhost nvport)]
    (.write (.getOutputStream s) (-> {:event :replace-pid :pid pid :replacement-pid replacement-pid}
                                     prn-str (.getBytes "UTF-8")))))

(defn as-els-user [command dir] (sh "su" (:user config) "-c" command :dir dir))

(defn warm-transmogrify-elisp-arg [clone-name] (str "'(progn (els-rename-server \""clone-name"\") (els-prepare-to-die))'" ))
;;(defn warm-transmogrify-elisp-arg [clone-name dir] (str "'(progn (els-rename-server \""clone-name"\") (els-prepare-to-die) (cd \""dir"\"))'" ))

(defn warm-transmogrify-cmd [clone-name]
  (str "tmux new-session -d -s els-cloner "
       "emacsclient -s "(emacs-socket)
       " -nw -e " (warm-transmogrify-elisp-arg clone-name)))

(defn warm-transmogrify [clone-name dir]
  ;; turn the warm emacs into a new named clone by sending it some elisp
  ;; have to run it in tmux because without the -nw argument, (rename-server) does NOT work; not sure why
  ;; and -nw needs a terminal or emacsclient exits with an error; so use tmux to give it a terminal, even though we aren't needing to create a frame now
  ;; because creating a frame temporarily seems to be a necessary workaround to get (rename-server) to work... I do not know why this is
  (let [cmd (warm-transmogrify-cmd clone-name)]
    (println "Transmogrifying the warm one... " clone-name " " dir)
    (println cmd)
    (println (:out (as-els-user cmd dir)))))

(defn activate-clone [clone-name args dir]
  (println "Activating clone \""clone-name"\", in directory "dir", forwarding args:   " args)
  (println (:out (as-els-user (str "DISPLAY="(:x-display config)" emacsclient -s "(emacs-socket clone-name)" -c -n " args) dir))))

(defn do-cloning
  [clone-name wrapper-pid args dir]
  (let [warm-pid @warm-emacs-pid]
    (reset! warm-emacs-pid nil)
    #_(inform-nv-of-pid-replacement wrapper-pid warm-pid)
    (warm-transmogrify clone-name dir)
    (await-socket (emacs-socket clone-name))
    
    ;; This is the earliest moment that it is possible to replace the warm one using CRIU (since it has relinquished the default server socket); do this asynchronously
    (a/thread (do-criu-restore))

    (activate-clone clone-name args dir)))

(defn start-cloner-service [s] (on-thread #(cloner-service s)))

(binding [*out* log]
  (do-criu-restore)
  (a/thread (service-loop))
  (with-open [server (create-server start-cloner-service cloner-tcp-port)]
    (println "Listening on " cloner-tcp-port)
    (loop [] (Thread/sleep 30000) (recur))))
