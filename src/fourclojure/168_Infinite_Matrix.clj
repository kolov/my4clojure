(letfn
    [ (r[l] (lazy-seq (cons l (r (inc l)))))]
  (fn ma
    ([f]  (map (fn[a]( map (fn[b] (f a b)) (r 0)))  (r 0)))
    ([f m n] (ma #(f (+ m %) (+ n %2))))
    ([f m n s t] (take s (map #(take t %) (ma f m n))))
    ))
  
