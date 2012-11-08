((defn r[f d]
  (set
  (map set
  (vals (group-by f d)))))