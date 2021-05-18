;; This Source Code Form is subject to the terms of the Mozilla Public
;; License, v. 2.0. If a copy of the MPL was not distributed with this
;; file, You can obtain one at http://mozilla.org/MPL/2.0/

(ns siem.client.home
  (:require [re-frame.core :as rf]
            [siem.client.breadcrumbs :as breadcrumbs]
            [siem.client.view :as view]))

(rf/reg-event-fx
 ::view.enter
 (fn [_ _]
   {:dispatch-n [[::view/set-active-view [::view]]
                 [::breadcrumbs/set []]]
    :redirect "/#/home"}))

(rf/reg-event-fx
 ::view.leave
 (fn [_ _]
   {}))

(defn main []
  [:div
   [:img {:src "images/hydrogen-logo-white.svg" :alt "Hydrogen logo"}]
   [:h1.demo-greeting "Welcome to Hydrogen!"]])

(defmethod view/view-display ::view
  [_]
  [main])
