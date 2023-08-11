(ns caiu.utilitarios.cores
  (:require
   ["@mui/material" :refer [colors]]))

(defn color
  "Specify the vector of color and intensity (keys)"
  [[cor intensidade]]
  (get-in (js->clj colors :keywordize-keys true) [cor intensidade]))
