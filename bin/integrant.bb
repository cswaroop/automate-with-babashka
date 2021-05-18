(require '[babashka.deps :as deps])

(deps/clojure  ["-Sdeps" '{:deps {integrant/integrant {:mvn/version "0.8.0"}
                                  org.clojure/tools.deps.alpha ; add-lib3 branch
                                  {:git/url "https://github.com/clojure/tools.deps.alpha"
                                   :sha "d77476f3d5f624249462e275ae62d26da89f320b"}}}
                "-e" "(->>(Thread/currentThread)(.getContextClassLoader)(clojure.lang.DynamicClassLoader.)(.setContextClassLoader,(Thread/currentThread)))"])
@(promise)

(require '[integrant.core :as ig])

(def config
  {:adapter/jetty {:port 8080, :handler (ig/ref :handler/greet)}
   :handler/greet {:name "Alice"}})
