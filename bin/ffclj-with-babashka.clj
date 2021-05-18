#!/usr/bin/env bb

(require '[babashka.deps :as deps])
(deps/add-deps '{:deps {ffclj/ffclj {:mvn/version "0.1.2"}}})

(require '[ffclj.core :refer [ffm]])
