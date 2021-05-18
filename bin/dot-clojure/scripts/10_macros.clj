;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;            read-eval loop           ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(+ 1 2 3)
;; => 6
(read-string "(+ 1 2 3)")
;; => (+ 1 2 3)
(class (read-string "(+ 1 2 3)"))
;; => clojure.lang.PersistentList
(eval (read-string "(+ 1 2 3)"))
;; => 6
(class (eval (read-string "(+ 1 2 3)")))
;; => java.lang.Long
(let [exp (read-string "(+ 1 2 3 4)")]
  (cons (read-string "*")
        (rest exp)))
;; => (* 1 2 3 4)


;; special-forms -> Macros -> Functions
;; 16-special forms available at compile time e.g. if, let, do, and, def, quote, var, fn, set!, ., loop/recur, try/throw/catch/finally, monitor-enter/monitor-exit
;; Macros to deal at compile time e.g. when, case, cond, condp, or, defn, defprotocol, deftype
;; Functios to deal at run time

(let [exp '(+ 1 2 3 4)]
  (cons '* (rest exp)))
;; => (* 1 2 3 4)

(defmacro assert [x]
  (when *assert* ;; check the dynamic var `clojure.core/*assert*` to make sure
    ;; assertions are enabled
    (list 'when-not x
          (list 'throw
                (list 'new 'AssertionError
                      (list 'str "Assert failed: "
                            (list 'pr-str (list 'quote x))))))))


(println *in*)
(println *ns*)

(defn- open-url-in-swing
  [url]
  (let [htmlpane (javax.swing.JEditorPane. url)]
    (.setEditable htmlpane false)
    (.addHyperlinkListener htmlpane
                           (proxy [javax.swing.event.HyperlinkListener] []
                             (hyperlinkUpdate [^javax.swing.event.HyperlinkEvent e]
                               (when (= (.getEventType e) (. javax.swing.event.HyperlinkEvent$EventType ACTIVATED))
                                 (if (instance? javax.swing.text.html.HTMLFrameHyperlinkEvent e)
                                   (-> htmlpane .getDocument (.processHTMLFrameHyperlinkEvent e))
                                   (.setPage htmlpane (.getURL e)))))))
    (doto (javax.swing.JFrame.)
      (.setContentPane (javax.swing.JScrollPane. htmlpane))
      (.setBounds 32 32 700 900)
      (.setVisible true))))
(start-server)
