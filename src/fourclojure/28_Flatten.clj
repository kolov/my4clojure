(dezfn f[[h & t]]
  (concat
   (if (coll? h) (f h) [h])
       (when t (f t))))