(ns caiu.router
  (:require [bidi.bidi :as bidi]
            [pushy.core :as pushy]
            [re-frame.core :as rf]))

(def routes ["/" {""                           :caiu
                  "saiba-mais"                 :saiba-mais
                  "faq/"                       {""           :faq
                                                [:id-topico] :topico}
                  "solicitacao-de-atendimento" :solicitacao-de-atendimento
                  "aporte-no-ppi"              :aporte-no-ppi
                  "procura-atendimento"        :procura-atendimento}])

(def history
  (let [dispatch #(rf/dispatch [:route-changed %])
        match #(bidi/match-route routes %)]
    (pushy/pushy dispatch match)))

(defn start!
  []
  (pushy/start! history))

(def path-for
  (partial bidi/path-for routes))

(defn set-token!
  [token]
  (pushy/set-token! history token))
