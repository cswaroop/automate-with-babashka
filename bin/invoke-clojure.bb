(require '[babashka.deps :as deps])

(some->
        (deps/clojure ["-Sdeps" '{:deps {medley/medley {:mvn/version "1.3.0"}}}])
        deref)


(require '[medley.core :refer [index-by]])
(prn (index-by :id [{:id 1 :foo 1} {:id 2 :foo 2}]))
