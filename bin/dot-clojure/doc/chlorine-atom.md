# Clorine (REPLing)
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

  if Using VIM-mode-plus

  'atom-text-editor.vim-mode-plus.normal-mode[data-grammar="source clojure"]':
  'g f':          'chlorine:go-to-var-definition'
  'ctrl-d':       'chlorine:doc-for-var'
  'space c':      'chlorine:connect-socket-repl'
  'space l':      'chlorine:clear-console'
  'shift-enter':  'chlorine:evaluate-block'
  'ctrl-enter':   'chlorine:evaluate-top-block'
  'ctrl-c':       'chlorine:break-evaluation'
  'space space':  'chlorine:clear-inline-results'
  'space x':      'chlorine:run-tests-in-ns'
  'space t':      'chlorine:run-test-for-var'

'atom-text-editor.vim-mode-plus.insert-mode[data-grammar="source clojure"]':
  'shift-enter': 'chlorine:evaluate-block'
  'ctrl-enter': 'chlorine:evaluate-top-block'

# Parinfer

https://atom.io/packages/parinfer
demo:
https://shaunlebron.github.io/parinfer/
Windows/Linux  Mac
Turn on / Toggle Mode  Ctrl+Shift+(  Cmd+Shift+())

# lisp-paredit (Editing)

https://atom.io/packages/lisp-paredit
demo:
https://calva.io/paredit/

Paredit Commands

Default keybinding  Action
ctrl-alt-,  barf-forwards
ctrl-alt-.  slurp-forwards
ctrl-alt-<  slurp-backwards
ctrl-alt->  barf-backwards
cmd-delete  kill-sexp-forwards
alt-delete  kill-sexp-forwards
cmd-backspace  kill-sexp-backwards
alt-backspace  kill-sexp-backwards
cmd-shift-delete  kill-forwards
alt-shift-delete  kill-forwards
cmd-shift-backspace  kill-backwards
alt-shift-backspace  kill-backwards
ctrl-alt-i  indent
ctrl-right  forward-sexp
ctrl-shift-right  select-forward-sexp
ctrl-left  backward-sexp
ctrl-shift-left  select-backward-sexp
ctrl-up  up-sexp
ctrl-shift-up  select-up-sexp
ctrl-down  down-sexp
ctrl-shift-down  select-down-sexp
ctrl-w  expand-selection
ctrl-alt-space  contract-selection
ctrl-alt-up  splice-backwards
ctrl-alt-down  splice-forwards
ctrl-alt-s  splice
ctrl-alt-/  split
ctrl-alt-(  wrap-around-parens)
ctrl-alt-9  wrap-around-parens
ctrl-alt-[  wrap-around-square]
ctrl-alt-{  wrap-around-curly}
Overidden Commands
These override the default behaviour with paredit special functions.

Default keybinding  Action
backspace  delete-backwards (won't delete brackets in strict mode)
ctrl-h  delete-backwards (won't delete brackets in strict mode)
delete  delete-forwards (won't delete brackets in strict mode)
ctrl-d  delete-forwards (won't delete brackets in strict mode)
enter  newline (auto indents next line)
cmd-v  paste (disallows invalid syntax in strict mode)
