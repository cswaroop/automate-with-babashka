#!/usr/bin/env bb
;; Clojure version of an Openconnect vpn startup script
(require '[clojure.java.shell :refer [sh]])
(require '[babashka.process :as p])
(require '[clojure.string :as str :refer [blank? trim]])
(require '[clojure.tools.cli :refer [parse-opts]])

(defn tilde-home
  "make filepaths know tilde as home"
  [s]
  (let [home (System/getProperty "user.home")]
    (clojure.string/replace-first s "~" home)))

(def DEFAULT-CREDENTIALS "~/.vpncred.edn")

(defn credentials
  "Get username and password"
  [& [file-path]]
  (let [file-path (tilde-home (or file-path DEFAULT-CREDENTIALS))]
    (-> file-path slurp read-string)))

(defn pid
  "Get the pid of the openconnect process, as a string"
  []
  (let [pid (-> (sh "pidof" "openconnect") :out)]
    (when-not (blank? pid) (trim pid))))

(defn status
  "Print whether the VPN is on, and what its PID"
  []
  (if-let [pid (pid)]
    (println "VPN on. PID:" pid)
    (println "-- VPN off.")))

(defn _connect [&[credfile]]
  "Connect to the VPN using openconnect, then automatically provide it your password on stdin"
  (let [{:keys [username password vpn-server authgroup]} (credentials credfile)
        userphrase (str "--user=" username)
        groupphrase (str "--authgroup=" authgroup)
        openconnect ["sudo" "openconnect" vpn-server "--background" groupphrase userphrase
                     "--passwd-on-stdin"]
        proc @(p/process openconnect {:out :inherit
                                      :err :inherit
                                      :in password})]
    proc))

(defn connect
  "Connect to OpenConnect VPN with optional credentials filepath `c` and give message"
  [&[c]]
  (cond
    (pid) (println "VPN is already running as process" (pid))
    :else 
    (if (_connect c)
      (println "-- VPN started")
      (println "-- VPN failed to start"))))

(defn _stop
  "Stop the VPN process"
  [pid]
  (sh "sudo" "kill" pid))

(defn stop
  "Stop the VPN proess and give message"
  []
  (if-let [p (pid)]
    (doseq [s (clojure.string/split p #"\s+")]
      (do
        (println "stopping process:" s)
        (_stop s)
        (Thread/sleep 500) ;; There's got to be a better way to wait for _stop to finish
        (if-not (pid)
          (println "VPN Stopped.")
          (println "Failed to stop VPN (" s ")"))))
    (println "No VPN running.")))

(defn _restart
  "Restart the vpn with optional credentials filepath `c`"
  [&[c]]
  (stop)
  (connect c))

(defn restart
  "Restart the VPN and give message"
  [& [credentials-file]]
  (_restart credentials-file)
  (println "Restarted the VPN"))

(def cli-options
  [["-c" "--credentials" (str "Provide non-default credential file. Default: " DEFAULT-CREDENTIALS)
    :default DEFAULT-CREDENTIALS]])

(defn help-summary [opt-summary]
  (let [arg-help
        (clojure.string/join "\n"
                             [["status"  "VPN PID and status"]
                              ["start"   "Start the VPN"]
                              ["stop"   "Stop the VPN"]
                              ["restart"   "Restart the VPN"]])
        sep "\n------------------------------\n"]
    (str "Options:"
         sep
         opt-summary
         "\n\nArguments:"
         sep
         arg-help)))

(defn -main
  "Main process"
  []
  (let [cli (parse-opts *command-line-args* cli-options)
        opts (:options cli)
        action (first (:arguments cli))]
    (case action
      "status" (status)
      "start" (connect (:credentials opts))
      "stop" (stop)
      "restart" (restart (:credentials opts))
      (println (help-summary (:summary cli))))))

;;;;;;;;;;;;;;;;
;;    EXECUTE ;;
;;;;;;;;;;;;;;;;
(-main)
