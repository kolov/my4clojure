 (loop[r [] s % f #{}] (if (empty? s) r (if (f (first s)) (recur r (next s) f) (recur (concat r [(first s)]) (next s) (conj f (first s))))))