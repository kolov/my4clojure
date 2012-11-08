(defn mw[f & ms]
  (reduce
   (fn[r m] (reduce
             (fn[r me] (let[k (key me) found (r k)]
                (assoc r k (if found (f found (val me)) (val me)))))
             r m))
     (first ms) (next ms)))