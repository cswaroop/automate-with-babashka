#!/usr/bin/env -S -v cmd-clj '-Sdeps "{:deps {org.clojure/core.async {:mvn/version """"""1.2.603""""""}}}" '

;; You want to decouple your program’s consumers and producers by introducing explicit queues between them.

;;There comes a time in all good programs when components or subsystems must stop communicating directly with one another. — Rich Hickey


(defn database-consumer
  "Accept messages and persist them to a database."
  [msg]
  (println (format "database-consumer received message %s" msg)))
(defn sse-consumer
  "Accept messages and pass them to web browsers via SSE."
  [msg]
  (println (format "sse-consumer received message %s" msg)))
(defn messages
  "Fetch messages from Twitter."
  []
  (range 4))
(defn message-producer
  "Produce messages and deliver them to consumers."
  [& consumers]
  (doseq [msg (messages)
          consumer consumers]
    (consumer msg)))

;;(message-producer database-consumer sse-consumer)



(require '[clojure.core.async :refer [chan sliding-buffer go
                                      go-loop timeout >! <!]])
(defn database-consumer
  "Accept messages and persist them to a database."
  []
  (let [in (chan (sliding-buffer 64))]
    (go-loop [data (<! in)]
      (when data
        (println (format "database-consumer received data %s" data))
        (recur (<! in))))
    in))
(defn sse-consumer
  "Accept messages and pass them to web browsers via SSE."
  []
  (let [in (chan (sliding-buffer 64))]
    (go-loop [data (<! in)]
      (when data
        (println (format "sse-consumer received data %s" data))
        (recur (<! in))))
    in))
(defn messages
  "Fetch messages from Twitter."
  []
  (range 4))
(defn producer
  "Produce messages and deliver them to consumers."
  [& channels]
  (go
    (doseq [msg (messages)
            out channels]
      (<! (timeout 100))
      (>! out msg))))
(producer (database-consumer) (sse-consumer))

(println  (str *out*))
