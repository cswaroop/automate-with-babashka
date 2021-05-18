https://github.com/linpengcheng/PurefunctionPipelineDataflow
Those who are good at war have no surprising victory, no reputation for wisdom, no honor for courage.
        ---- Sun Wu, The Art of War
             Famous Chinese military and politician, 
             sage of military science, 
             ancestor of Eastern military science

  1. Data model as pure data (data-oriented)
  2. Pure functions as transformations (data pipelins)
     - Single parameter function which takes a hash map

(defn f [x]
  (->> x
       f1
       f2))
(defn f [{:keys [x y] :as m}]
  (->> x
       (f1 y ,)
       f2))


