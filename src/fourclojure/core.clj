(ns fourclojure.core)

; Solutions to 4clojure. Not all, did not start write tham down in the beginning

;Problem 28
; Write a function which removes consecutive duplicates from a sequence.
#(let [s (seq %)]
  (concat (map first 
    (filter (fn [[a b]] (not(= a b))) 
    (partition 2 1 s))) [(last s)])

;33
;Write a function which replicates each element of a sequence a variable number of times.
#(apply concat (map (partial repeat %2) %))

; 40
; Write a function which separates the items of a sequence by an arbitrary value (interpose)
#(take (dec (* 2 (count %2))) 
  (mapcat (fn[x] (list x %)) %2))


;45
partial (fn [f a b] (f b a))


;61
Write a function which takes a vector of keys and a vector of values and constructs a map from them. (zipmap)
#(apply merge (map hash-map% %2))

;62 reimplement iterate
(fn i [f x] (cons x (lazy-seq (i f (f x))))

;Found: #(reductions (fn [x _] (% x)) %2 (range))

;66 
; Given two integers, write a function which returns the greatest common divisor.

#(loop [a %1 b %2] (if (= a b) a (if (> a b) (recur b (- a b)) (recur a (- b a)))))

;81
; Write a function which returns the intersection of two sets. The intersection is the sub-set of items that each set has in common.
; (intersection)
#(set (filter (fn[e] (contains? %2 e)) %1))

;107 Simple closures
; Given a positive integer n, return a function (f x) which computes xn.
(fn [p] (fn [x] (reduce (fn [r _] (* x r)) 1 (range p))))

;99 Product Digits
;Write a function which multiplies two numbers and returns the result as a sequence of its digits.
(fn [a b] (map #(- (int %) 48) (str (* a b))))

;97 Pascal's Triangle
;Write a function which returns the nth row of Pascal's Triangle. 
(fn pt [x] (if (= 1 x) [1] (concat [1] (map #(apply + %) (partition 2 1 (pt (dec x)))) [1] ))) 

; 135
(fn [a & more] (reduce (fn [r [op v]] (op r v)) a (partition 2 more))) 

;143
;Create a function that computes the dot product of two sequences
#(reduce + (map * % %2))


;122
#(loop [r 0 s %] (if (empty? s) r (recur (+ (- (int (first s)) (int \0 )) (* 2 r)) (next s))))
;cgrand: reduce #(+ % % ({\0 0} %2 1)) 0

;88
; Write a function which returns the symmetric difference of two sets. The symmetric difference is the set of items belonging to one but not both of the two sets.
#(set (filter 
  (fn[x] (= 1 (+ (if (%1 x) 1 0) (if (%2 x) 1 0)))) 
  (clojure.set/union %1 %2)))

;86 happy Numbers
#(letfn [(sq [c] (let [v (- (int c) (int \0))] (* v v)))] 
   (loop [h #{} x %1] (cond (= 1 x) true (h x) false :else (let [x1 (apply + (map sq x))] (recur (conj h x1) x1)))))#(letfn 
  [ (sq [c] 
    (let [v (- (int c) (int \0))] (* v v)))]

  (loop [h #{} x %1 ] 
    (cond (= 1 x) true 
          (h x) false 
      :else 
      (let [x1 (apply + (map sq (str x)))] 
         (recur (conj h x) x1)))))

#120
#(let [sq (zipmap [\0 \1 \2 \3 \4 \5 \6 \7 \8 \9 ]
                 [0 1 4 9 16 25 36 49 64 81])]
 (count (filter 
  (fn[x] (< x (apply + (map sq (str x))))) %)))

;63 Group-by
(fn[f s] 
  (reduce (fn[a b] (merge-with #(concat %1 %2) a b))
    (map hash-map (map f s) (map list s))))



fn[coll]
  (letfn [(sval[s] (str (sort-by #(int %) s))) ]
  (->> coll 
    (sort-by sval)
    (partition-by sval)
    (map set)
    (filter #(>  (count %) 1))
    set )))
cgrand: #(->> % (group-by sort) vals (filter next) (map set) set)

137
#(loop [ r () n %] (let [r1 (conj r (mod n %2)) n1 (quot n %2)] (if (> n1 0) (recur r1 n1) r1)))