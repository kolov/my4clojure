(letfn [ (m[c] (apply max (map first c)))
         (dc[n c] (map #(drop-while (fn[a] (<= a n)) %) c))]
   (defn ss[ & c] 
     (loop[ c c]
       (let[ x (m c)]
         (if (every? #(= x (first %)) c) x (recur (dc x c)))))))
        
