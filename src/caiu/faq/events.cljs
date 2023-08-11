(ns caiu.faq.events
  (:require
   [re-frame.core :as rf]))

(rf/reg-event-fx
 :faq/topico-ativo
 (fn [{:keys [db]} [_ {:keys [id-topico]}]]
   {:db (-> db
            (assoc-in [:faq :ativo :topico] id-topico)
            (assoc-in [:faq :ativo :pergunta] nil))}))
