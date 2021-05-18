(ns fizz
  (:require [clojure.string :as str]))

(defn n->str [n]
  (let [by-5? (zero? (mod n 3))
        by-3? (zero? (mod n 5))]
    (cond
      (and by-3? by-3?) "Fizz Buzz"
      by-3? "Fizz"
      by-5? "Buzz"
      :else (str n))))

(defn -main []
  (->> (range 1 101)
       (map n->str)
       (str/join ", ")
       (println)))
(def m 52)
(def n 39)

(defn hcf [m n]
  (print m n)
  (let [
        a (max m n)
        b (min m n)
        r (mod a b)]
    (if (not= r 0)
      (recur b r)
      b) ))
(hcf 52 39)

(hcf 2 5)

(defn lcm [m n]
  (/ (* m n) (hcf m n)))

(hcf 52 39)
(lcm 52 39)

(defn gcd [a b]
        (if (zero? b)
          a
          (recur b (mod a b))))


(println "Hello")

(defn gcd
  [a b]
  (last
    (filter
      #(and (zero? (mod b %)) (zero? (mod a %)))
      (range 1 (inc (min a b)))
      )
    )
  )
(gcd 52 39)
(print *1)

(do
  (print "hello")
  (range 10))






(ns mrhaki.string.format
  (:require [clojure.test :refer [is]])
  (:import (java.util Locale)))

(in-ns 'mrhaki.string.format')

(is (= "https://www.mrhaki.com/"
       (format "https://%s/" "www.mrhaki.com")))

(clojure.repl/dir clojure.test)
