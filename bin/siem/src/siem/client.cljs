;; This Source Code Form is subject to the terms of the Mozilla Public
;; License, v. 2.0. If a copy of the MPL was not distributed with this
;; file, You can obtain one at http://mozilla.org/MPL/2.0/

(ns ^:figwheel-hooks siem.client
  (:require [day8.re-frame.http-fx]
            [re-frame.core :as rf]
            [reagent.dom :as rd]
            [siem.client.breadcrumbs :as breadcrumbs]
            [siem.client.home :as home]
            [siem.client.routes :as routes]
            [siem.client.sidebar :as sidebar]
            [siem.client.theme :as theme]
            [siem.client.tooltip :as tooltip]
            [siem.client.tooltip.generic-popup :as tooltip.generic-popup]
            [siem.client.tooltip.loading-popup :as tooltip.loading-popup]
            [siem.client.view :as view]))

(def default-db
  {:theme :light})

(rf/reg-event-fx
 ::load-app
 (fn [_ _]
   {:db default-db}))

(defn app []
  (let [theme (rf/subscribe [::theme/get-theme])]
    (fn []
      [:div.app-container
       {:on-click #(tooltip/destroy-on-click-out (.. % -target))
        :class (str "theme-" (name @theme))}
       [sidebar/main]
       [:div.app-container__main
        {:id "app-container__main"}
        [breadcrumbs/main]
        [view/main]]
       [tooltip.loading-popup/main]
       [tooltip.generic-popup/main]])))

(defn main []
  [app])

;; Make log level logs no-ops for production environment.
(rf/set-loggers! {:log (fn [& _])})

(defn dev-setup []
  (when goog.DEBUG
    ;; Reenable log level logs no-ops for dev environment.
    (rf/set-loggers! {:log js/console.log})
    (enable-console-print!)
    (println "Dev mode")))

(defn mount-root []
  (rf/clear-subscription-cache!)
  (rd/render [main] (.getElementById js/document "app")))

(defn ^:after-load re-render []
  (mount-root))

(defn ^:export init []
  (dev-setup)
  (rf/dispatch-sync [::load-app])
  (routes/app-routes)
  (mount-root))
