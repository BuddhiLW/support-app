(ns caiu.nav.subs
  (:require
   [re-frame.core :as rf]))

(rf/reg-sub
 :nav
 (fn [db _]
   (get db :nav)))

(rf/reg-sub
 :navegacao-ativa
 :<- [:nav]
 (fn [nav _]
   (get nav :pagina-ativa)))
