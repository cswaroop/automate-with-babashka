(defn- merge-or-replace
  "if maps, merge, otherwise replace"
  [& vals]
  (when (some identity vals)
    (reduce (fn [ret vals]
              (if (and (map? ret) (map? val))
                (merge ret val)
                (or val ret)))
            nil vals)))

(defn merge-edns
  "Merge deps edn maps from left to right into a single string"
  [deps-edn-maps]
  (apply merge-with merge-or-replace (remove nil? deps-edn-maps)))

(def deps1 '{:aliases {:base {:default-deps {medley/medley {:mvn/version "1.3.0"}}}}})

(def deps2 '{:deps {:medley/medley nil}})

(def deps (merge-edns [deps1 deps2]))

(require '[babashka.deps :as deps])

(deps/clojure deps "-A:base")
