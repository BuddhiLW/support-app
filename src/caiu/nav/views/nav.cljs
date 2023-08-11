(ns caiu.nav.views.nav
  (:require
   [caiu.nav.views.publico :refer [publico]]))

(defn nav
  []
  (let [logged-in? false] ;;@(rf/subscribe [:logged-in?])]
    (if logged-in?
      [:div "authenticated"]
      [publico])))
