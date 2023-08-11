(ns caiu.views
  (:require
   [caiu.solicitacao.solicitacao-de-atendimento :refer [solicitacao-de-atendimento]]
   [caiu.central.views.pagina :refer [central]]
   [caiu.faq.views.faq :refer [faq]]
   [caiu.aportes.aportes-ppi :refer [aportes-ppi]]
   [caiu.saiba-mais.saiba-mais :refer [saiba-mais]]
   [caiu.acompanhamento.formulario-de-procura :refer [acompanhar-atendimento]]))

(defn pages
  [page-name]
  (case page-name
    :caiu                       [central]
    :faq                        [faq]
    :saiba-mais                 [saiba-mais]
    :solicitacao-de-atendimento [solicitacao-de-atendimento]
    :aporte-no-ppi              [aportes-ppi]
    :procura-atendimento        [acompanhar-atendimento]
    [central]))
