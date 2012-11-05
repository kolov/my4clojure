(let [ p (fn [x] (not-any? #(zero? (mod x %)) (range 2 (inc (Math/sqrt x)))))
      p (memoize p)
      d (fn[x] (some #(if (p %) %) (range (dec x) 0 -1)))]
  (defn st[x]
    (if
        (and (p x) (> x 3))
      (let [pd (d x) pu (- (* 2 x) pd) ] (and (p pu) (not-any? p (range (inc x) pu))))
      false)))

(let[  p (fn [x] (not-any? #(zero? (mod x %)) (range 2 (inc (Math/sqrt x)))))
     ps (fn[s]  (lazy-seq (cons (first filter p  (range (inc (last x)) 99999))))))
      ]
  (defn pa[x] (p x)))
