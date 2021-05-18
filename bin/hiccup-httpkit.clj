(require '[hiccup.core :as h]
         '[org.httpkit.server :as srv])

(def html1 (h/html [:p "hello" [:a {:href "foo"} "link"]]))

(srv/run-server (fn [_] {:body html1})
                {:port 8090})
@(promise)
