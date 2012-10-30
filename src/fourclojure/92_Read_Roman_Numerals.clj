; Roman numerals are easy to recognize, but not everyone knows all the rules necessary to work with them.
; Write a function to parse a Roman-numeral string and return the number it represents.

;You can assume that the input will be well-formed, in upper-case, and follow the subtractive principle.
;You don't need to handle any numbers greater than MMMCMXCIX (3999), the largest number representable with ordinary letters.

(defn rr[s]
  (let [l->n (zipmap "IVXLCDM" [1 5 10 50 100 500 1000])
        vals (partition-by identity (map l->n s))]
  (reduce
   (fn[sum [l r]] (if (> l r) (+ sum l) (- sum l))) 0 
   (partition 2 1
    (map #(apply + %)
         (concat vals [[0]])
         )))))

