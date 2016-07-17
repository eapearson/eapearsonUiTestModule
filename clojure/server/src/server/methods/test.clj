(ns server.methods.test
  (:require [clojure.data.json :as json]))

;; METHODS

(defn info [params]
  {"version" "1.0"
   "name" "test-rpc"})

(defn help [params]
  "ask me for help, and I'll give it to you.")
