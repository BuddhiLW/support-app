(ns caiu.saiba-mais.saiba-mais
  (:require
   ["@mui/material" :refer [ThemeProvider Box Grid]]
   [caiu.theme :refer [facti]]
   [caiu.componentes.titulo :refer [titulo]]))

(defn saiba-mais
  []
  [:<>
   [:> ThemeProvider {:theme facti}
    [titulo "Saiba mais"]
    [:> Grid {:container true
              :display "flex"
              :class-name "mx-auto mb-5 w-75 min-vh-75 "
              :sx {:flex-grow 1
                   :flex-direction "row"
                   :justify-content "center"}}]]])
