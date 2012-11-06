(defn n[a b] (= 1 (reduce + (map #({true 0 false 1} (= %1 %2)) a b))))
(defn sdrop[n s] (apply str (concat (take n s) (drop (inc n) s))))
(defn r[a b] (let[[a b] (sort-by count (list a b))] (some #(= a %) (for[x (range 0 (count b))] (sdrop x b)))))
(defn path?[a b] (if (= (count a) (count b)) (n a b) (r a b)))
(defn neighbours[x s] (set (filter  #(path? x %) s)))
(defn tomap[s] (apply merge (map #(hash-map % (neighbours % s)) s)))
(defn search[todo all done] (let[x (first done)
                              moves  (if (nil? x) todo (clojure.set/difference (get all x) (set done)))]
                       ;(do (println (str "todo=" todo " x=" x ", done=" done ", moves=" moves))
                        (cond (empty? todo) true
                          (empty? moves) false
                          :else (some #(search (disj todo %) all (cons % done )) moves))))

(defn chained?[s] (search s (tomap s) '())))
