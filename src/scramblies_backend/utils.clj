(ns scramblies-backend.utils
  (:require
   [clojure.string :as str]))

(defn parse-query [query]
  (->> (str/split query #"&")
       (map #(str/split % #"="))
       (map (fn [[k v]] [(keyword k) v]))
       (into {})))

(defn map-values [mapper target]
  (->> target
       (map (fn [[k v]] [k (mapper v)]))
       (into {})))

(defn letters-freqs [word]
  (frequencies (vec word)))

(defn pos-or-0? [number]
  (>= number 0))
