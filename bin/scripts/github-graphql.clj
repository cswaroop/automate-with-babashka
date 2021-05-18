#!/usr/bin/env bb
(ns github-graphql-api-client
  (:require
   [babashka.curl :as curl]
   [cheshire.core :as cheshire]
   [clojure.pprint :refer [pprint]]))

(def auth-token (System/getenv "AUTH_TOKEN"))

(def graphql-query
  "
query ($query: String!, $last: Int) {
  search(type: ISSUE, query: $query, last: $last) {
    nodes {
      ... on Issue {
        title
        url
        repository {
          name
        }
        labels(first: 10) {
          nodes {
            name
          }
        }
      }
    }
  }
}
")

(defn run-query [query variables]
  (-> (curl/post "https://api.github.com/graphql"
                 {:headers {"Content-Type" "application/json"
                            "Accept" "application/json"
                            "Authorization" (str "bearer " auth-token)}
                  :body (cheshire/generate-string {:query query
                                                   :variables variables})})
      :body
      (cheshire/parse-string true)))

(defn -main []
  (pprint
   (run-query graphql-query
              {:query "org:my-org is:issue is:open label:\"docs\" sort:updated"
               :last 100})))

(when (= *file* (System/getProperty "babashka.file"))
  (-main))
