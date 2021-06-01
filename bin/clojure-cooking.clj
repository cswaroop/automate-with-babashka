(ns clojure.cookbook.primitive-data)

;; ## Primitive Data
;; 1.20
;; ### Calcualte simple statistics like mean, median, mode on a collectin of numbers

(defn mean
  "Average of a number collection"
  [coll]
  (let [sum (apply + coll)
        count (count coll)]
    (if (pos? count)
      (/ sum count)
      0)))

(mean [1 2 3 4])
;; => 5/2

(defn median
  "middle value of a number collection"
  [coll])

(defn mode
  "most frequently occuring item  in a collection.  Collection can be anything."
  [coll])
;; ## Composite Data

(ns clojure.cookbook.composite-data)

;; ## General Computing

(ns clojure.cookbook.general-computing)


;; ## Local I/O

;; ## Network I/O and WebServices

;; ## Databases

;; ## Web Applications

;; ## Performance and Production

;; ## Distributed Computing

;; ## Testing

