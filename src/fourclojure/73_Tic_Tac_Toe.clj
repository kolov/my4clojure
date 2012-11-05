(defn w[b]
  (let
      [wins? (fn[b k]
               (let [
                     parse #(Integer/parseInt % %2)
                     nums (map (fn[r](parse (apply str (map #(get {k 1} % 0) r)) 2 )) b)
                     num (parse (apply str nums) 8)]
                 (some #(= (bit-and num %) %)
                       (map #(parse % 8)
                            (re-seq #"\d+" "700 070 007 111 222 444 124 421")))))]
    (cond (wins? b :x) :x
          (wins? b :o) :o
          )))


