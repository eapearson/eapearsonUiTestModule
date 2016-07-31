(ns server.core
  ;; deps
  (:require [ring.adapter.jetty :as jetty])
  (:require [clojure.tools.cli :refer [parse-opts]])
  (:require clojure.pprint)
  (:require [clojure.string :as string])
  (:require [clojure.data.json :as json])
  (:require [ring.middleware.stacktrace :as stacktrace])
  (:require [compojure.core :as cjr])
  (:require [compojure.route :as route])
  ;; routes
  ;;(:require [server.routes.rest :as rest])
  ;;(:require [server.routes.greet :as greet])
  (:require [server.routes.rpc :as rpc])
  (:require [server.async-app :as async-app])
  (:gen-class))


(cjr/defroutes my-routes
  ;;(cjr/GET "/hi/:name" [name]
   ;;        (greet/say name))
  (cjr/POST "/rpc" request
            (rpc/handle request))
  ;;(cjr/GET "/rest" request
  ;;          (rest/handle request))
)

(defn spy [handler]
  (fn [request]
    (clojure.pprint/pprint request)
    (let [response (handler request)]
      (clojure.pprint/pprint response)
      response)))

(def app
  (-> my-routes stacktrace/wrap-stacktrace))

;;(def cli-options
;;  [[

(defn -main [& args]
  (let [{:keys [options arguments errors summary]} (parse-opts args [])]
    (cond
      (= 1 (count arguments))
       (let [port (Integer/parseInt (first arguments))]
        (jetty/run-jetty app {:port port}))
      (= 3 (count arguments))
        (try
          (let [result (apply async-app/run arguments)]
            (print result)
            result)
          (catch Exception e
            (println (str "caught exception: " (.getMessage e)))))
        ;; (throw (Exception. "The arity-3 version of this service is not supported ... yet"))
        ;; context-file  - is actually the json-rpc payload in a file
        ;; output-file   - name of file in which to provide response
        ;; token         - the auth token
        ;;(let [[context-file output-file token] arguments]
      ;;    (let [json (json/read (io/input-stream (java.io.File. context-file)) :key-fn clojure.core/keyword)
      ;;         [output]
      :else (throw (Exception. "Usage: invalid # of arguments"))
      )))
