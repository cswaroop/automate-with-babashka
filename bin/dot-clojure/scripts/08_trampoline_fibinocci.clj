#!/usr/bin/env bb

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;     Defining Recursive Functions    ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn fibo
  ([n]
   (fibo [0N 1N] n))
  ([xs n]
   (if (<= n (count xs))
     xs
     (let [x'  (+ (last xs)
                  (nth xs (- (count xs) 2)))
           xs' (conj xs x')]
       (fibo xs' n)))))
(last (fibo 10000))

(defn fibo-recur
  ([n]
   (fibo-recur [0N 1N] n))
  ([xs n]
   (if (<= n (count xs))
     xs
     (let [x'  (+ (last xs)
                  (nth xs (- (count xs) 2)))
           xs' (conj xs x')]
       (recur xs' n)))))

(time (last (fibo-recur 10000)))

(defn fibo-loop [n]
  (loop [xs [0N 1N]
         n  n]
    (if (<= n (count xs))
      xs
      (let [x'  (+ (last xs)
                   (nth xs (- (count xs) 2)))
            xs' (conj xs x')]
        (recur xs' n)))))

(last (fibo-loop 10000))

(defn fibo-trampoline [n]
  (letfn [(fibo-fn [xs n]
            (if (<= n (count xs))
              xs
              (let [x'  (+ (last xs)
                           (nth xs (- (count xs) 2)))
                    xs' (conj xs x')]
                #(fibo-fn xs' n))))]
    (trampoline fibo-fn [0N 1N] n)))
(time (last (fibo-trampoline 10000)))


(defn sqrt-div2-recur [n]
  (letfn [(sqrt [n]
            (if (< n 1)
              n
              (div2 (Math/sqrt n))))
          (div2 [n]
            (if (< n 1)
              n
              (sqrt (/ n 2))))]
    (sqrt n)))

(defn sqrt-div2-trampoline [n]
  (letfn [(sqrt [n]
            (if (< n 1)
              n
              #(div2 (Math/sqrt n))))
          (div2 [n]
            (if (< n 1)
              n
              #(sqrt (/ n 2))))]
    (trampoline sqrt n)))
(time (sqrt-div2-recur 10000000000N))
(time (sqrt-div2-trampoline 10000000000N))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;        Thinking in Sequences        ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; Note that the computation of a recursive function can easily be represented
;; as a lazy sequence.

(defn fibo-lazy [n]
  (->> [0N 1N]
       (iterate (fn [[a b]] [b (+ a b)]))
       (map first)
       (take n)))

(last (fibo-lazy 10000))
(time (def fibo-xs (fibo-lazy 10000)))

;; Memoization further brings it down
(def fibo-mem (memoize fibo-lazy))
(time (last (fibo-mem 10000)))
(time (last (fibo-mem 10000)))

;; “It is better to have 100 functions operate on one data abstraction than 10 functions
;; on 10 data structures.”

;; A sequence can be constructured with cons function

(def xs (cons 0 '(1 2 3)))
;; => #'user/xs
(first xs)
;; => 0
(rest xs)
;; => (1 2 3)

;; An interesting quirk is that nil can be treated as an empty collection, but the converse is
;; not true.

