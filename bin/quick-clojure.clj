(ns quick-clojure)

;; Functional programming

((comp clojure.string/upper-case
       (partial apply str)
       reverse)
 "hello")
;; => "OLLEH"
((comp clojure.string/upper-case
       str
       reverse)
 "hello")
;; => "(\\O \\L \\L \\E \\H)"

(reverse "hello")
;; => (\o \l \l \e \h)

(str (reverse "hello"))
;; => "(\\o \\l \\l \\e \\h)"

