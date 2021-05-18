(ns core
  (:require [malli.core :as m]))


(def IntMap
  ;; key がキーワード、 value が整数であるマップの定義
  ;; キーワードとシンボルからなるただのデータ
  [:map-of :keyword 'int?])
  

(m/validate IntMap {:foo 1}) ; => true
(m/validate IntMap {:foo "bar"}) ; => false
