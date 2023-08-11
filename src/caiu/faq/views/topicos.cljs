(ns caiu.faq.views.topicos
  (:require
   ["@mui/icons-material/ExpandMore" :default ExpandMoreIcon]
   ["@mui/material" :refer [Accordion AccordionDetails AccordionSummary Box
                            Grid Typography]] ;; import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
   [re-frame.core :as rf]
   [caiu.faq.subs]))

(defn topicos
  []
  (fn []
    (let [{:keys [topico pergunta]} @(rf/subscribe [:faq/ativo])]
      [:> Grid {:item true
                :sx {:justify-content "center"}
                :class-name "pl-1 text-slate-700" ;;bg-danger bg-info
                :min-width "60%"
                :max-width "70%"
                :font-weight 500
                :component "h4"}
       [:<>
        (for [subtopico @(rf/subscribe [:faq/subtopicos {:id-topico topico}])
              :let [{:keys [pergunta resposta]} (val subtopico)]]
          ^{:key (random-uuid)}
          [:> Accordion
           [:> AccordionSummary {:aria-controls "panel1a-content"
                                 :id (str topico pergunta resposta)}
            [:> Grid {:item true
                      :display "flex"
                      :sx {:justify-content "center"}}
             [:> Box {:color "red"
                      :class-name "mr-2 bg-danger"
                      :width "0.2em"
                      :height "100%"}]
             [:> Typography {:text-align "left"
                             :font-weight 700}
              pergunta]
             [:> ExpandMoreIcon {:color "primary"}]]]
           [:> AccordionDetails
            [:> Typography {:text-align "left"
                            :font-weight 300}
             resposta]]])]])))

