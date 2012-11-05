(defn t[x]
  (or (nil? x)
      (and (sequential? x) (= 3 (count x)) (t (second x)) (t (last x)))))