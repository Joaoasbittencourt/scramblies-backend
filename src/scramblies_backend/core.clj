(ns scramblies-backend.core
  (:gen-class)
  (:require [org.httpkit.server :refer [run-server]]
            [reitit.ring :as ring]
            [scramblies-backend.routes :refer [routes]]
            [muuntaja.core :as m]
            [reitit.ring.middleware.exception :refer [exception-middleware]]
            [reitit.ring.middleware.muuntaja :refer [format-negotiate-middleware
                                                     format-request-middleware
                                                     format-response-middleware]]))

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
                   :body "Route not found"})}))

   {:data {:muuntaja m/instance
           :middleware [format-negotiate-middleware
                        format-request-middleware
                        exception-middleware
                        format-response-middleware]}}))

(defn -main []
  (println "[scramblies]" "server started on port" PORT)
  (reset! server (run-server app {:port PORT})))
