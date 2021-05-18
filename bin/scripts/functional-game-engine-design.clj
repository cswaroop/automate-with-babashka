;; https://www.youtube.com/watch?v=TW1ie0pIO_E
;; State!
;; State changes 60 times per sec
;; state and functions to work on state are intermingled
;; What the game does and how to do seperatio

;; ### Entity Component System
;; Originated from development of Dungeon Siege
;; Popularized by Unity game Engine
;; Decouples object hierarchies and focuses on collections of aspects and the means of iterating over them
;; component based modeling

;; #### Entity
;; Entity is a
;; - Label
;; - A collection of component labels
{:player1 {:controllable :movable :collidable}}

;; #### Component
;; A Component is a
;; - Label
;; - A function of component state
;; A component state belongs to entity
;; function takes the component state and returns the next component state
{:movable f}

;; #### System
;; A system is a
;; - label
;; - a function of state
;; - Iterates over all entities that have a component
;; - Calls component function with component state that belongs to the entity
;; - Puts it all toget to return the next game state
;; - Bascially its a lense
{:movement f}

;; #### Scene
;; - lebel
;; - Collection of system labels in the order they should be executed
{:title-screen [:menu :input :render]
 :game [:input :movment :ai]}

;; ### Putting all Together in a game loop
;; Game state is a hashmap that has our entities, systems and components (and scene)
{:entities {:player1 [:move :animate]}
 :components {:move move :animate animate}
 :systems {:movement {:component :move :fn move-system}
           :animation {:component :animate :fn animation-system}}
 :scene [:movement :animation]
 :state {:move {:player1 {:x 1 :y 1}}
         :animation {:player1 {:frame 0}}}}
;; Get all the system functions in the order of the scene
(map #(get-in state [:systems %]) (:scene state))

;; Compose all system functions and call with state
((comp s1 s2 s3) state)

;; RECUR!!




