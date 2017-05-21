(defproject movies-recommender "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [com.stuartsierra/component "0.3.2"]
                 [clojurewerkz/neocons "3.1.0"]
                 [environ "1.1.0"]
                 [cprop "0.1.10"]]
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.11"]
                                  [com.stuartsierra/component.repl "0.2.0"]]
                   :source-paths ["dev"]
                   :resource-paths ["dev/resources"]}})
