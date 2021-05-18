(ns repl-driven-development.demo
  (:require [ring.adapter.jetty :refer [run-jetty]])
  (:gen-class))

(comment
  (ns-publics (find-ns 'ring.adapter.jetty))
  
  ,)

(defn greet
  "Callable entry point to the application."
  [data]  
  (println (str "Hello, " (or (:name data) "World") "!")))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (greet {:name (first args)}))

(comment
  (require '[clojure.tools.deps.alpha.repl :refer [add-libs]])
  (add-libs '{ring/ring {:mvn/version "1.9.0"}})

  ,)
