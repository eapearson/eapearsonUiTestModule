(defproject server "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  ;; :plugins [[cider/cider-nrepl "0.11.0"]]
  :plugins [[lein-ring "0.9.7"]
            [lein-ancient "0.6.10"]]
  ;; This defines the entry point to the server
  :ring {:handler server.core/app}
  :main server.core
  :aot [server.core]
  :dependencies [[org.clojure/clojure "1.9.0-alpha14"]
                 [org.clojure/tools.cli "0.3.4"]
                 [org.clojure/data.json "0.2.6"]
                 [me.raynes/fs "1.4.6"]
                 ;; for easy properties file access
                 [clojurewerkz/propertied "1.2.0"]
                 [ring/ring "1.5.0"]
                 [ring/ring-jetty-adapter "1.5.0"]
                 [compojure "1.5.1"]])
