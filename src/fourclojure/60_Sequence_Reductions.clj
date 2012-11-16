(defn rr
  ([f i s] (lazy-seq (cons i (if (empty? s) (rr f (f i (first s)) (next s))))))
  ([f s] (rr f (first s) (next s))))