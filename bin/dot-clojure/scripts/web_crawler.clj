#!/usr/bin/env -S -v  cmd-clj '-Sdeps "{:deps {clj-commons/pomegranate {:mvn/version """"""1.2.0""""""} clj-tagsoup {:mvn/version """"""0.3.0""""""}}}" '
#_(use '[cemerick.pomegranate :only (add-dependencies)])
#_(add-dependencies
   :coordinates '[[clj-tagsoup "0.3.0"]]
   :repositories (merge cemerick.pomegranate.aether/maven-central {"clojars" "https://clojars.org/repo"}))

(ns recipe20.core
  (:require [pl.danieljanus.tagsoup :as http-parser]
            [clojure.core.async :as async :refer :all :exclude
             [into]]
            [clojure.zip :as z]))




