#!/bin/sh
clojure -J-Dclojure.server.repl='{:port 5555, :accept clojure.core.server/repl}'
