(ns scramblies-backend.core
  (:gen-class)
  (:require [org.httpkit.server :refer [run-server]]
            [reitit.ring :as ring]
            [scramblies-backend.routes :refer [routes]]
            [ring.middleware.cors :refer [wrap-cors]]))

(def PORT 4000)
(defonce server (atom nil))

(def app
  (ring/ring-handler
   (ring/router routes)
   (ring/routes
    (ring/redirect-trailing-slash-handler)
    (ring/create-default-handler
     {:not-found
      (constantly {:status 404
                   :body "Route not found"})}))))

(defn -main []
  (println "[scramblies]" "server started on port" PORT)
  (reset! server (run-server
                  (wrap-cors app
                             :access-control-allow-origin #".*"
                             :access-control-allow-methods [:get])
                  {:port PORT})))
