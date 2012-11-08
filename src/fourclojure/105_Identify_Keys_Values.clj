(defn f[s]
  (loop[k nil s s r {}]
    (cond (empty? s) r
          (keyword? (first s) (recur (first s) (next s) (merge r { (first s) []))))
          :else (recur k (next s) (merge-with conj r { k (first s)})))))
          