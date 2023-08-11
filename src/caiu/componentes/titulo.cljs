(ns caiu.componentes.titulo)

(defn titulo
  [texto]
  [:div.d-flex.justify-content-center.mb-5
   [:h1.titulo-cinza.titulo-tamanho texto]])
