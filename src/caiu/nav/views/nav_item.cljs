(ns caiu.nav.views.nav-item
  (:require
   ["@mui/material" :refer [Button Typography Tooltip
                            ThemeProvider Button Box
                            Grid]]
   ["@mui/icons-material/KeyboardArrowLeft" :default KeyboardArrowLeftIcon]
   [caiu.theme :refer [nav facti-button]]))

(defn box-retorno [{:keys [id name href dispatch fa active-page]}]
  ^{:key id}
  (when (not= active-page id)
    [:> ThemeProvider {:theme facti-button}
     [:> Tooltip {:title (str name) :follow-cursor true}
      [:> Button
       {:style {:margin-left "-7rem"}
        :class-name "h-25 my-auto mr-4"
        :on-click dispatch
        :href href
        :variant "contained"
        :sx {:background-color "primary.main"
             "&:hover" {:background-color "primary.secondary"
                        :color "primary.main"}
             :as "a"}}
       [:> Grid {:display "flex"
                 :align-items "center"
                 :justify-content "center"
                 :flex-direction "row"}
        [:> KeyboardArrowLeftIcon]
        [:> Typography {:font-size "0.8em"
                        :sx {"&:hover" {:color "primary.pale-grey"}}
                        :color "primary.primary"
                        :style {:word-break "break-all"}}
         name]]]]]))

(defn box
  [{:keys [id name href dispatch fa active-page]}]
  ^{:key id}
  [:> ThemeProvider {:theme nav}
   [:> Tooltip {:title (str "Navegar para: " name) :follow-cursor true}
    (if (= active-page id)
      [:> Button
       {:display "flex"
        :alignitems "center"
        :on-click dispatch
        :ml 2
        :pb 10
        :href href
        :class-name (str "d-flex.flex-column.align-items-center.w-25.align-middle")
        :variant "h6"
        :font-size "1.1em"
        :color "primary.main"
        :sx {"&:hover" {:background-color "primary.secondary"}
             :as "a"}}
       [:> Box {:align-items "center"
                :flex-direction "column"
                :display "flex"
                :sx {:z-index 1000000}
                :style {:z-index 100000}}
        [:i.fa.fa-5x.m-3.preto-itens.icone
         {:class fa}]
        [:> Typography {:variant "h6"
                        :font-size "1.1em"
                        :sx {"&:hover" {:color "primary.pale-grey"}}
                        :color "primary.primary"}
         name]]]
      [:> Button
       {:display "flex"
        :align-items "center"
        :on-click dispatch
        :ml 2
        :pb 10
        :class-name (str "d-flex.flex-column.align-items-center.w-25.align-middle")
        :href href
        :variant "h6"
        :font-size "1.1em"
        :color "primary.tertiary"
        :sx {"&:hover" {:background-color "primary.pale-grey"
                        :color "primary.secondary"}
             :as "a"}}
       [:> Box {:align-items "center"
                :flex-direction "column"
                :display "flex"}
        [:i.fa.fa-5x.m-3.preto-itens.icone
         {:class fa}]
        [:> Typography {:variant "h6"
                        :font-size "1.1em"
                        :sx {"&:hover" {:color "primary.secondary"}}
                        :color "primary.primary"}
         name]]])]])
