#!/usr/bin/env bb
(require '[clojure.repl :as repl])
(require '[clojure.string :as str])

;; Challenge:
;; Implement subset of unix FIND in clojure

;; C:/progra~1/git/usr/bin/find   .  -type f -not -iwholename '*.git*' ! -path '*images*' ! -path '*.#*'
