(ns server.async-app
  (:require [clojure.data.json :as json])
  (:require [clojure.java.io :as io])
  (:require [me.raynes.fs :as fs]))


(defn run
  [in-file out-file token]
  ;; look for in-file
  (with-open [in (io/reader in-file)]

    (let [in-data (json/read in)
          files (map #(.getName %) (fs/list-dir "./work"))]
      ;; (println "files?" files)
      (println "files in working dir")
      (println files)
      (with-open [writer (io/writer out-file)]
        (json/write `{:result {:input-data ~in-data :files ~files}
                      :error nil
                      :is_cancelled 0} writer)))))


  ;; not found, write out error and return

  ;; found ,read it in as json

  ;; error? write it out and return

  ;; for now we are just echoing the input back to output, since
  ;; we don't know the format!
