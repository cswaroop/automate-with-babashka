(require '[babashka.pods :as pods])

(pods/load-pod 'org.babashka/malli "0.0.1")

(require '[pod.babashka.malli :as m]
         '[pod.babashka.malli.error :as me])

(prn (m/validate [:cat 'int? 'int?] [1 1]))
;; => true

(prn (me/humanize [:cat 'int? 'int?] [1 :foo]))

;; Where are schemas used?
;; ERROR handling
;; - validation and machine-readable errors
;; - two way value transformations
;; - schema transformations
;; - generating values from schemas
;; - As parser!


;; What is malli schema definition like?
;; maps are OPEN by default
;; keys are REQUIRED by default
;; keys are ORDERED
;; HICCUP syntax
(def Address
  [:map
   [:id string?]
   [:tags {optional true} [:set keyword?]]
   [:address
    [:map {:closed true}
     [:street string?]
     [:city string?]
     [:zip {:default "33800"}int?]
     [:latlong
      [:tuple double? double?]]]]])

(def some-invalid-address
  {:id 123
   :tags #{:garage :chicken}
   :address {:streetz "sadfdsf"
             :city "Densapar"
             :latlong [-8.6 115.22]}})

;; Validation of incoming data
(-> Address
    (m/explain some-invalid-address)
    (me/with-spell-checking)            ;helpful only if map is closed
    (me/humanize))

;; Generating values
(require '[malli.generator :as mg])
(mg/generate Address {:size 10, seed 20})


;; ## Registry of schemas
;; -----------------------
;; registry for schema types
;; is passed as explicit option into schema functions
;; default registry has ~100 types :map, :tuple and IMMUTABLE
;; Special JVM/closure compiler to swap the default registry

(def Order
  [:schema
   {:registry {"Country" [:map
                          [:name]
                          [:neighbors]]}}
   "Order"])


;; ## global definitions such as :id is always an string?

[:schema
 [:registry {::id string?
             ::tags [:set keyword?]
             ::street string?
             ::zip int?
             ::latlong [:tuple double? double?]
             :address/address [:map ::street ::city ::zip ::latlong]
             ::address [:map ::id ::tags :address/address]}]
 ::address]

;; local definitions 
[:map
 {:registry {::id string?
             ::tags [:set keyword?]
             ::address [:map
                        {:registry {::street string?
                                    ::city string?
                                    ::zip int?
                                    ::latlong [:tuple double? double?]}}
                        ::street ::city ::zip ::latlong]}}
 ::id ::tags ::address]

;; ## Coercions or two-way data handling across data formats 
;; malli has interceptor-based transformers
;; transforming based on schema type and properties

;; EDN to JSON
(require '[malli.transform :as mt])
(m/decode
 Address
 {:id "123"
  :tags ["garage" "checken"]
  :address {:street ""
            :city ""
            :zip 2122
            :latlong [-8, 115.2]}}
 (mt/json-transformer))

;; transformation chains

;; ## infer schema

(require '[malli.provider :as mp])


;; ## Schema serialization
;; SCI/Edamame  serializes to EDN


;; ## Programming Schemas
;; Schema is data so you can pre and post walk
;; Backed by Schema & LensSchema
;; update-properties, get, assoc, update, get-in, associn, update-in dissoc, select-keys ..

;; Subschemas to flatten the schema suitable for UI
(require '[malli.util :as mu])
(mu/subschemas Address)

(require [malli.schemas :as ms])


