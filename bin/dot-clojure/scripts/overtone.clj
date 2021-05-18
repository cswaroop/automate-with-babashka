#!/usr/bin/env -S -v cmd-clj '-Sdeps "{:deps {nrepl {:mvn/version  """"""0.7.0""""""} cider/cider-nrepl {:mvn/version """"""0.25.2""""""} overtone  {:mvn/version """"""0.10.6""""""}}}" -m nrepl.cmdline --middleware [""""""cider.nrepl/cider-middleware""""""]'

(ns test.core
  (:use [overtone.live]
        [overtone.inst.piano]))
(use 'overtone.core)

(boot-external-server)
(connect-external-server 57110)
(demo (sin-osc))
(defn p
  [chord delay]
  (doseq [f chord]
    (piano f)
    (Thread/sleep
      (* delay 100))))
(def pattern
  [:A4 :B4 :C5 :D5])
(defn builder
  [chord-pattern m-or-m]
  (->> chord-pattern
       (map
         #(chord % m-or-m))
       flatten))
(def pattern-1
  (builder pattern :minor))
(def pattern-2
  (reverse pattern-1))
(def melody
  (flatten
    (repeat 2 [pattern-1
               pattern-2])))
(p melody 3)
;; Quil

(defsketch drawing
  :title "Book Example"
  :setup (fn [] (smooth))
  :draw (fn []
          (stroke-weight 9)
          (line 100 50 100 100))
  :size [200 200])

(def right (atom 55))
(defsketch drawing
  :title "Book Example"
  :setup (fn []
           (smooth)
           (frame-rate 3))
  :draw (fn []
          (let [x2 (do (swap! right inc)
                       @right)]
            (stroke-weight 9)
            (line 50 100 x2 100)))
  :size [200 200])
