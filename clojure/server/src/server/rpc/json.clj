(ns server.rpc.json
  (:require [clojure.data.json :as json])
  (:require [server.methods.ui-test :as ui-test])
  (:require [server.methods.test :as test-methods])
  (:require [server.methods.small-report :as small-report])
  (:require [server.methods.medium-report :as medium-report])
  (:require [server.methods.large-report :as large-report])
  )


;; JSON RPC IMPLEMENTATION, ala KBase

(defn validate-header [request]
  (let [content-type (get (get request :headers) "content-type")]
    (when-not (= content-type "application/json")
            (throw (Exception. (str "Unexpected content type:" content-type))))
   request))

(defn extract-json [request]
  (let [json (json/read (clojure.java.io/reader (:body request)) :key-fn clojure.core/keyword)]
    (assoc request :json-rpc-message json)))

(def method-map {"test.info" test-methods/info
                 "eapearsonUiTestModule.status" ui-test/status
                 "eapearsonUiTestModule.run_time_test" ui-test/run-time-test
                 "eapearsonUiTestModule.small_report" small-report/generate-small-report
                 "eapearsonUiTestModule.medium_report" medium-report/generate-medium-report
                 "eapearsonUiTestModule.large_report" large-report/generate-large-report
                 })

(defn dispatch [request]
  (let [json (:json-rpc-message request)]
    (let [method (:method json)
          params (:params json)
          id (:id json)]
        (let [found-method (get method-map method)]
          (if found-method
            (let [result (apply found-method [params])]
              {
               :status 200
               :headers {"Content-type" "application/json"}
               :body (json/write-str {"version" "1.1"
                                      "id" id
                                      "result" result})})

            "Sorry, not found")))))

(defn validate [request]
  (let [json (:json-rpc-message request)]
    (let [version (:version json)
          method (:method json)
          params (:params json)
          id (:id json)]
      (if (not= version "1.1")
        (throw (Exception. (str "Incorrect json rpc version " version))))
      request)))
