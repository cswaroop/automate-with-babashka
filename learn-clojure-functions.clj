(de ■ '■)
(def ▲ '▲)
(def ● '●)

(first [● ■ ▲])   ; ●
(second [● ■ ▲])  ; ■
(nth [● ■ ▲] 2)   ; ▲
(rest [● ■ ▲])    ; (■ ▲)
(last [● ■ ▲])    ; ▲
(butlast [● ■ ▲]) ; (● ■)

(map (partial = ■) [■ ● ■ ▲]) ; (true false true false)

(filter (partial = ■) [■ ● ■ ▲])     ; (■ ■)
(remove (partial = ■) [■ ● ■ ▲])     ; (● ▲)
(distinct [■ ● ■ ▲ ● ▲])             ; (■ ● ▲)
(interpose '▲ [● ● ●])               ; (● ▲ ● ▲ ●)
(interleave [■ ■ ■] [▲ ▲ ▲] [● ● ●]) ; (■ ▲ ● ■ ▲ ● ■ ▲ ●)

(take 3 [■ ■ ● ● ▲ ▲])                       ; (■ ■ ●)
(take-nth 2 [■ ■ ● ● ▲ ▲ ■ ■])               ; (■ ● ▲ ■)
(take-while (partial = ■) [■ ■ ● ● ▲ ▲ ■ ■]) ; (■ ■)
(drop-while (partial = ■) [■ ■ ● ● ▲ ▲ ■ ■]) ; (● ● ▲ ▲ ■ ■)

(partition 2 [■ ■ ● ● ▲ ▲ ■ ■])   ; ((■ ■) (● ●) (▲ ▲) (■ ■))
(partition 2 1 [■ ■ ● ● ▲ ▲ ■ ■]) ; ((■ ■) (■ ●) (● ●) (● ▲) (▲ ▲) (▲ ■) (■ ■))
(split-at 3 [■ ■ ● ● ▲ ▲ ■ ■])    ; [(■ ■ ●) (● ▲ ▲ ■ ■)]

(frequencies [■ ■ ● ● ▲ ▲ ■ ■]) ; {■ 4, ● 2, ▲ 2}

(some (partial = ●) [■ ● ■ ▲])   ; true
(every? (partial = ●) [■ ● ■ ▲]) ; false 
(every? (partial = ●) [● ● ●])   ; truef
