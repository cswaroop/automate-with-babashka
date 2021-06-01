(ns sys.config)

(add-lib [integrant "0.8.0"])
(add-lib [integrant/repl "0.3.2"])

(require '[integrant.core :as ig])
(require '[sys.component1])

(def config
  {:adapter/jetty {:port 8080
                   :handler (ig/ref :handler/greet)}
   :handler/greet {:name "Hello"}})

;; can be read from an edn too

{:adapter/jetty {:port 8080,
                 :handler #ig/ref :handler/greet}
 :handler/greet {:name "Alice"}}

(def config
  (ig/read-string (slurp "config.edn")))

(def system
  (ig/init config))


(ns sys.component1)

(require '[ring.adapter.jetty :as jetty]
         '[ring.util.response :as resp])

(defmethod ig/init-key :adapter/jetty [_ {:keys [handler] :as opts}]
  (jetty/run-jetty handler (-> opts (dissoc :handler) (assoc :join? false))))

(defmethod ig/halt-key! :adapter/jetty [_ server]
  (.stop server))


(defmethod ig/init-key :handler/greet [_ {:keys [name]}]
  (fn [_] (resp/response (str "Hello " name))))

