(ns caiu.solicitacao.solicitacao-de-atendimento
  (:require
   ["@mui/material" :refer [Button Grid ThemeProvider Typography]]
   ["react-google-recaptcha" :default ReCAPTCHA]
   [caiu.componentes.formulario :refer [modelo-form]]
   [caiu.componentes.titulo :refer [titulo]]
   [caiu.nav.events]
   [caiu.router :as router]
   [caiu.theme :refer [facti]]
   [goog.dom :as gdom]
   [re-frame.core :as rf]
   [reagent.core :as r]
   [reagent.dom :as rdom]
   [caiu.solicitacao.key :refer [rechap-key]]))
;; import ReCAPTCHA from "react-google-recaptcha";

(defn texto-ajuda
  []
  [:> Typography {:color "textSecondary"
                  :font-weight 400
                  :margin-top "-2em"
                  :class-name "mx-auto mb-2 w-75 min-vh-75"
                  :display "flex"
                  :justify-content "center"}
   [:<>
    [:> Typography "Não encontrou sua dúvida nas "]
    [:> Typography {:href (router/path-for :faq)
                    :on-click #(rf/dispatch [:set-active-nav :faq])
                    :margin-left "0.3em"
                    :margin-right "0.3em"
                    :as "a"}
     "Perguntas Frequentes?"]
    [:> Typography " Envie sua mensagem!"]]])

;; (defn re-captcha
;;   []
;;   (r/create-class
;;    {:component-did-mount
;;     (fn [this]
;;       (rdom/render
;;        [:> ReCAPTCHA
;;         {:sitekey rechap-key
;;          :onChange (fn [value]
;;                      (println "Captcha value:" value))}]
;;        (gdom/getElement "recaptcha")))
;;     :reagent-render
;;     [:div.recaptcha#recaptcha "hello"]}))

(defn solicitacao-de-atendimento
  []
  (let [valores-iniciais {:nome-empresa ""
                          :cnpj ""
                          :nome ""
                          :email ""
                          :telefone ""
                          :categoria ""
                          :assunto ""
                          :mensagem ""
                          :anexo ""
                          :nao-sou-robo? false
                          :enviado? false}
        valores (r/atom valores-iniciais)]
    (fn []
      [:> Grid {:class-name "overflow-hidden overflow-y-auto"
                :sx {:background-color "#F5F5F5"}
                :min-height "90vh"}
       [:> ThemeProvider {:theme facti}
        [:<>
         [titulo "Solicitação de Atendimento"]
         [texto-ajuda]
         [:> Grid {:container true
                   :display "flex"
                   :class-name "mx-auto w-75 min-vh-75"
                   :flex-direction "row"
                   :justify-content "center"
                   :height "100%"
                   :min-height "30vh"
                   :max-height "100%"
                   :mb 12
                   :mt 4}
          [:> Grid {:item true
                    :sx {:justify-content "center"}
                    :max-width "50%"
                    :display "flex"
                    :flex-direction "column"
                    :class-name "mr-2 overflow-hidden overflow-y-auto"}
           [modelo-form {:id :nome-empresa
                         :label "Nome da Empresa/Instituição"
                         :type "text"
                         :values valores}]
           [modelo-form {:id :cnpj
                         :label "CNPJ da Empresa/Instituição"
                         :type "text"
                         :values valores}]
           [modelo-form {:id :nome
                         :label "Nome"
                         :type "text"
                         :values valores}]
           [modelo-form {:id :email
                         :label "E-mail"
                         :type "text"
                         :values valores}]
           [modelo-form {:id :telefone
                         :label "Telefone"
                         :type "text"
                         :values valores}]
           [modelo-form {:id :categoria
                         :label "Categoria"
                         :type "text"
                         :values valores}]]
          [:> Grid {:item true
                    :mx 10
                    :sx {:justify-content "center"}
                    :max-width "50%"
                    :display "flex"
                    :flex-direction "column"
                    :class-name "mr-2 overflow-hidden overflow-y-auto"}
           [modelo-form {:id :assunto
                         :label "Assunto"
                         :type "text"
                         :values valores}]
           [modelo-form {:id :mensagem
                         :label "Mensagem"
                         :type "text"
                         :values valores}]
           [:> Grid {:mt 3}
            [:> Button
             {:variant "contained"}
              ;; :color "primary."}
             "Adicionar anexo"]
            [:div.control.form.mb-2.mt-2
              ;; [:div "Não sou um robô"]
             [:> ReCAPTCHA {:sitekey rechap-key}]] ;;"6Lf1imgaAAAAAIxmO9Co8YcUIK20YxOIlh5brD9d"
            [:> Button
             {:variant "contained"
              :color "primary"}
              ;; :onClick #(rf/dispatch [:caiu.acompanhamento.enviar-atendimento @valores])}
             "Enviar"]
            [:br]
            [:> Button {:href (router/path-for :procura-atendimento)
                        :on-click #(rf/dispatch [:set-active-nav :procura-atendimento])
                        :class-name "mt-2"
                        :variant "outlined"
                        :color "primary"}
             "Já enviou sua mensagem? Acompanhe sua solicitação!"]]]]]]])))
