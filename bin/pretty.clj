#!/usr/bin/env bb
(require '[babashka.deps :as deps])
(deps/add-deps '{:deps {io.aviso/pretty {:mvn/version "0.1.36"}}})

(require '[io.aviso.ansi :as ansi])
(println (str "The following text would be " ansi/bold-red-font "bold and red " ansi/reset-font "but this text will not"))

