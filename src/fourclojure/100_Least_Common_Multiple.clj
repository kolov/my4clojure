(defn lcm[ & args]
  (letfn [ (gcd[x y] (loop[x x y y]
                  (cond (> x y) (recur y (- x y))
                        (> y x) (recur x (- y x))
                        :else x)))]
    (reduce #(/ (* % %2) (gcd % %2)) args)))
                                 