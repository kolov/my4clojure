(defn sh[ l s]
  (let[f (first s)
       n (next s)
       s? (sequential? f)
       n? (nil? f)
       v (if (or s? n?) 0 f)
       ]
     (cond n? '()
           (> v l) '()
           s? (cons (sh l f) (sh (- l (apply + 0 (flatten f))) n))
           :else (cons f (sh (- l v) n)))))

         
         