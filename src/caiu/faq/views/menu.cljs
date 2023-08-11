(ns caiu.faq.views.menu
  (:require
   ["@mui/material" :refer [Button Button Grid ListItemButton ListItemText
                            Typography ThemeProvider Divider]]
   [caiu.faq.subs]
   [caiu.router :as router]
   [caiu.faq.events]
   [re-frame.core :as rf]))

(defn menu []
  (let [topicos @(rf/subscribe [:faq/topicos])]
    (fn []
      [:> Grid {:item        true
                :sx          {:justify-content "center"}
                :class-name  "pl-1 text-slate-700 mx-4" ;; bg-danger
                :font-weight 500
                :component   "h4"}
       (let [{:keys [topico pergunta]} @(rf/subscribe [:faq/ativo])
             topico-ativo                    topico]
         [:<>
          (for [topico topicos
                :let   [{:keys [titulo id-topico]} (val topico)]]
            (if (= id-topico topico-ativo)
              [:> Grid {:class-name "bg-info"}
               [:> ListItemButton {:component "a"
                                   :href      (router/path-for :topico :id-topico  id-topico)}
                [:> Typography {:underline "hover"
                                :sx {"&:hover" {:color "primary.pale-grey"}
                                     :color "primary.main"}}
                 titulo]]
               [:> Divider {:orientation "horizontal"}]]
              [:> Grid {:class-name "bg-danger"}
               [:> ListItemButton {:component "a"
                                   :href      (router/path-for :topico :id-topico  id-topico)
                                   :on-click  #(rf/dispatch [:faq/topico-ativo {:id-topico id-topico}])}
                [:> Typography {:sx {"&:hover" {:color "primary.pale-grey"}
                                     :color "primary.main"}}

                 titulo]]
               [:> Divider {:orientation "horizontal"}]]))])])))

(comment
  (router/path-for :topico :id-topico :um)
  (router/path-for :recipe :recipe-id "123")
  (router/path-for :solicitacao))
