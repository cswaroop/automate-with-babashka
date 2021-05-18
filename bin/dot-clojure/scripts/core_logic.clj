#!/usr/bin/env -S -v cmd-clj '-Sdeps "{:deps {nrepl {:mvn/version  """"""0.7.0""""""} cider/cider-nrepl {:mvn/version """"""0.25.2""""""} org.clojure/core.logic {:mvn/version """"""1.0.0""""""}}}" -m nrepl.cmdline --middleware [""""""cider.nrepl/cider-middleware""""""]'

;; Minikanren is DSL implemented in scheme for Logic Programming.   clojure.core.logic is clojure's implementation.

;; https://github.com/clojure/core.logic/wiki/A-Core.logic-Primer


(require '[clojure.core.logic :as cl])

;;Given  some facts as EAV/RDF triplets

(def movie-graph
  [;; The "Newmarket Films" studio
   [:a1 :type :FilmStudio]
   [:a1 :name "Newmarket Films"]
   [:a1 :filmsCollection :a2]
   ;; Collection of films made by Newmarket Films
   [:a2 :type :FilmCollection]
   [:a2 :film :a3]
   [:a2 :film :a6]
   ;; The movie "Memento"
   [:a3 :type :Film]
   [:a3 :name "Memento"]
   [:a3 :cast :a4]
   ;; Connects the film to its cast (actors/director/producer etc.)
   [:a4 :type :FilmCast]
   [:a4 :director :a5]
   ;; The director of "Memento"
   [:a5 :type :Person]
   [:a5 :name "Christopher Nolan"]
   ;; The movie "The Usual Suspects"
   [:a6 :type :Film]
   [:a6 :filmName "The Usual Suspects"]
   [:a6 :cast :a7]
   ;; Connects the film to its cast (actors/director/producer etc.)
   [:a7 :type :FilmCast]
   [:a7 :director :a8]
   ;; The director of "The Usual Suspects"
   [:a8 :type :Person]
   [:a8 :name "Bryan Singer"]])

;; Which directors have made movies at a given studio?

(defn directors-at
  "Find all of the directors that have directed at a given studio"
  [graph studio-name]
  (cl/run* [director-name]
    (cl/fresh [studio film-coll film cast director]
      ;; Relate the original studio-name to a film collection
      (cl/membero [studio :name studio-name] graph)
      (cl/membero [studio :type :FilmStudio] graph)
      (cl/membero [studio :filmsCollection film-coll] graph)
      ;; Relate any film collections to their individual films
      (cl/membero [film-coll :type :FilmCollection] graph)
      (cl/membero [film-coll :film film] graph)
      ;; Then from film to cast members
      (cl/membero [film :type :Film] graph)
      (cl/membero [film :cast cast] graph)
      ;; Grounding to cast members of type :director
      (cl/membero [cast :type :FilmCast] graph)
      (cl/membero [cast :director director] graph)
      ;; Finally, attach to the director-name
      (cl/membero [director :type :Person] graph)
      (cl/membero [director :name director-name] graph))))

(directors-at movie-graph "Newmarket Films")
;; => ("Christopher Nolan" "Bryan Singer")
