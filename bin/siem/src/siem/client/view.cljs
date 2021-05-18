;; This Source Code Form is subject to the terms of the Mozilla Public
;; License, v. 2.0. If a copy of the MPL was not distributed with this
;; file, You can obtain one at http://mozilla.org/MPL/2.0/

(ns siem.client.view
  (:require [re-frame.core :as rf]))

(rf/reg-sub
 ::active-view
 (fn [db]
   (get db :active-view)))

(rf/reg-event-db
 ::set-active-view
 (fn [db [_ active-view]]
   (assoc db :active-view active-view)))

(defn redirect! [loc]
  (set! (.-location js/window) loc))

(rf/reg-fx
 :redirect
 (fn [loc]
   (redirect! loc)))

(defmulti view-display #(when (vector? %) (first %)))

(defmethod view-display :default
  [_]
  [:div "No content :("])

(defn main
  []
  (let [active-view (rf/subscribe [::active-view])]
    (fn []
      (view-display @active-view))))
