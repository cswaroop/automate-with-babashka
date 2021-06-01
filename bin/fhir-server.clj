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
 '[org.httpkit.client :as client])

(deps/add-deps '{:deps {ring/ring {:mvn/version "1.9.1"}
                        ring/ring-defaults {:mvn/version "0.3.2"}
                        ring-webjars {:mvn/version"0.2.0"}
                        metosin/reitit {:mvn/version "0.5.5"}
                        metosin/muuntaja {:mvn/version "0.6.7"}
                        metosin/ring-http-response {:mvn/version "0.9.1"}
                        selmer {:mvn/version "1.12.29"}
                        datascript/datascript {:mvn/version "1.0.1"}
                        org.clojure/math.combinatorics {:mvn/version "0.1.6"}
                        seancorfield/next.jdbc {:mvn/version "1.1.610"}}})


