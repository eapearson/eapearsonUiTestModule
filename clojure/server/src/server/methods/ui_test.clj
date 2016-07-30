(ns server.methods.ui-test
  (:require [clojure.data.json :as json]))

;; somehow auto-injected?

(def serial-version-uid 1)
(def version "0.0.1")
(def git-url "https://github.com/eapearson/eapearsonUiTestModule.git")
(def git-commit-hash "9215d28dccfe128a4814e54715b767bd868ff379")


;; METHODS

(defn info [params]
  {"version" "1.0"
   "name" "test-rpc"})

(defn help [params]
  {"text" "ask me for help, and I'll give it to you."})

(defn run-time-test [params]
   (let [time-to-delay (:delay params)]
    (Thread/sleep time-to-delay)
    {"name" "delay"
     "result" "delayed"
     "delayed-for" time-to-delay}))

(defn status [params]
  {"state" "OK"
  "message" ""
  "version" version
  "git_url" git-url
  "git_commit_hash" git-commit-hash
})
