(defn ta[n p s]
  (lazy-seq 
    (let[f (first s) m (if (p f) (dec n) n)]    
      (if (pos? m)
          (cons f (ta m p (next s)))))))
  