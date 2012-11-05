(defn i[x]
  (let[ x (into #{} x)
       d (map #(apply - %) (partition 2 1 x))
       m (zipmap x (reductions + 0 (map inc d)))]
    (map #(if (next %) [(first %) (last %)] [(first %) (first %)])
         (partition-by #(m %) x))))