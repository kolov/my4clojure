(defn i[n]
  (let[
       cgt (fn[a b] (> (int a) (int b)))
       find-end (fn[r s cur] (loop[r r s s cur ""] (cond (empty? r) cur (cgt (first r) (first s)) nil
                                                :else (recur (next r) (next s) (cons (first s) cur)))))
       to-pal (fn to-pal[s] (let[
                                 c (count s)
                                 ml (quot c 2)
                                 mh (quot (inc c) 2)
                                 r (take ml (reverse s)) end (find-end r s "")]
                              (if end (apply str (concat (take mh s) end)))))
       inc-pal (fn inc-pal[s] (let[
                                   c (count s)
                                   ml (quot c 2)
                                   mh (quot (inc c) 2)]
                                (apply str (concat (->> (take mh s) (apply str) read-string inc str) (take ml (repeat \0 ))))))
       get-pal (fn[s] (let[x (to-pal s)] (if x x (-> s inc-pal to-pal))))
            ]
    (map read-string (iterate (comp to-pal inc-pal) (get-pal (str n))))))
