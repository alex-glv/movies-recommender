(ns dev
  "Tools for interactive development with the REPL. This file should
  not be included in a production build of the application.

  Call `(reset)` to reload modified code and (re)start the system.

  The system under development is `system`, referred from
  `com.stuartsierra.component.repl/system`.

  See also https://github.com/stuartsierra/component.repl"
  (:require [clojure.java.io :as io]
            [clojure.java.javadoc :refer [javadoc]]
            [clojure.pprint :refer [pprint]]
            [clojure.reflect :refer [reflect]]
            [clojure.repl :refer [apropos dir doc find-doc pst source]]
            [clojure.set :as set]
            [clojure.string :as string]
            [clojure.test :as test]
            [clojure.tools.namespace.repl :refer [clear refresh refresh-all]]
            [com.stuartsierra.component :as component]
            [com.stuartsierra.component.repl
             :refer
             [reset set-init start stop system]]
            [cprop.core :as cp]
            movies-recommender
            system))

;; Do not try to load source code from 'resources' directory
(clojure.tools.namespace.repl/set-refresh-dirs "dev" "src" "test")

(def config (cp/load-config))
(defn dev-system
  "Constructs a system map suitable for interactive development."
  []
  (component/system-map
     :neo4j (system/new-neo4j-db (get-in config [:neo4j :uri])
                                 (get-in config [:neo4j :user])
                                 (get-in config [:neo4j :password]))))

(set-init (fn [_] (dev-system)))
