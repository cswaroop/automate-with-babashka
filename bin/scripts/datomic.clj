;; ## Datomic
;; Datomic technologies
;; ### Datalog
;; [:find variables
;; :where clauses]

;; #### Q-1
[:find ?e
 :where [?e :age 42]]

;; #### Q-2
;; Unification
[:find ?e ?x
 :where [?e :age 42] [?e :likes ?x]]

;; #### Q-3
;; [:find ?x]

;; ### Pull API
;; Also known as EQL in Fulcro.

;; #### EQL-1
;; Attribute Name
[:artist/name :artist/gid]
;; #### EQL-2
;; Reverse Lookup
;; pattern
[:artist/_country]
;; result
{:artist/_country [{:db/id 232323}
                   {:db/id 23232}]}
;; #### EQL-3
;; Map Specification
;; pattern
[:track/name {:track/artists [:db/id :artist/name]}]

;; #### EQL-4
