;; # Pattern Matching and Logic Programming

;; Simpe pattern matching clojure idioms such as destructuring, multimethods
;; (runtime polymorphism for functions), case/cond/condp, core.match

;; Prolog like pattern matching with Unification (against facts/rules)
;; and Backtracking using core.logic (minikanren)

;; Macros to create DSLs?

;; core.match's match is a pattern matching macro.  Its DSL is
(match
  input
  {:key "foo"} (println "key is foo")
  {:key _} (println "key is something")
  :else (println "no key"))

;; defun is another library for pattern matching macro for defining functions
;; with defun macro

;; recursive pattern matching Pattern (Start, Work, End)

;
