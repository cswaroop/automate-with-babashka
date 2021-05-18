(ns user
  (:require [liq.modes.typeahead-mode :as typeahead-mode]
            [clojure.string :as str]
            [liq.editor :as editor]
            [liq.buffer :as buffer]))

(javax.swing.JOptionPane/showMessageDialog nil "Hello")



(def res (atom ""))
#_(typeahead-mode/run ["apple" "ananas" "pineapple" "grape" "kiwi"]
                         str
                        #(reset! res %))
#_(deref res)

(editor/add-key-bindings :fundamental-mode :normal
      {"-" {"r" #(editor/message (rand-int 100))}})

(editor/set-command :showtime #(editor/message (str "hello")))


(+ (+ 1 2) 3)

(map)

ClojureScript

https://www.youtube.com/watch?v=tRYreGS53Z4
