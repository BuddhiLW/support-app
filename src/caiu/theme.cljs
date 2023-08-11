(ns caiu.theme
  (:require
   ["@mui/material/styles" :refer [createTheme]]))

(def nav (createTheme
          (clj->js
           {:palette
            {:primary
             {:main "#0A0A0A"
              :secondary "#51A8B1"
              :tertiary "#F5E033"
              :pale-grey "#ECF5F7"}}})))

(def facti-button (createTheme
                   (clj->js
                    {:palette
                     {:primary
                      {:main "#ECF5F7"
                       :secondary "#51A8B1"}}})))

(def faq-theme (createTheme
                (clj->js
                 {:palette
                  {:primary
                   {:main "#0A0A0A"
                    :secondary "#51A8B1"
                    :tertiary "#F5E033"
                    :pale-grey "#ECF5F7"}}})))

(def facti (createTheme
            (clj->js
             {:palette
              {:primary
               {:main "#0A0A0A"
                :secondary "#51A8B1"
                :tertiary "#F5E033"
                :pale-grey "#ECF5F7"}}})))
