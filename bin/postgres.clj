#!/usr/bin/env bb

;; https://book.babashka.org/
;; https://github.com/babashka/babashka

(require ;; babashka
         '[babashka.deps :as deps]
         '[babashka.pods :as pods]
         '[babashka.classpath :as cp]
         '[babashka.process :as p]
         '[babashka.fs :as fs]
         '[babashka.curl :as curl]
         '[bencode.core :as bencode]
         ;; clojure
         '[clojure.string :as str]
         '[clojure.set :as set]
         '[clojure.zip :as zip]
         '[clojure.test :refer [deftest]]
         '[clojure.test.check :as tc]
         '[clojure.test.check.generators :as tgen]
         '[clojure.test.check.properties :as tprop]
         '[clojure.java.shell :as shell]
         '[clojure.java.io :as io]
         '[clojure.java.browse :as browse]
         '[clojure.edn :as edn]
         '[clojure.data.csv :as csv]
         '[clojure.data.xml :as xml]
         '[clojure.pprint :refer [pprint print-table cl-format]]
         '[clojure.core.async :as async]
         '[clojure.core.match :as match]
         '[clojure.tools.cli :as tools.cli]
         ;; others
         '[cheshire.core :as json]
         '[clj-yaml.core :as yaml]
         '[cognitect.transit :as transit]
         '[hiccup.core :as html]
         '[org.httpkit.server :as server]
         '[org.httpkit.client :as client]
         )
;; Pods
(pods/load-pod 'org.babashka/postgresql "0.0.1")
(require '[pod.babashka.postgresql :as pg])

;; additional libs
(deps/add-deps '{:deps {seancorfield/honeysql {:mvn/version "2.0.0-alpha2"}
                        medley {:git/url "https://github.com/borkdude/medley"
                                :sha "91adfb5da33f8d23f75f0894da1defe567a625c0"}
                        aero/aero {:mvn/version "1.1.6"}}})
(require '[honey.sql :as sql]
         '[honey.sql.helpers :refer :all :as helpers])



;; Initialization

(def db {:dbtype   "postgresql"
         :host     "localhost"
         :dbname   "postgres"
         :user     "postgres"
         :password ""
         :port     5432})

(honey.sql/set-dialect! :ansi)


;; Database setup

(pg/execute! db ["select version()"])


;; Create a table
;; https://github.com/seancorfield/honeysql/blob/v2/test/honey/sql/postgres_test.cljc
#_(pg/execute!
 db
 (-> (create-table :products)
     (with-columns [[:product_no :integer]
                    [:name :text]
                    [:price :numeric [:check [:> :price 0]]]
                    [:discounted_price :numeric]
                    [[:check [:and [:> :discounted_price 0]
                              [:> :price :discounted_price]]]]])
     sql/format))

;; Insert
#_(sql/format {:select [:product_no]
             :from [:products]
             :where [:= :product_no 1]})


#_(doseq [stmt fhir-funcs]
  (pg/execute!
   db
   [stmt]))

(pg/execute!
 db
 ["SELECT fhirbase_create1('{\"resourceType\": \"Patient\", \"id\": \"pt1\"}'::text, 20)::text"])


;; https://github.com/dakrone/cheshire

