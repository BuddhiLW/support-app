(ns caiu.faq.subs
  (:require
   [re-frame.core :as rf]))

(rf/reg-sub
 :faq/faq
 (fn [db _]
   (:faq db)))

(rf/reg-sub
 :faq/topicos
 :<- [:faq/faq]
 (fn [faq _]
   (:topicos faq)))

(rf/reg-sub
 :faq/ativo
 :<- [:faq/faq]
 (fn [faq _]
   (:ativo faq)))

(rf/reg-sub
 :faq/subtopicos
 :<- [:faq/faq]
 (fn [faq [_ {:keys [id-topico]}]]
   (get-in faq [:topicos id-topico :subtopicos])))

(rf/reg-sub
 :faq/subtopico
 :<- [:faq/faq]
 (fn [faq [_ {:keys [id-topico id-pergunta]}]]
   (get-in faq [:topicos id-topico :subtopicos id-pergunta])))
