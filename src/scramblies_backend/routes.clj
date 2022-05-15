(ns scramblies-backend.routes
  (:require
   [scramblies-backend.handlers :as handlers]))

(def routes
  [["/api/scramble"
    {:get (fn [req]
            (println "[scramblies][GET][scramble]")
            (handlers/get-scramble-handler req))}]])
