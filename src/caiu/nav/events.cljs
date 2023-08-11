(ns caiu.nav.events
  (:require
   [caiu.db :refer [api-url]]
   [clojure.string :as str]
   [re-frame.core :as rf]))

(defn endpoint
  "Concat any params to api-url separated by /"
  [& params]
  (str/join "/" (cons api-url params)))

(rf/reg-fx
 :http/redirecionar
 (fn [id]
   (js/console.log "id: " id)
   (case id
     :aporte-no-ppi (set! (.-href js/location) "https://duckduckgo.com/")
     :saiba-mais (set! (.-href js/location) "https://www.ibm.com/topics/help-desk"))))

;; log-route-changed-params (js/console.log "handler: " handler ", route-params: " route-params)
;; (do
;;    (js/console.log "Página ativa: " (assoc nav :pagina-ativa handler))))

(rf/reg-event-fx
 :route-changed
 ;; nav-interceptors
 (fn [{nav :db} [_ {:keys [handler route-params]}]]
   (js/console.log "handler: " handler ", route-params: " route-params)
   (let [nav              (assoc nav :pagina-ativa handler)]
     (case handler
       :aporte-no-ppi {:db (assoc nav :pagina-ativa handler)
                       :http/redirecionar :aporte-no-ppi}
       :saiba-mais  {:db (assoc nav :pagina-ativa handler)
                     :http/redirecionar :saiba-mais}
       {:db               (assoc nav :pagina-ativa handler)}))))

(rf/reg-event-db
 :set-active-nav
 ;; nav-interceptors
 (fn [db [_ active-nav]]
   (assoc-in db [:nav :pagina-ativa] active-nav)))
