(defn c[f & fs]
  (fn[ & args] (loop[ fr (cons f (butlast fs)) x (apply (last fs) args)]
                 (if (seq? fr) (recur (butlast fr) ((last fr) x)) x))))

(defn d[f & fs]
  (let[g (reverse (conj fs f))]
    (fn[ & args] (reduce #(%2 %) (apply (first g) args) (next g)))))