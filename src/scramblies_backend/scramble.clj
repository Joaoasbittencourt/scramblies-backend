(ns scramblies-backend.scramble
  (:require
   [scramblies-backend.utils :refer [vals-diff]]))

(defn scramble? [input target]
  (every? nat-int? (vals (vals-diff
                          (frequencies input)
                          (frequencies target)))))
