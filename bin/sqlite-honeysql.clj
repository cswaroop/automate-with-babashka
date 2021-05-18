(ns example
  (:require [babashka.deps :as deps]
            [babashka.pods :as pods]))

(pods/load-pod 'org.babashka/go-sqlite3 "0.0.1")
(deps/add-deps '{:deps {seancorfield/honeysql {:mvn/version "2.0.0-alpha2"}}})

(require '[pod.babashka.go-sqlite3 :as sqlite]
         '[honey.sql :as sql]
         '[honey.sql.helpers :as h]
         '[clojure.java.io :as io]
         '[clojure.pprint :as pp])



#_(def create-sql
    (sql/format
     (-> (h/create-table :animal)
         (h/with-columns [[:name :text]
                          [:scientific-name :text]]))))
(defn create-db! []
  (when (not (.exists (io/file db)))
    (let [sql (sql/format
               (-> (h/create-table :animals)
                   (h/with-columns [[:name :text]
                                    [:scientific-name :text]])))]
      (sqlite/execute! db sql))))

(defn insert-sql [animals]
  (sql/format (-> (h/insert-into :animals)
                  (h/values animals))))

(defn insert-rows! [animals]
  (sqlite/execute! db (insert-sql animals)))


(defn all-animals []
  (sqlite/query db ["SELECT * FROM animals"]))


;; __name__ = "__main__"

(def db "/tmp/analysis.db")
(when (= *file* (System/getProperty "babashka.file"))
  (.delete (io/file db))
  (create-db!)
  (insert-rows! [{:name "Bison" :scientific-name "Bos gaurus"}
                 {:name "Duck" :scientific-name "Anas Platyrhynchos"}])
  (pp/print-table (all-animals)))
