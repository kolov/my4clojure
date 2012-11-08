
( (let[
  
 adjs [[-1 0] [1 0] [0 -1] [0 1]]
 neighbours (fn [x y] (map #(map + [x y] %) adjs))
 has (fn[X m x y]
  (some #(= X (get-in m %)) (neighbours x y)))
 g (vec
  (let[ cols (count (first m))
        rows (count m)]
   (map-indexed 
    (fn[r row] (apply str (map-indexed
      (fn[c val] 
        (if (and (= val \space)
                  (has \M m r c)) \M val))
        row)))
    m)))

 count-m (fn [m] (apply + (map 
       (fn[r] (apply + (map #( {\M 1} % 0) r))) m)))
 cheese (fn[m]
  (vec
(filter identity (flatten
(map-indexed
(fn[i r]
  (let[ s
  (filter identity (map-indexed #(if (=\C %2) %) r))]
    (if (empty? s) nil [i s])
    ))
 m
)))))]

(fn[m]
  (let [[rc cc] (cheese m)]
  (loop[ m m cm 1]
    (let[new-m (g m) new-cm (count-m new-m)]
    (cond (= new-cm cm) false
          (has \M new-m rc cc) true
     :else (recur new-m new-cm)))))))

 ["C######"
              " #     "
              " #   # "
              " #   #M"
              "     # "])
