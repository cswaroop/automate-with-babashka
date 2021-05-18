(require '[babashka.deps :as deps])
(deps/add-deps '{:deps {medley/medley {:mvn/version "1.3.0"}}})

(require '[medley.core :refer [index-by]])
(prn (index-by :id [{:id 1 :foo 1} {:id 2 :foo 2}]))
