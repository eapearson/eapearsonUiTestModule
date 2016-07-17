(ns server.async-app
  (:require [clojure.data.json :as json])
  (:require [clojure.java.io :as io]))

(defn run
  [in-file out-file token]

  ;; look for in-file
  (with-open [in (io/reader in-file)]

    (let [in-data (json/read in)]
      (with-open [writer (io/writer out-file :append true)]
        (json/write in-data writer))))


  ;; not found, write out error and return

  ;; found ,read it in as json

  ;; error? write it out and return

  ;; for now we are just echoing the input back to output, since
  ;; we don't know the format!


  (str "You gave me " in-file ", " out-file ", and " token))
