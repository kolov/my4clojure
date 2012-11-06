(defn t[x]
  (cond
   (:test (conj x {:test 1})) :map
   (:test (conj x :test)) :set
   (= :test1 (-> x (conj :test1) (conj :test2) last)) :list
   :else :vector))
  
  