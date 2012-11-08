(defn f[s]
  (fn [v] (pprint s)
    ( (fn e[s] (if (seq? s)
                 (apply ({'+ + '- - '/ / '* *} (first s)) (map e (next s)))
                 (v s s)))
      s)))