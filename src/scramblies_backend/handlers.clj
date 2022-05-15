(ns scramblies-backend.handlers
  (:require
   [scramblies-backend.utils :refer [parse-query]]
   [scramblies-backend.scramble :refer [scramble?]]))

(defn get-scramble-handler [req]
  (let [query (parse-query (:query-string req))
        input (:input query)
        target (:target query)]
    {:status 200
     :body (str (scramble? input target))}))
