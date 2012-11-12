(defn wrr[x]
  (let[ r [[] [0] [0 0] [0 0 0] [0 1] [1] [1 0] [1 0 0] [1 0 0 0] [0 2]]
    n  (partition-all 3 2 "IVXLCDM")]
  (loop[s "" x x n n] (if (zero? x) s
                          (recur (str (apply str (map #(nth (first n) %) (nth r (mod x 10)))) s) (quot x 10) (next n))))))



