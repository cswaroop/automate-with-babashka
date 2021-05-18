#!/usr/bin/env -S -v cmd-clj '-Sdeps "{:deps {nrepl {:mvn/version  """"""0.7.0""""""} cider/cider-nrepl {:mvn/version """"""0.25.2""""""} org.clojure/core.logic {:mvn/version """"""1.0.0""""""}}}" -m nrepl.cmdline --middleware [""""""cider.nrepl/cider-middleware""""""]'


;;
;;
;;  Concept Design
;;
;;


;;  Every function is a little Program
;; A pure function
;; Floor-to-roof aka bottom-up development (OnLisp, Pau Graham)
;; Each function does only one thing
;; DRY-KISS-AGNI

;; example function
(defn example
  [is-true? is-false?]
  (when (true? is-true?)
    (when (false? is-false?)
      (println "two space indent"))))

(example ["M.Fogus"
          "R.Hickey"
          "C.Emerick"]
         ["J.Rogan"
          "D.Stanhope"
          "B.Burr"])
(let [x 1
        y 2
        z (+ x y)]
  (apply + [x y z]))
;; Methods of Abstraction

(definterface ICan
  (^String canSize [])
  (^String openCan [])
  (^String getLabel [])) ;; => user.ICan
(deftype Can [contents can-size]
  ICan
  (canSize [_] (name can-size))
  (openCan [_] (name contents))
  (getLabel [_] (format "A %s can of %s" (name can-size) (name contents))));; => user.Can

(def c (Can. :Apples :small)) ;; => #'user/c
(type c) ;; => user.Can
(.canSize c);; => "small"
(.getLabel c);; => "A small can of Apples"

;; Records, Protocols and Type extensions

(defrecord Not-A-Can [x y])
;; => user.Not-A-Can
(def nac (Not-A-Can. 1 2))
;; => #'user/nac
(type nac);; => user.Not-A-Can
nac;; => #user.Not-A-Can{:x 1, :y 2}
[(:x nac) (:y nac)];; => [1 2]


(defprotocol PCan
  (can-size [_])
  (open-can [_])
  (label [_]));; => PCan
(keys PCan);; => (:on :on-interface :sigs :var :method-map :method-builders)
(:sigs PCan)
;; => {:can-size {:name can-size, :arglists ([_]), :doc nil}, :open-can {:name open-can, :arglists ([_]), :doc nil}, :label {:name label, :arglists ([_]), :doc nil}}
(keys (:sigs PCan))
;; => (:can-size :open-can :label)

(extend-type Not-A-Can
  PCan
  (can-size [_] (:x _))
  (open-can [_] "Not really a can sorry")
  (label [_] (str "Example: " (:x _) (:y _))));; => nil

(can-size nac);; => 1
(label nac);; => "Example: 12"
(open-can nac);; => "Not really a can sorry"

(extend-protocol PCan
  String
  (can-size [_] "small")
  (open-can [_] _)
  (label [_] "Can of java.lang.String")
  Integer
  (can-size [_] "mini")
  (open-can [_] _)
  (label [_] _))
;; => nil

(extends? PCan String);; => true
(extends? PCan Float);; => false
(can-size (int 1));; => "mini"

(defrecord Can [contents size]
  PCan
  (can-size [_] (name (:size _)))
  (open-can [_] (name (:contents _)))
  (label [_] (format "A %s can of %s"
                     (can-size _)
                     (open-can _))));; => user.Can

(def apple-can (Can. :Apples  :small));; => #'user/apple-can
(doseq [_ (extenders PCan)] (println _));; => nil
(satisfies? PCan (int 1));; => true

;;
;;
;; Reify
;;
;;

(defprotocol PCan
  (can-size [_])
  (open-can [_])
  (label [_]))
;; => PCan

(let [local-can (reify PCan
                  (open-can [_] "tuna")
                  (can-size [_] "tiny")
                  (label [_] "Tuna in water"))
      open-msg (format "Opening a %s can of %s"
                       (can-size local-can)
                       (open-can local-can))
      discover-msg (format "I found a can of %s"
                           (.toLowerCase (label local-can)))]
  (format "%s\n%s"
          discover-msg
          open-msg))
;; => "I found a can of tuna in water\nOpening a tiny can of tuna"

(defrecord Can [contents size]
  PCan
  (can-size [_] (name (:size _)))
  (open-can [_] (name (:contents _)))
  (label [_] (format "A %s can of %s"
                     (can-size _)
                     (open-can _))));; => user.Can

(def orange-can (atom (Can. :oranges :large)))
;; => #'user/orange-can

(defn eat-contents! [can-atom]
  (let [{:keys [size contents]} @can-atom
        size (name size)
        contents (name contents)]
    (reset! can-atom
            (reify PCan
              (open-can [_] "empty")
              (can-size [_] size)
              (label [_]
                (format "(Empty) A %s can of %s"
                        size
                        contents))))));; => #'user/eat-contents!
(defn eat-canned-food! [can-atom]
  (println
    (format "Eating a can of %s"
            (open-can @can-atom)))
  (eat-contents! can-atom)
  :ate)
;; => #'user/eat-canned-food!
(open-can @orange-can);; => "oranges"
(eat-canned-food! orange-can);; => :at
(open-can @orange-can);; => "empty"

