;; This Source Code Form is subject to the terms of the Mozilla Public
;; License, v. 2.0. If a copy of the MPL was not distributed with this
;; file, You can obtain one at http://mozilla.org/MPL/2.0/

(ns siem.client.routes
  (:require-macros [secretary.core :refer [defroute]])
  (:import goog.History)
  (:require [goog.events]
            [goog.history.EventType :as EventType]
            [re-frame.core :as rf]
            [secretary.core :as secretary]
            [siem.client.home :as home]
            [siem.client.hydrogen-demo.shop :as hydrogen-demo.shop]
            [siem.client.hydrogen-demo.shop-item :as hydrogen-demo.shop-item]
            [siem.client.view :as view]))

(defn hook-browser-navigation! []
  (doto (History.)
    (goog.events/listen EventType/NAVIGATE #(secretary/dispatch! (.-token %)))
    (.setEnabled true)))

(defn- compose-nav-evt
  [direction [view-key & argv]]
  {:pre [(#{:enter :leave} direction)]}
  (let [evt-key (if (namespace view-key)
                  (keyword
                   (namespace view-key)
                   (str (name view-key) "." (name direction)))
                  (keyword
                   (str (name view-key) "." (name direction))))]
    (vec (cons evt-key argv))))

(defn- go-to-handler
  "This handler takes a vector for new view to navigate to.
  That vector has min. arity 1 - a keyword identifying a view.
  By convention we recommend using a namespaced one with 'view' as a name (e.g. ::shop/view).
  The optional remaining arguments of that view vector are arguments to the view.

  Then this handler composes up to two event handlers and dispatches them:
  - New view always is composed into ::*/view.enter event
  - Previously active view (if present) is composed into ::*/view.leave event

  That said, each namespace introducing a new view need to have both ::view.enter and ::view.leave
  events defined."
  [{:keys [db]} [_ new-view]]
  (let [enter-evt (compose-nav-evt :enter new-view)
        leave-evt (when-let [active-view (:active-view db)]
                    (compose-nav-evt :leave active-view))]
    {:dispatch-n [leave-evt
                  enter-evt]}))

(rf/reg-event-fx :go-to go-to-handler)

(defn app-routes []
  (secretary/set-config! :prefix "#")
  ;; --------------------
  ;; define routes here

  (defroute "/home" []
    (rf/dispatch [:go-to [::home/view]]))

  (defroute "/shop" []
    (rf/dispatch [:go-to [::hydrogen-demo.shop/view]]))

  (defroute "/shop/:item-id" [item-id]
    (rf/dispatch [:go-to [::hydrogen-demo.shop-item/view item-id]]))

  (defroute "*" []
    (view/redirect! "/#/home"))

  ;; --------------------
  (hook-browser-navigation!))
