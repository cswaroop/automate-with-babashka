#!/usr/bin/env bb
(require '[hiccup.core :as hiccup]
         '[org.httpkit.server :as server])

(server/run-server 
  (fn [req]
    {:body
     (hiccup/html
       [:html
        [:body
         [:h2 "Welcome to Babashka!"]]])}) 
  {:port 3000})
@(promise)
