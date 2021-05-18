#!/bin/sh
clojure -Sdeps '{:deps {nrepl/nrepl {:mvn/version "RELEASE"} cider/cider-nrepl {:mvn/version "RELEASE"} refactor-nrepl/refactor-nrepl {:mvn/version"2.5.0"}}}'  -m nrepl.cmdline -b 0.0.0.0  --middleware '["cider.nrepl/cider-middleware" "refactor-nrepl.middleware/wrap-refactor"]'
