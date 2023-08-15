(ns caiu.core
  (:require
   ["@mui/material" :refer [Box Grid]]
   [caiu.router :as router]
   [goog.dom :as gdom]
   [re-frame.core :as rf]
   [caiu.db]
   [reagent.dom :as rdom]
   [caiu.subs]
   [caiu.nav.events]
   [caiu.nav.subs]
   [caiu.nav.views.nav :refer [nav]]
   [caiu.views :as views]
   [caiu.config :as config]
   [caiu.componentes.cabecalho :refer [cabecalho]]
   [caiu.componentes.rodape :refer [rodape]]
   [caiu.validacao.events]
   [caiu.validacao.subs]))

(defn- main-panel []
  (let [active-page @(rf/subscribe [:navegacao-ativa])]
    [:> Grid
     [cabecalho]
     [views/pages active-page]
     (case active-page
       :caiu                       [:> Grid
                                    [:> Box
                                     [nav]]
                                    [:> Box {:class-name "position-stiky fixed-bottom mb-5"}
                                     [rodape]]]
       :solicitacao-de-atendimento [:> Grid {;; Não mexer nesse estilo, ele é necessário para o funcionamento do navegador de secçoẽs.
                                             :min-height "1em"
                                             :class-name "position-stiky"
                                             :my 20}
                                    [:> Box {:min-height "10em"
                                             :class-name "fixed-bottom"
                                             :style {:z-index -1}}
                                     [nav]]
                                    [rodape]]
       :procura-atendimento [:> Grid {;; Não mexer nesse estilo, ele é necessário para o funcionamento do navegador de secçoẽs.
                                      :min-height "1em"
                                      :class-name "position-stiky"
                                      :my 20}
                             [:> Box {:min-height "10em"
                                      :class-name "fixed-bottom"
                                      :style {:z-index -1}}
                              [nav]]
                             [rodape]]
       [:> Grid {:class-name "position-stiky fixed-bottom my-5"}
        [:> Box
         [nav]]
        [rodape]])]))

(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

;; -----------------------------------------------------------------------------
;; Mount logic
(defn- render []
  (reagent.dom/render [main-panel] (gdom/getElement "app")))

(defn ^:dev/after-load mount-root []
  ;; (rf/clear-subscription-cache!)
  (render)
  #_(let [root-el (.getElementById js/document "app")]
      (rdom/unmount-component-at-node root-el)
      (rdom/render [main-panel] root-el)))

(defn ^:export init []
  (router/start!)
  (rf/dispatch-sync [:inicializar-db])
  (dev-setup)
  (mount-root))
