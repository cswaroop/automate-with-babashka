#!/bin/sh
#_(

   #_DEPS is same format as deps.edn. Multiline is okay.
   DEPS='
   {:deps {clj-time {:mvn/version "0.14.2"}}}
   '

   #_You can put other options here
   OPTS='
   -J-Xms256m -J-Xmx256m -J-client
   '

   exec clojure $OPTS -Sdeps "$DEPS" "$0" "$@"

   )

;; https://gist.github.com/ericnormand/6bb4562c4bc578ef223182e3bb1e72c5
(println "Hello!")

(require '[clj-time.core :as t])
(prn (str (t/now)))
(prn *command-line-args*)
(println (.. (Runtime/getRuntime)
             totalMemory))
