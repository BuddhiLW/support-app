(ns caiu.componentes.rodape
  (:require
   ["@mui/material" :refer [Grid Typography]]))

(defn rodape
  []
  [:> Grid {:align-items "left"
            :justify-content "left"
            :container true
            :position "fixed"
            :bottom 0
            :ml 4
            :mb 2
            :row true}
   [:> Typography
    {:variant "h6"
     :color "textSecondary"
     :font-size "0.55em"
     :font-weight 300
     :component "p"}
    "Sistema concebido e desenvolvido por:"
    [:br]
    "Facti - Fundação de Apoio à Capacitação em Tecnologia da Informação"]])
