(ns caiu.acompanhamento.formulario-de-procura
  (:require
   ["@mui/material" :refer [Button Grid ThemeProvider]]
   ["react-google-recaptcha" :default ReCAPTCHA]
   [caiu.solicitacao.key :refer [rechap-key]]
   [caiu.componentes.titulo :refer [titulo]]
   [caiu.theme :refer [facti]]
   [reagent.core :as r]
   [caiu.componentes.formulario :refer [modelo-form]]
   [caiu.router :as router]
   [re-frame.core :as rf]))

(defn acompanhar-atendimento
  []
  (let [valores-iniciais {:cnpj ""
                          :numero-solicitacao ""
                          :crc ""
                          :codigo-verificador ""
                          :nao-sou-robo? false
                          :enviado? false}
        valores (r/atom valores-iniciais)]
    (fn []
      [:> Grid {;;:class-name "overflow-hidden overflow-y-auto"
                :sx {:background-color "#F5F5F5"}
                :min-height "80vh"
                :max-height "80vh"}
       [:> ThemeProvider {:theme facti}
        [:<>
         [titulo "Acompanhe sua Solicitação"]
         [:> Grid {:container true
                   :display "flex"
                   :class-name "mx-auto w-75 min-vh-75"
                   :flex-direction "row"
                   :justify-content "center"
                   :height "100%"
                   :min-height "30vh"
                   :max-height "100%"
                   :margin-top "-3em"
                   :mb 12}
          [:> Grid {:item true
                    :mx 10
                    :sx {:justify-content "center"}
                    :max-width "50%"
                    :display "flex"
                    :flex-direction "column"
                    :class-name "mr-2 overflow-hidden overflow-y-auto"}
           [modelo-form {:id :cnpj
                         :label "CNPJ da Empresa/Instituição"
                         :type "text"
                         :values valores}]
           [modelo-form {:id :numero-solicitacao
                         :label "Número da Solicitação"
                         :type "text"
                         :values valores}]
           [modelo-form {:id :crc
                         :label "CRC"
                         :type "text"
                         :values valores}]
           [modelo-form {:id :codigo-verificador
                         :label "Código Verificador"
                         :type "text"
                         :values valores}]
           [:> Grid {:mt 3}
            [:div.control.form.mb-3
             [:> ReCAPTCHA {:sitekey rechap-key}]] ;;"6Lf1imgaAAAAAIxmO9Co8YcUIK20YxOIlh5brD9d"
            [:> Button
             {:variant "contained"
              :color "primary"}
              ;; :onClick #(rf/dispatch [:caiu.acompanhamento.enviar-atendimento @valores])}
             "Buscar"]]]]]]])))
