(ns caiu.subs
  (:require
   [caiu.db :refer [default-db]]
   [re-frame.core :as rf]))

(rf/reg-event-fx
 :inicializar-db
 (fn [_ _]
   {:db default-db}))
