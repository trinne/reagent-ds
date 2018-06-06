(ns reagent-ds.atoms.buttons
  (:require [stylefy.core :as stylefy]))

;; STYLES
(def style-font {:font-size "24px"
                 :line-height "1"})

(def style-button (merge style-font
                         {}))

(def style-primary {:background-color "rgb(50, 100, 230)"})

(def style-danger {:background-color "red"})

;; COMPONENTS
(defn button [{:keys [style content]}]
     [:button (stylefy/use-style (merge style-button style))
      [:span content]])

(defn button-primary [{:keys [style content]}]
  [button {:content content
           :style (merge style-primary style)}])

(defn button-danger [{:keys [style content]}]
  [button {:content content
           :style (merge style-danger style)}])
