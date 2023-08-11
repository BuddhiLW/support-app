(ns caiu.central.views.pagina
  (:require
   [caiu.componentes.titulo :refer [titulo]]))

(defn central []
  [:<>
   [titulo "Central de Atendimento e Informações ao Usuário"]
   [:div.d-flex.justify-content-center.mb-2
    [:h2.sub-titulo-tamanho "Como podemos te ajudar?"]]
                                 ;; "Navegação"
   [:div.input-group.mb-3.navegacao.mx-auto.w-75.mb-5
    [:input.form-control {:type        "text"
                          :placeholder "Busque por uma dúvida"
                          :aria-label  "Procura por tópicos"}]
    [:div.ml-2 ;; .input-group-append
     [:button.btn.btn-outline-secondary.azul-procura-fundo.azul-procura-lupa
      {:type  "button"
       :style {:width "4rem"}}
      [:i.fa.fa-search]]]]])

;; itens                  [:div.d-flex.justify-content-around.mx-auto.w-75.flex-row.align-self-center ;;.preto-itens-busca
;;                         [:div.d-flex.flex-column.align-items-center.w-25.align-middle ;; .bg-danger
;;                          [:i.fa.fa-file-text-o.fa-5x.m-3.preto-itens.icone ;; .bg-warning
;;                           {:aria-hidden "true"}]
;;                          [:p.preto-itens.texto.breakword.mx-3.text-center ;;.bg-info
;;                           "Saiba mais sobre o PPI"]]
;;                         [:div.d-flex.flex-column.align-items-center.w-25.align-middle ;; .bg-danger
;;                          [:i.fa.fa-cogs.fa-5x.m-3.preto-itens.icone ;; .bg-warning
;;                           {:aria-hidden "true"}]
;;                          [:p.preto-itens.texto.breakword.mx-3.text-center ;;.bg-info
;;                           "Perguntas Frequentes"]]
;;                         [:div.d-flex.flex-column.align-items-center.w-25.align-middle ;; .bg-danger
;;                          [:i.fa.fa-comments-o.fa-5x.m-3.preto-itens.icone ;; .bg-warning
;;                           {:aria-hidden "true"}]
;;                          [:p.preto-itens.texto.breakword.mx-3.text-center ;;.bg-info
;;                           "Solicitação de Atendimento"]]
;;                         [:div.d-flex.flex-column.align-items-center.w-25.align-middle ;; .bg-danger
;;                          [:i.bi.bi-collection.mt-3.fa-4x.preto-itens.icone
;;                           ;; .bg-warning ;; fa-5x ;;<i class="bi bi-collection"></i>
;;                           {:aria-hidden "true"}]
;;                          [:p.preto-itens.texto.breakword.mx-3.text-center ;;.bg-info
;;                           "Aporte no PPI"]]]]

;; itens]))
