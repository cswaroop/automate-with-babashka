# Conjure - A NEOVIM based Clojure-VIM distribution

Its more than a simple IDE distribution.  Author claims its a conversational software platform

https://www.youtube.com/watch?v=RU28xy9JXxs&lc=UgzjP4R8CXzBIOKjfxp4AaABAg.9Ef4ySV31BB9EfBfyg_t7x

# links
https://oli.me.uk/conversational-software-development/

https://blog.djy.io/conjuring-clojure-in-vim-2020-edition/

## NOTE
:ConjureSchool Notes

1. If you want to open the conjure in any file e.g. markdown, asciidoc just run the :setfiletype clojure and  you will be connected to repl
2. evaluation shortcuts. Prefix with a local-leader key (,)
`ee` `er` - local form and outermost form
`mF` `emF` - mark once and evaluate from anywhere
`rr` - reload all changed namespaces. WoW
`ef` `eb` - File/Buffer evaluation
`E` `e!` - eval selection
`ew` - peeking under vars
`K, `gd` - documentation and goto definition
`rr`, `ra`, `rc`
-`ta`, `tn`, `tN`
`sf` - session reset
:setfiletype clojure

Start an NREPL server which automatically writes out (except babashka) .nrepl-port file which Conjure (VIM) will pick up

```shell
clojure -Sdeps '{:deps {nrepl/nrepl {:mvn/version "LATEST"}}}' -m nrepl.cmdline
clojure -A:nREPL -m nrepl.cmdline
```
# Clojure editing (Structural) 
vim-sexp and vim-sexp-mappings-for-regular-people provide sexp editing features such as auto closing parantheses, barf, slurp, up, transpose

### Practice Some clojure

https://clojure.org/api/cheatsheet

(+ 1 2)
(def my-function (fn [x] (* x x x)))

