(ns user)
(defn map2arg-
  "Create mysql command line argument from connection map"
  [mdb arg key]
  (str arg (get mdb key)))

(defn make-mysql-command-
  "Create mysql command line using connection map and statement"
  [mdb statement]
  ["psql"
   (map2arg- mdb "-h" :host)
   (map2arg- mdb "-u" :user)
   (map2arg- mdb "-p" :password)
   (:dbname mdb) "--column-names" "-e" statement ])

(defn query
  "Executes a query agatinst the command line mysql. Return is a vector of maps with populated with each row."
  [ mdb statement ]
  (let [
        mysql-command (make-mysql-command- mdb statement)
        table-as-str (:out (apply shell/sh mysql-command))
        table-as-lines (str/split-lines table-as-str)
        table-headers (str/split (first table-as-lines) #"\t")
        table-as-maps (map #(zipmap table-headers (str/split %1 #"\t")) (rest table-as-lines))
        ]
    table-as-maps
    ))


(def mdb {:dbtype "postgres"
          :dbname "postgres"
          :host "localhost"
          :user "postgres"
          :password "postgres"})


(def rows (query mdb "select TABLE_NAME, ENGINE from information_schema.tables limit 3"))


(clojure.pprint/print-table rows)
