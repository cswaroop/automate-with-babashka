#!/usr/bin/env bb
;; This program unravels namespaces
;; 1. Multiple namespaces in one file!
;; 
(ns my.a)
(def x 10)

(ns my.b)
(require '[my.a :refer :all])
(println x)
