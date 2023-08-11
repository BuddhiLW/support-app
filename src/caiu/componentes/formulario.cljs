(ns caiu.componentes.formulario
  (:require
   ["@mui/material" :refer [FormControl Grid Input Typography TextField]]
   [clojure.string :as str]
   [caiu.utilitarios.cores :as util]
   [re-frame.core :as rf]
   [reagent.core :as r]))

(def r-input
  (r/reactify-component
   (fn [props]
     [:input (dissoc props :ref)])))

(defn modelo-form
  [{:keys [id label type values  & not-deref? text-area? on-key-down]}]
  [:> FormControl {:full-width true}
   [:> Grid {:container true
             :display "flex"
             :flex-direction "column"
             :mt 4}
    [:> Grid {:item true
              :sx {:justify-content "center"}
              :class-name "pl-1 text-slate-700"
              :html-for id
              :font-weight 500
              :font-size "0.8em"}
     label]
    (let [errors @(rf/subscribe [:form/errors])
          input-error (get errors id)
          error (if input-error true false)
          is-empty? (str/blank? (id @values))
          validate (fn []
                     (if is-empty?
                       (rf/dispatch [:form/has-value? id])
                       (rf/dispatch [:form/clear-error id])))]

      [:> Grid {:item true}
       ;; (if text-area?
       [:> TextField
        {:variant "filled"
         :inputComponent r-input
         :value (if not-deref? (id values) (id @values))
         :on-blur validate
         :type type
         :on-change #(swap! values assoc id (.. % -target -value))
                      ;; :full-width true
                      ;; :multiline true
                      ;; :rows (if text-area? 4 1)
         :on-key-down on-key-down
         :on-key-up (when-not (str/blank? (id @values)) validate)
         :error error}]

       (when error
         [:> Typography {:variant "caption"
                         :display "block"
                         :color (util/color [:red :600])
                         :sx {:mt 0.1
                              :mb 0.1}}
          input-error])])]])
