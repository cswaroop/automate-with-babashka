#!/usr/bin/env bb

;; Read a CSV file and load into topic in Kafka docker instance!


;; read the file path of our CSV and the key field from the command line args
(def csv-file-path (first *command-line-args*))
(def key-field (second *command-line-args*))

;; read the CSV line-by-line into a data structure
(def csv-data
  (with-open [reader (io/reader csv-file-path)]
    (doall (csv/read-csv reader))))

(def headers (first csv-data))
(def body (rest csv-data))

;; For each line in the body, create a map with the headers as the keys
(def values
  (->> body
       (map (partial zipmap headers))
       ;; if you need to do any additional processing on each line, do it here
       ))

(def output-lines
  (->> values
       (map #(str (get % key-field) "::" (json/generate-string %)))))

(doseq [output output-lines]
  (println output))


;;docker run --rm -p 2181:2181 -p 9092:9092 --env ADVERTISED_HOST=localhost -d spotify/kafka


;;docker run --rm --net=host confluentinc/cp-kafka kafka-topics --create --topic csv-data --replication-factor 1 --partitions 15 --bootstrap-server localhost:9092

;; bb csv-to-kafka.clj dummy-data.csv id | docker run --net=host --rm -i confluentinc/cp-kafka kafka-console-producer --broker-list localhost:9092 --topic csv-data --property "parse.key=true" --property "key.separator=::"

;; docker run --rm --net=host -t edenhill/kafkacat:20190711 -b localhost:9092 -t csv-data -e -f "%k :: %s\n" -q



;; (Note that when you want to consume this data in an application, you should use the String Serde as the key serde and a JSON Serde as the value serde)
