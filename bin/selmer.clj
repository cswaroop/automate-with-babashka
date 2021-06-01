(use 'selmer.parser)

(render "Hello {{name}}!" {:name "Yogthos"})
#_(render-file "home.html" {:name "Yogthos"})
#_(selmer.parser/cache-on!)
#_(selmer.parser/set-resource-path! "/var/html/templates/")
(use 'selmer.filters)

(add-filter! :embiginate clojure.string/upper-case)
(render "{{shout|embiginate}}\nWorld!" {:shout "hello"})



