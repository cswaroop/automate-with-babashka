(ns solving-problems-clojure-way)

;; https://www.youtube.com/watch?v=vK1DazRK_a0

;; clojure is functional
;; clojure is data-driven

;; 1. Deal with State explicitly and as a first thing in the program
;; What constitutes state?
;; - Application state such as containers(HTTP Servers), connections (DB,Caching,Messaging); remember all the application servers configuration that we used to do in WebSphere, WebLogic, JBoss
;; - Session state of the User - What's the tenant-id of the user? settings, 
;; - Domain objects - reference data, codes, configuration
;; - Transaction (Order, CreditApplication, GameObject)

Learning languages has transcendal value.  For example Haskell functional thinking can be transfered into LISP programming.  Similarly LISP wway of thinking can be transfered to JavaScript.

Functions and Data are the fundamental

2. How can we avoid multable state, mutating-state, and other side-effects?
minimize, concentrate, defer
-minimize in a let block
- concentrate at one place
- defer it to a database

2.5 Functional Programming
With state out of concern, we can use pure functions to transform the data.

3. Data Driven Programming
- Data first program design, programs as =Data flows=
- Use of plain data
- Programming where data (not code) defines some of the control flow
  - code generation from data
  - making DSLs with Data instead of Code (Macros)
  - configuration driven programming (especiall when state has been captured in reloadable workflow supporting lib such as integrant)
  - Data > Function > Macros
   e.g. Amazon AWS sdk. - All sdks generated from bunch of JSON files
        HICCUP Garden REITIT
   counter eg. Comojure   