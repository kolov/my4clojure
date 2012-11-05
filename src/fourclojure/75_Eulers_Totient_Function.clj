(defn et[n]
  (letfn [ (gcd[x y] (loop[x x y y]
                  (cond (> x y) (recur y (- x y))
                        (> y x) (recur x (- y x))
                        :else x)))]
    (count (filter #(= 1 (gcd % n)) (range 1 (inc n))))))
                                 