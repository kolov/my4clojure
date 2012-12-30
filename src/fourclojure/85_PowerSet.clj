(
 fn[s]
   (let [a (fn [x s] [ (conj s x) s])]
        (set (reduce #(mapcat (partial a %2) %) #{ #{} } s))) )