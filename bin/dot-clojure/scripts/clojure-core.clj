#!/usr/bin/env bb

;; A subset of clojure core that runs in  Babashka

(require '[clojure.repl :as repl])
(require '[clojure.string :as str])

;; (clojure.repl/dir clojure.core)
{:id 23
:issue-date "2020-06-14"
:customer {:name "Foo bar industries"}}

(defn make-product-1 [serial & {:keys [product-name price description]
                              :or {product-name "" price nil descripton "description not available"}}]
{:serial-no serial
  :product-name  product-name
  :price price
  :description description})

;; We never make a map with empty values for keys.  Its anti-pattern.  However for illustration
( make-product-1 "000-0011")
;; => {:description nil, :product-name "", :serial-no "000-0011", :price nil}
(require '[clojure.math.numeric-tower :as math])

(cons 4 '())
;; => (4)

(cons 5 nil)
;; => (5)

(cons 4 (cons 5 nil))
;; => (4 5)

'(1 2 3 4)
;; => (1 2 3 4)

(list 1 2 3 4)
;; => (1 2 3 4)

[:cookie-jar 001 :chocolate  'biscuit "ice-create"]
;; => [:cookie-jar 1 :chocolate biscuit "ice-create"]

(nth [:jar1 1 2 3 :jar2] 0)
;; => :jar1

(last [:rabbit :pocket-watch :marmalade])
;; => :marmalade

(conj '(:toast :butter) :jam)
;; => (:jam :toast :butter)

(keys {:jam1 "strawberry" :jam2 "blackberry" :jam3 "marmalade"})
;; => (:jam3 :jam2 :jam1)

(vals {:jam1 "strawberry" :jam2 "blackberry" :jam3 "marmalade"})
;; => ("marmalade" "blackberry" "strawberry")

(merge {:jam1 "red" :jam2 "black"}
      {:jam1 "orange" :jam3 "red"}
      {:jam4 "blue"})
;; => {:jam2 "black", :jam1 "orange", :jam3 "red", :jam4 "blue"}

(assoc {:jam1 "red" :jam2 "blue" :jam3 "orange"} :jam1 "orange")
;; => {:jam3 "orange", :jam2 "blue", :jam1 "orange"}

(dissoc {:jam1 "red" :jam2 "blackberry"} :jam1)
;; => {:jam2 "blackberry"}
(merge-with + {:a 1, :b 2, :c 3} {:a 1, :b 2, :c 3} {:a 1} )
;; => {:c 6, :b 4, :a 3}
(defn summarize [& fruits]
(apply merge-with + fruits))
;; => #'user/summarize
(summarize {:a 1, :b 2, :c 3} {:a 1, :b 2, :c 3} {:a 1} )
;; => {:c 6, :b 4, :a 3}

(zipmap [:a :b :c] [1 2 3])
;; => {:a 1, :b 2, :c 3}

(interleave [:a :b :c :d :e] [1 2 3 4 5])
;; => (:a 1 :b 2 :c 3 :d 4 :e 5)

(apply assoc {} (interleave [:a :b :c :d :e] [1 2 3 4 5]))
;; => {:a 1, :b 2, :c 3, :d 4, :e 5}

(split-at 5 (range 10))
;; => [(0 1 2 3 4) (5 6 7 8 9)]

(split-with (partial > 5) (range 10))
;; => [(0 1 2 3 4) (5 6 7 8 9)]

(defn make-random-vars [n]
(apply assoc {}
        (take (* n 2)
              (interleave (map #(keyword (str "x" (inc %)))
                              (range))
                          (repeatedly #(float (rand 100))) ))))
;; => #'user/make-random-vars
(make-random-vars 5)          
;; => {:x1 69.03118, :x2 25.764498, :x3 98.246956, :x4 29.801937, :x5 18.913185}

(group-by :company
        '({:name "John" :company "facebook"}
          {:name "Tony" :company "twtter"}
          {:name "Andy" :company "google"}
          {:name "Sally" :company "twtter"}
          {:name "Peter" :company "google"}
          {:name "Sara" :company "facebook"}
          {:name "Linda" :company "twtter"}))
;; => {"facebook" [{:name "John", :company "facebook"} {:name "Sara", :company "facebook"}], "twtter" [{:name "Tony", :company "twtter"} {:name "Sally", :company "twtter"} {:name "Linda", :company "twtter"}], "google" [{:name "Andy", :company "google"} {:name "Peter", :company "google"}]}

(defn split-into-two [col]
(list (filter odd? col)
      (filter even? col)))
;; => #'user/split-into-two

(split-into-two (range 12))
;; => ((1 3 5 7 9 11) (0 2 4 6 8 10))

(defn split-into-three [col]
(list (filter #(= (rem % 3) 0) col)
      (filter #(= (rem % 3) 1) col)
      (filter #(= (rem % 3) 2) col)))
;; => #'user/split-into-three
(split-into-three (range 12))
;; => ((0 3 6 9) (1 4 7 10) (2 5 8 11))

(str/blank? "")
;; => true

(repl/dir clojure.string);; => nil

;; 
;; Formatting Strings (format)

;; Searching a string by pattern
;; You need to test a string to see if parts of it match a pattern (re-find)

(re-find #"\d+" "I've just finished reading Fahrenheit 451")
;; => "451"
(re-find #"Bees" "Beads aren't cheap.")
;; => nil

;; In find, #"\w+" is any contiguous word characters
(re-find #"\w+" "my-param")
;; -> "my"
;; But in matches, #"\w+" means "all word characters"
(re-matches #"\w+" "my-param")
;; -> nil
(re-matches #"\w+" "justLetters")
;; -> "justLetters"
(re-matches #"\w+" "justLetters my-param")
;; => nil

;; You need to extract (find)portions of a string matching a given pattern.

(re-seq #"\w+" "My Favorite Things")
;; => ("My" "Favorite" "Things")
(re-seq #"\d{3}-\d{4}" "My phone number is 555-1234.")
;; => ("555-1234")
(re-seq #"(@|#)(\w+)" "So long, @earth, and thanks for all the #fish. #goodbyes")
;; => (["@earth" "@" "earth"] ["#fish" "#" "fish"] ["#goodbyes" "#" "goodbyes"])

(def re-phone-number #"(\w+): \((\d{3})\) (\d{3}-\d{4})")
;; => #'user/re-phone-number
(re-seq re-phone-number "Home: (919) 555-1234, Work: (191) 555-1234")
;; => (["Home: (919) 555-1234" "Home" "919" "555-1234"] ["Work: (191) 555-1234" "Work" "191" "555-1234"])

;; FInd & Replace

(clojure.string/replace "My favorite color is green!" "green" "red")
;; => "My favorite color is red!"
(defn linkify-comment
"Add Markdown-style links for any GitHub issue numbers present in comment"
[repo comment]
(clojure.string/replace comment
                        #"#(\d+)"
                        (str "[#$1](https://github.com/" repo "/issues/$1)")))
;; => #'user/linkify-comment
(linkify-comment "next/big-thing" "As soon as we fix #42 and #1337 we should be set to release!")
;; => "As soon as we fix [#42](https://github.com/next/big-thing/issues/42) and [#1337](https://github.com/next/big-thing/issues/1337) we should be set to release!"


;; You need to split a string into a number of parts.

(clojure.string/split "HEADER1,HEADER2,HEADER3" #",")
;; => ["HEADER1" "HEADER2" "HEADER3"]
(clojure.string/split "Spaces Newlines\n\n" #"\s+")
;; => ["Spaces" "Newlines"]
;; Splitting on whitespace without an explicit limit performs an implicit trim
(clojure.string/split "field1 field2 field3 " #"\s+")
;; => ["field1" "field2" "field3"]
;; In CSV parsing an empty match at the end of a line is still a meaningful one
(clojure.string/split "ryan,neufeld," #"," -1)
;; => ["ryan" "neufeld" ""]
(def data-delimiters #"[ :-]")
;; No-limit split on any delimiter
(clojure.string/split "2013-04-05 14:39" data-delimiters)
;; -> ["2013" "04" "05" "14" "39"]
;; Limit of 1 - functionally: return this string in a collection
(clojure.string/split "2013-04-05 14:39" data-delimiters 1)
;; -> ["2013-04-05 14:39"]
;; Limit of 2
(clojure.string/split "2013-04-05 14:39" data-delimiters 2)
;; -> ["2013" "04-05 14:39"]
;; Limit of 100
(clojure.string/split "2013-04-05 14:39" data-delimiters 100)
;; -> ["2013" "04" "05" "14" "39"]

;; You have a string, a symbol, or a keyword and you’d like to convert it into a different one of these string-like data types.

(symbol "valid?")
;; => valid?
(str 'valid?)
;; => "valid?"
(name :triumph)
;; => "triumph"
(str :triumph)
;; => ":triumph"
(keyword "fantastic")
;; -> :fantastic
(keyword 'fantastic)
;; -> :fantastic
(symbol (name :wonderful))
;; -> wonderful

;; If you only want the name part of a keyword
(name :user/valid?)
;; -> "valid?"
;; If you only want the namespace
(namespace :user/valid?)
;; -> "user"
(str :user/valid?)
;; -> ":user/valid?"
(.substring (str :user/valid?) 1)
;; -> "user/valid
(keyword 'produce/onions)
;; -> :produce/onions
(symbol (.substring (str :produce/onions) 1))
;; -> produce/onions
(def shopping-area "bakery")
(keyword shopping-area "bagels")
;; -> :bakery/bagels
(symbol shopping-area "cakes")
;; -> bakery/cakes

;; You need to work precisely with numbers, especially those that are very large or very small, without the imprecision implied by using floating-point representations such as double values.


;; Avogadro's number
6.0221413e23
;; => 6.0221413E23
;; 1 Angstrom in meters
1e-10
;; => 1.0E-10
(* 9999 9999 9999 9999 9999)
;; clojure.lang.ExceptionInfo: integer overflow [at line 1, column 1]
(*' 9999 9999 9999 9999 9999)
;; => 99950009999000049999N
(* 2 Double/MAX_VALUE)
;; -> Double/POSITIVE_INFINITY
(* 2 (bigdec Double/MAX_VALUE))
;; -> 3.5953862697246314E+308M

;; You need to manipulate fractional numbers with absolute precision.

(/ 1 3)
;; -> 1/3
(type (/ 1 3))
;; -> clojure.lang.Ratio
(* 3 (/ 1 3))
;; -> 1N
(+ (/ 1 3) 0.3)
;; -> 0.6333333333333333
(rationalize 0.3)
;; -> 3/10
(+ (/ 1 3) (rationalize 0.3))
;; -> 19/30

;; You need to parse numbers out of strings.

(Integer/parseInt "-42")
;; -> -42
(Double/parseDouble "3.14")
;; => 3.14
(bigdec "3.141592653589793238462643383279502884197")
;; -> 3.141592653589793238462643383279502884197M
(bigint "122333444455555666666777777788888888999999999")
;; -> 122333444455555666666777777788888888999999999N

;; You need to truncate or round a decimal number to a lower-precision number.

(int 2.0001)
;; -> 2
(int 2.999999999)
;; -> 2
(Math/round 2.0001)
;; -> 2
(Math/round 2.999)
;; -> 3
(Math/ceil 2.0001)
;; -> 3.0
(Math/floor 2.999)
;; -> 2.0
(with-precision 3 (/ 7M 9))
;; -> 0.778M
(with-precision 1 (/ 7M 9))
;; -> 0.8M
(with-precision 1 :rounding FLOOR (/ 7M 9))
;; -> 0.7M
(with-precision 3 (/ 1 3))
;; -> 1/3
(with-precision 3 (/ (bigdec 1) 3))
;; -> 0.333M

;; You need to test for equality with some tolerance for minute differences. This is especially a problem when comparing floating-point numbers, which are susceptible to “drift” through repeated operations.

(defn fuzzy= [tolerance x y]
(let [diff (Math/abs (- x y))]
  (< diff tolerance)))
(fuzzy= 0.01 10 10.000000000001)
;; -> true
(fuzzy= 0.01 10 10.1)
;; -> false


;; You need to implement mathematical functions that require trigonometry.

(defn sin-plus [a b]
(+ (* (Math/sin a) (Math/cos b))
   (* (Math/sin b) (Math/cos a))))
(sin-plus 0.1 0.3)
;; => 0.38941834230865047

;; Calculating the distance in kilometers between two points on Earth

(def earth-radius 6371.009)
(defn degrees->radians [point]
(mapv #(Math/toRadians %) point))
(defn distance-between
"Calculate the distance in km between two points on Earth. Each
point is a pair of degrees latitude and longitude, in that order."
([p1 p2] (distance-between p1 p2 earth-radius))
([p1 p2 radius]
 (let [[lat1 long1] (degrees->radians p1)
       [lat2 long2] (degrees->radians p2)]
   (* radius
      (Math/acos (+ (* (Math/sin lat1) (Math/sin lat2))
                    (* (Math/cos lat1)
                       (Math/cos lat2)
                       (Math/cos (- long1 long2)))))))))
(distance-between [49.2000 -98.1000] [35.9939, -78.8989])
;; => 2139.428271884318

(defn to-base [radix n]
(Integer/toString n radix))
(def base-two (partial to-base 2))
(base-two 9001)
;; => "10001100101001"

;; Find the mean (average) of a collection by dividing its total by the count of the collection:
(defn mean [coll]
(let [sum (apply + coll)
      count (count coll)]
  (if (pos? count)
    (/ sum count)
    0)))
(mean [1 2 3 4])
;; -> 5/2
(mean [1 1.6 7.4 10])
;; -> 5.0
(mean [])
;; -> 0
(defn median [coll]
(let [sorted (sort coll)
      cnt (count sorted)
      halfway (int (/ cnt 2))]
  (if (odd? cnt)
    (nth sorted halfway) ;
    (let [bottom (dec halfway)
          bottom-val (nth sorted bottom)
          top-val (nth sorted halfway)]
      (mean [bottom-val top-val]))))) ;
(median [5 2 4 1 3])
;; -> 3
(median [7 0 2 3])
;; -> 5/2 ; The average of 2 and 3.
(defn mode [coll]
  (let [freqs (frequencies coll)
        occurrences (group-by second freqs)
        modes (last (sort occurrences))
        modes (->> modes
                   second
                   (map first))]
    modes))
(mode [:alan :bob :alan :greg])
;; -> (:alan)
(mode [:smith :carpenter :doe :smith :doe])
;; -> (:smith :doe)
(defn standard-deviation [coll]
  (let [avg (mean coll)
        squares (for [x coll]
                  (let [x-avg (- x avg)]
                    (* x-avg x-avg)))
        total (count coll)]
    (-> (/ (apply + squares)
           (- total 1))
        (Math/sqrt))))
(standard-deviation [4 5 2 9 5 7 4 5 4])
;; -> 2.0
(standard-deviation [4 5 5 4 4 2 2 6])
;; -> 1.4142135623730951

;; You need to generate a random number.
(rand)
(rand 9)
(rand-nth [1 2 3])
(rand-nth '(:a :b :c))
(rand-nth (seq #{:heads :tails}))
(shuffle [1 2 3 4 5 6])

;; You need to manipulate values that represent currency.

(def spanugo
  {:product "CyberSecurityAssurance"
   :link "https://www.youtube.com/watch?time_continue=44&v=ctJi6edVMrg&feature=emb_logo"
   :description "Risk, Cybersecurity and Compliance Management for the Hybrid Cloud"
   :tags ["hybrid-cloud" "CyberSecurityAssurance"]
   })
(System/currentTimeMillis)
;; => 1592319476524
(java.util.Date.)
;; => #inst "2020-06-16T14:57:59.399-00:00"


;; You need to represent instances of time in a readable and serializable form.

(def ryans-birthday #inst "1987-02-18T18:00:00.000-00:00")
(require 'clojure.edn)
(import '[java.io PushbackReader StringReader])
(defn remote-server-receive-date []
  (-> "#inst \"1987-02-18T18:00:00.000-00:00\""
      (StringReader.)
      (PushbackReader.)))
(clojure.edn/read (remote-server-receive-date))
(def instant "#inst \"1987-02-18T18:00:00.000-00:00\"")
(binding [*data-readers* {'inst clojure.instant/read-instant-calendar}]
  (class (read-string instant)))
;; -> java.util.GregorianCalendar
(binding [*data-readers* {'inst clojure.instant/read-instant-timestamp}]
  (class (read-string instant)))
;; -> java.sql.Timestamp

;; You would like to generate a lazy sequence of dates (or times) beginning with a specific date and time.
;; doesn't work on bb
(import  '[java.util GregorianCalendar])
(def daily-from-epoch
  (let [start-date (java.util.GregorianCalendar. 1970 0 0 0 0) ]
    (repeatedly
     (fn []
       (.add start-date java.util.Calendar/DAY_OF_YEAR 1)
       (.clone start-date)))))
(take 2 (drop 57 daily-from-epoch))
;; -> (#inst "1970-02-27T00:00:00.000-07:00"
;; #inst "1970-02-28T00:00:00.000-07:00")

(defn adder
  "
  addes two arguments
  "
  [x y]
  (+ x y))
(comment
  (adder 1 2))
