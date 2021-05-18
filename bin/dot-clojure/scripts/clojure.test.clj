#!/usr/bin/env -vS BABASHKA_CLASSPATH='$(deps -Spath)' bb

;; did little fight with env
;; https://www.gnu.org/software/coreutils/manual/html_node/env-invocation.html
(require '[clojure.test :as t])
(t/deftest foo
  (t/is (= 4 5)))
(t/run-tests)
