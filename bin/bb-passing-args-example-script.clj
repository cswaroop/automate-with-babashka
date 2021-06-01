#!/usr/bin/env bb
;; Replicating bash/zsh "<command> $@" in babashka
(require '[babashka.process :refer [process tokenize]])

(def command "java -jar /deploy/zprint/zprint.jar")

(as-> command $
  (tokenize $)
  (concat $ *command-line-args*)
  (do @(process $ {:inherit true}) nil))/