;;
;;
;;  Proxy
;;
;;
(definterface IBox
  (^Float length [])
  (^Float width [])
  (^Float height [])
  (^Float volume []))
;; => user.IBox
(type IBox)
;; => java.lang.Class
(defn box [l w h]
  (proxy [IBox] []
    ;; the empty vec after [IBox] means that no arguments
    ;; are being passed to the class constructor
    (length [] (float l))
    (width [] (float w))
    (height [] (float h))
    (volume [] (apply * (map float [l w h])))))
;; => #'user/box
(let [b (box 1.0 2.0 3.0)]
  (println "Length:" (.length b)
           "Width:" (.width b)
           "Height:" (.height b)
           "Volume:" #_(.volume b)))
;;
;;
;; Macros
;;
;; 
(defprotocol PUser
  (real-name [_])
  (mod? [_])
  (admin? [_]))
(defrecord User [name mod? admin?]
  PUser
  (real-name [_] (:name _))
  (mod? [_] (:mod? _))
  (admin? [_] (:admin? _)))
(defmacro defuser [-symbol name & [mod? admin?]]
  `(def ~-symbol
     ~(User. name
             (boolean mod?)
             (boolean admin?))))
(clojure.pprint/pprint
  (macroexpand-1
    '(defuser user2 "Kevin Pereira" true false)))

(def user2 {:name "Kevin Pereira", :mod? true, :admin? false})

(definterface IPhone
  (^Number number [])
  (^Boolean acceptIncoming [])
  (^Boolean connected []))

(defmacro defphone
  [-symbol
   -number
   accept-incoming?
   connected?]
  ;; the empty vector after [IPhone] states that no arguments
  ;; are being passed to the class constructor
  (let [phone (proxy [IPhone] []
                (number [] -number)
                (acceptIncoming [] (boolean accept-incoming?))
                (connected [] (boolean connected?)))]
    `(def ~-symbol ~phone)))
(defphone phone1 5551115555 true true)
(.number phone1) ;; => 5551115555
(deftype PhoneType [phone-num]
  IPhone
  (number [_] phone-num)
  (acceptIncoming [_] true)
  (connected [_] true))

(defmacro defphone-type [-symbol -number]
  `(def ~-symbol (PhoneType. ~-number)))
(defphone-type phone2 2222)
(type phone1);; => user.proxy$java.lang.Object$IPhone$2738a7b9
(type phone2);; => user.PhoneType
(.number phone2);; => 2222

;;
;;
;; Multi-methods
;;
;;

(defmulti customer-drinks
  (fn [customer bottle]
    [(if (:sweet? bottle) :sweet :not-sweet)
     (if (:carbonated? bottle) :carbon :no-carbon)
     (:drinks-sweet? customer)
     (:drinks-carbonated? customer)]))

(defmethod customer-drinks
  [:sweet :no-carbon true false]
  [customer bottle]
  (println "Yum! This is sweet and non-carbonated."))
(defmethod customer-drinks
  [:not-sweet :no-carbon false false]
  [customer bottle]
  (println "This is non-sweet and non-carbonated."))
(defmethod customer-drinks
  [:not-sweet :carbon false true]
  [customer bottle]
  (println "I love unsweet and carbonated drinks."))
(defmethod customer-drinks
  [:sweet :carbon true true]
  [customer bottle]
  (println "This is bad for me, but I'll drink it."))

(defrecord Bottle [type sweet? carbonated?])
(defmacro defdrink [s type sweet? carbonated?]
  `(def ~s
     ~(Bottle. type
               sweet?
               carbonated?)))
(defrecord Customer
    [drinks-sweet?
     drinks-carbonated?])
(defmacro defcustomer
  [s
   drinks-sweet?
   drinks-carbonated?]
  `(def ~s
     ~(Customer. drinks-sweet?
                 drinks-carbonated?)))
(defmethod customer-drinks
  :default
  [customer _]
  (if-not (= Customer (type customer))
    (println "This isn't a customer")
    (if (not= Bottle (type _))
      (println "I don't know if I should drink this.")
      (let [{:keys [drinks-sweet? drinks-carbonated?]}
            customer
            sweet-msg (if drinks-sweet?
                        "sweet"
                        "non-sweet")
            carb-msg (if drinks-carbonated?
                       "carbonated"
                       "non-carbonated")
            msg (format "I can only have a %s %s drink."
                        sweet-msg
                        carb-msg)]
        (println msg)))))
(defdrink orange-juice :orange-juice true false)
(defdrink generic-soda :generic-soda true true)
(defdrink carbon-water :carbon-water false true)
(defdrink cold-coffee :cold-coffee false false)

(defcustomer customer1 true false)
(defcustomer customer2 true true)
(defcustomer customer3 false true)
(defcustomer customer4 false false)

orange-juice
;; => #user.Bottle{:type :orange-juice, :sweet? true, :carbonated? false}
customer1
;; => #user.Customer{:drinks-sweet? true, :drinks-carbonated? false}

(customer-drinks customer1 "not a bottle");; => ni
(customer-drinks 1 2)
;; => nil
(customer-drinks customer2 orange-juice);; => nil

(def indian-startups
  {"Dhruva" {:ceo "Jaspreet Singh"
             :tags #{["Cloud" "Data Security"]}}})

;; Clojure Cheatsheet
;; 
;; https://clojure.org/api/cheatsheet
