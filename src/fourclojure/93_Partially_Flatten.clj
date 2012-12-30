(defn d[ s]
  (if (coll? s) (apply max 1 (map #(inc (d %)) s)) 0 ))