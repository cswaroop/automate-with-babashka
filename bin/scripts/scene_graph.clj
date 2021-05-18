;; This is a defold game editor's Graph

;; # The Graph
;; ## Properties
;; - Node with Properties
;; - labeled, typed input
;; - labeled, typed output
;; 
;; ## Graph operations
;; - Pull an output with node-value
;; - Alter via`transact`

;; 
(defn empty-graph
  []
  {:nodes {} ;;
   :sarcs {}
   :tarcs {}
   :successors {}
   :tx-id 0})

