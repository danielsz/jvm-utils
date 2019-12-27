(ns jvm-utils.core
  (:require [clojure.java.io :as io])
  (:import [java.util Properties]))

(defn merge-properties
  ([]
   (when-let [properties-file (System/getProperty "properties.file")]
     (merge-properties properties-file)))
  ([properties-file]
   (with-open [in (io/input-stream properties-file)]
     (let [props (Properties. (System/getProperties))]
       (.load props in)
       (System/setProperties props)))))


