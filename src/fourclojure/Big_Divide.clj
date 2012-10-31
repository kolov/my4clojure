(defn f[n a b]
  (letfn [(s[n a] (let[q (quot n a)] (* a q (inc q))))]
    (let [n (dec n) ] (/ (+ (s n a) (s n b) (- (s n (* a b)))) 2))))

