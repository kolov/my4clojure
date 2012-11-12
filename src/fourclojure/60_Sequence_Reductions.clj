(defn rr
  ([f i s] (if (empty? s) s (lazy-seq (cons i (rr f (f i (first s) (next s)))))))
  ([f s] (rr f (first s) (next s))))