(ns sixdegrees)

(defrecord Graph
    [neighbors data])

(def empty-graph (Graph. {} {}))

(defn neighbhors [g x]
  ((:neighbors g) x))

(defn subgraph [graph vertext-set])




