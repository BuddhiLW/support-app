(ns caiu.componentes.cabecalho)

(defn cabecalho []
  [:<>
   [:div.d-flex.justify-content-around.flex-row.mb-5.mt-2
    [:div
     [:img.w-auto {:style {:height "100px"}
                   :src "/assets/images/logo_1.png"}]]
    [:div
     [:img.imagem-logo-tamanho {:style {:height "100px"}
                                :src "/assets/images/logoppinova.png"}]]]])
