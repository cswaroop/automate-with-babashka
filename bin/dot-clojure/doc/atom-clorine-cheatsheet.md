https://atom.io/packages/chlorine

'atom-text-editor[data-grammar="source clojure"]':
  'ctrl-; y':       'chlorine:connect-socket-repl'
  'ctrl-; e':       'chlorine:disconnect'
  'ctrl-; k':       'chlorine:clear-console'
  'ctrl-; f':       'chlorine:load-file'
  'ctrl-; b':       'chlorine:evaluate-block'
  'ctrl-; B':       'chlorine:evaluate-top-block'
  'ctrl-; i':       'chlorine:inspect-block'
  'ctrl-; I':       'chlorine:inspect-top-block'
  'ctrl-; s':       'chlorine:evaluate-selection'
  'ctrl-; c':       'chlorine:break-evaluation'
  'ctrl-; S':       'chlorine:source-for-var'
  'ctrl-; d':       'chlorine:doc-for-var'
  'ctrl-; x':       'chlorine:run-tests-in-ns'
  'ctrl-; t':       'chlorine:run-test-for-var'
