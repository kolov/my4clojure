
(defn rr[s]
  (reduce
   (fn[sum [l r]] (if (> l r) (+ sum l) (- sum l))) 0 
   (partition 2 1
    (map #(apply + %)
         (concat
          (partition-by identity (map (zipmap "IVXLCDM" [1 5 10 50 100 500 1000]) s))
          [[0]]
          )))))

