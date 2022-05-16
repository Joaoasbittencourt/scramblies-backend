(defproject scramblies-backend "0.1.0-SNAPSHOT"
  :description "Scramblies Challenge - Backend"
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [http-kit/http-kit "2.5.3"]
                 [metosin/reitit "0.5.18"]
                 [ring-cors "0.1.13"]]
  :main ^:skip-aot scramblies-backend.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
