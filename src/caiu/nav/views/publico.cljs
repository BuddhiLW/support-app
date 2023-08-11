(ns caiu.nav.views.publico
  (:require
   ["@mui/material" :refer [Grid]]
   [caiu.nav.views.nav-item :refer [box box-retorno]]
   [caiu.router :as router]
   [re-frame.core :as rf]))

(defn publico
  []
  (let [active-page @(rf/subscribe [:navegacao-ativa])
        nav-items [{:id :caiu
                    :name "Central de Atendimento"
                    :href (router/path-for :caiu)
                    :dispatch #(rf/dispatch [:set-active-nav :caiu])
                    :fa "fa-file-text-o"}
                   {:id :saiba-mais
                    :name "What is a help-desk? (IBM)"
                    :href (router/path-for :saiba-mais)
                    :dispatch #(rf/dispatch [:route-changed :saiba-mais])
                    :fa "fa-file-text-o"}
                   {:id :faq
                    :name "Perguntas Frequentes"
                    :href (router/path-for :faq)
                    :dispatch #(rf/dispatch [:set-active-nav :faq])
                    :fa "fa-cogs"}
                   {:id :solicitacao-de-atendimento
                    :name "Solicitação de Atendimento"
                    :href (router/path-for :solicitacao-de-atendimento)
                    :dispatch #(rf/dispatch [:set-active-nav :solicitacao-de-atendimento])
                    :fa "fa-comments-o"}
                   {:id :aporte-no-ppi
                    :name "Duck Duck Go search"
                    :href (router/path-for :aporte-no-ppi) ;; (url) + boleto.html
                    :dispatch #(rf/dispatch [:route-changed :aporte-no-ppi])
                    :fa "bi-collection"}]]

    [:> Grid {:mt 3}
     [:div.d-flex.justify-content-center
      (for [{:keys [id name href dispatch fa]} nav-items]
        (case id
          :caiu [box-retorno {:key id
                              :id id
                              :name name
                              :href href
                              :fa fa
                              :dispatch dispatch
                              :active-page active-page}]
          [box {:key id
                :id id
                :name name
                :href href
                :fa fa
                :dispatch dispatch
                :active-page active-page}]))]]))
