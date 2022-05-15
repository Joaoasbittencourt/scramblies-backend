(ns scramblies-backend.scramble
  (:require [scramblies-backend.utils :refer [letters-freqs,
                                              map-values,
                                              pos-or-0?]]))

(defn scramble? [scrambled target]
  (every?
   pos-or-0?
   (vals (merge-with
          +
          (letters-freqs scrambled)
          (map-values #(* -1 %) (letters-freqs target))))))
