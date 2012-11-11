(ns  fourclojure/p106-number-maze)

(defn l[a b]
  (loop[c 1 s #{a}] 
    (if (s b) c 
      (let [n (map (fn[e](map #(apply % [e])[#(/ % 2) #(+ 2 %) #(* 2 %)])) s)]
        (recur (inc c) (reduce #(conj % %2) s 
                               (->> n flatten (filter integer?) (filter pos?))))))))