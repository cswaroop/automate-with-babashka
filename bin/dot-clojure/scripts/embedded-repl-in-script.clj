#!/bin/sh
#_(

   #_DEPS is same format as deps.edn. Multiline is okay.
   DEPS='
   {
    :paths ["resources"]

    :aliases {:dev      {:extra-paths ["dev-resources" "classes"]
                         :extra-deps  {org.clojure/clojure {:mvn/version "1.10.1"}
                                       clj-kondo           {:mvn/version "RELEASE"}}}
              :test     {:extra-paths ["test/clj"]
                         :extra-deps  {lambdaisland/kaocha      {:mvn/version "1.0-612"}
                                       lambdaisland/kaocha-cljs {:mvn/version "0.0-71"}
                                       seancorfield/next.jdbc   {:mvn/version "1.1.569"}}}
              ;; Lets  learn to use a common part already now since in the next exercise we create frontend with re-frame.
              :common   {:extra-paths ["src/cljc"]
                         :extra-deps  {metosin/reitit {:mvn/version "0.4.2"}
                                       aero           {:mvn/version "1.1.6"}
                                       integrant/repl {:mvn/version "0.3.1"}
                                       }}
              :backend  {:extra-paths ["src/clj"]
                         :extra-deps  {integrant                       {:mvn/version "0.8.0"}
                                       org.clojure/data.json           {:mvn/version "1.0.0"}
                                       org.clojure/data.csv            {:mvn/version "1.0.0"}
                                       metosin/maailma                 {:mvn/version "1.1.0"}
                                       org.clojure/tools.logging       {:mvn/version "1.0.0"}
                                       commons-logging/commons-logging {:mvn/version "1.2"}
                                       ch.qos.logback/logback-classic  {:mvn/version "1.2.3"}
                                       hikari-cp                       {:mvn/version "2.12.0"}
                                       com.layerware/hugsql            {:mvn/version "0.5.1"}
                                       org.postgresql/postgresql       {:mvn/version "42.2.12"}
                                       ring/ring-core                  {:mvn/version "1.8.0"}
                                       ring/ring-jetty-adapter         {:mvn/version "1.7.1"}
                                       ring-cors/ring-cors             {:mvn/version "0.1.13"}
                                       ring/ring-json                  {:mvn/version "0.4.0"}
                                       ring/ring-defaults              {:mvn/version "0.3.2"}
                                       buddy/buddy-sign                {:mvn/version "3.1.0"}
                                       com.cognitect.aws/api           {:mvn/version "0.8.437"}
                                       com.cognitect.aws/endpoints     {:mvn/version "1.1.11.726"}
                                       com.cognitect.aws/dynamodb      {:mvn/version "792.2.620.0"}
                                       org.eclipse.jetty/jetty-client  {:mvn/version "9.4.26.v20200117"}
                                       clj-http                        {:mvn/version "3.10.0"}
                                       nrepl                           {:mvn/version "0.7.0"}
                                       }}
              :postgres {:extra-paths ["postgres"]}

              ;; Test runner in console.
              :test-runner {:extra-paths ["test"]
                            :extra-deps  {com.cognitect/test-runner {:git/url "https://github.com/cognitect-labs/test-runner.git"
                                                                     :sha     "209b64504cb3bd3b99ecfec7937b358a879f55c1"}}
                            :main-opts   ["-m" "cognitect.test-runner"]}

              ;; Depstar for building fat jar.
              :uberjar
              {:extra-deps  {seancorfield/depstar {:mvn/version "0.5.1"}}
               :extra-paths ["prod-resources"]
               :main-opts   ["-m" "hf.depstar.uberjar" "target/ss.jar"]}
              :outdated  {:extra-deps {olical/depot {:mvn/version "RELEASE"}}
                          :main-opts  ["-m" "depot.outdated.main" "-a" "outdated"]}
              :clj-kondo
              {:extra-deps {clj-kondo {:mvn/version "RELEASE"}}
               :main-opts  ["-m" "clj-kondo.main"]}
              ;; Cider specific.
              :cider-clj {:extra-deps {org.clojure/clojure {:mvn/version "1.10.1"}
                                       cider/cider-nrepl   {:mvn/version "0.25.6"}}
                          :main-opts  ["-m" "nrepl.cmdline" "--middleware" "[cider.nrepl/cider-middleware]"]}}
    }
   '

   #_You can put other options here
   OPTS='
   -J-Xms256m -J-Xmx256m -J-client
   '

   #_exec clojure $OPTS -Sdeps "$DEPS" "$0" "$@"
   exec clojure $OPTS -Sdeps "$DEPS" -A:cider-clj
   )



(println "Hello!")

(require '[clj-time.core :as t])

(prn (str (t/now)))

(prn *command-line-args*)

(println (.. (Runtime/getRuntime)
             totalMemory))
(require [clojure.data.csv :as csv]
         [clojure.java.io :as io])

(defn write-csv-file
  "Writes a csv file using a key and an s-o-s (sequence of sequences)"
  [out-sos out-file]

  (spit out-file "" :append false)
  (with-open [out-data (io/writer out-file)]
    (csv/write-csv out-data out-sos)))

;; Opens the file 'myfile.txt' and prints out the contents.  The 
;; 'with-open' ensures that the reader is closed at the end of the 
;; form.  
;; 
;; Please note that reading a file a character at a time is not 
;; very efficient.

(with-open [r (clojure.java.io/input-stream "myfile.txt")] 
  (loop [c (.read r)] 
    (if (not= c -1)
      (do 
        (print (char c)) 
        (recur (.read r))))))

(:require '[clojure.spec :as s])

(def recipie {})
