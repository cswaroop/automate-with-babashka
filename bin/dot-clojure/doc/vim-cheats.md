TIPS
======
- Learn to touch type. Continue to improve typing speed maintaining 100% accuracy
- Always leave the editor in "Normal Mode"
- Think of every edit change set as reaptable tasks so that you can repeat with "." operator on different change sets.  In EMACS its is like using Macros
- HJKL should be imagined with some geo milestones in WEST, SOUTH, NORTH, EAST if you are more of a visual person.
- . u
- There are no modes like in Emacs (Fundamental-mode, Programming Mode, Clojure Mode) for each file type.  There are 3 states (Normal, Insert, Visual) and variety fo TEXT OBJECTS (available via plugins) to handle programming language editing idiosynchracies  such as SEXP editing (LISP) etc.


Normal Mode (Navigation)
===========
hjkl
f (zap to char) ; ,
f F t T
w, W, e, E
b,B
0, $, ^

%
gg, G
gi, gl, gd, gD, gf
zt, C-b
/, ? C-n
C-^
Where was a I at last time?

Normal Mode (Editing)
=====================
r,x
dw, cw
u
ciw  
ci(, ci[, ci{, ci(
cc, c$/C
J, gJ

line1
line2

Normal Mode (Cut & Paste)
=========================
yy
p, P
yiw
yi(, yi[, yi{, yi{
x, D
diw, di(, di[, di{
da(, da[, da{

Normal Mode (Evaluation)
========================
cpp, C-b
:jack-in 5555, :jack-out

Commands
=========
:q, :q!,
:w, :wq!
:e :e . :e <path>, :Ex
C-SPC
:buffers
Q,q - macros
:ls, :bnext

Insert Mode
============
i, I
a, A
o, O

Visual Mode
===========
v, vit
c,d
iw
i(, i[, i{, i"
a(, a[, a{, a"

Window Management
=================
C-w-S, C-w-V
C-w-W/C-ww, C-w-h, C-w-j, C-w-k, C-w-l
C-w-c, C-w-o


Editing XML
===========
```xml
<a href="http://www.conjsystems.io">Practical Vim </a>
<a href="http://www.conjsystems.io">Practical Vim </a>
```

Editing Programming Languages
=============================

Append ; at the end of each line?

A=$a
C=c$
S=^C
I=^i
o=A<CR>
O=ko

```javascript
var foo = 1;
var bar = 'a';
var foobar = foo + bar;
```
>G, >j  >j.

```quote
line1
line2
	line3
	line4
```

```clojure
(defn a []
   (+ 2 1))

```

Add spaces around + to make it clear?
f+  s + <ESC> ;.  ;. ;.
```javascript
var foo = "method("+arg1+","+arg2+")";
var foo = "method("+arg1+","+arg2+")";
```
