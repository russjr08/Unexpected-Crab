(defproject crab "0.1.0-SNAPSHOT"
  :description "what is this"
  :url "https://github.com/russjr08/Unexpected-Crab"
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :main ^:skip-aot crab.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
