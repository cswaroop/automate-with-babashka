#!/usr/bin/env bb

(require '[babashka.deps :as deps])

(deps/add-deps
'{:deps {clojure-term-colors/clojure-term-colors {:mvn/version "0.1.0"}}})

(require '[clojure.term.colors :as c])

(println  
 (c/yellow "Yellow")
 (c/red "Red")
 "No color")



