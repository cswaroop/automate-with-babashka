#!/usr/bin/env bb
(require '[babashka.classpath :refer [add-classpath]]
         '[clojure.java.shell :refer [sh]]
         '[clojure.string :as str])

(def medley-dep '{:deps {medley {:git/url "https://github.com/borkdude/medley"
                                 :sha     "91adfb5da33f8d23f75f0894da1defe567a625c0"}}})
(def cp (-> (sh "cmd-clojure" "-Spath" "-Sdeps" (str medley-dep)) :out str/trim))
(add-classpath cp)
(require '[medley.core :as m])
(m/index-by :id [{:id 1} {:id 2}])
;;=> {1 {:id 1}, 2 {:id 2}}

