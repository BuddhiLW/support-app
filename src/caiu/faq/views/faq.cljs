(ns caiu.faq.views.faq
  (:require
   ["@mui/material" :refer [ThemeProvider Grid]]
   [caiu.theme :refer [faq-theme]]
   [caiu.faq.views.topicos :refer [topicos]]
   [caiu.faq.views.menu :refer [menu]]
   [caiu.componentes.titulo :refer [titulo]]))

(defn faq
  []
  [:<>
   [:> ThemeProvider {:theme faq-theme}
    [titulo "Perguntas Frequentes"]
    [:> Grid {:container true
              :display "flex"
              :class-name "mx-auto mb-5 w-75 min-vh-75 "
              :sx {:flex-grow 1
                   :flex-direction "row"
                   :justify-content "center"}}
     [menu]
     [topicos]]]])
