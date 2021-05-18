(ns repl)

;; Modeling the Trunk of the system with Integrant
;; https://skillsmatter.com/skillscasts/9820-enter-integrant-a-micro-framework-for-data-driven-architecture-with-james-reeves

;; Integrant is data driven achieved through clojure multi methods (keyword inheritance)
;; Integrant and Ring are from weavejester/james-reeves

;; Here is a system that we want to model
;; Bootstrapping a system from configuration has similarity of knowledge development
;; How to build knowledge https://fs.blog/2015/01/elon-musk-knowledge/
(def database
  (db/connect "jdbc:sqlite:"))

(defn handler [request]
  (resp/response (query-status database)))

(defn -main []
  (jetty/run-jetty handler {:port 8080}))


;; Now lets extract the above setup as configuration using multi methods

{:database.sql/connection
 {:uri "jdbc:sqlite:"}
 :example/handler
 {:database #ref :database.sql/connection}
 :ring.adapter/jetty
 {:handler #ref :example/handler
  :port    8080}}

(defmethod ig/init-key :database.sql/connection)
(defmethod ig/init-key :ring.adapter/jetty)
(defmethod ig/init-key :example/handler)


;; Now dependency graph needs to be built and do topological ordering

;;

;; Using spec to validate the keys


;; [https://github.com/PrestanceDesign/usermanager-reitit-integrant-example/blob/master/src/usermanager/system.clj]
