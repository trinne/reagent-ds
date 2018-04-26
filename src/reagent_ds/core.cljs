(ns reagent-ds.core
    (:require
      [reagent.core :as r]
      [reagent-ds.atoms.buttons :refer [button button-primary button-danger]]))

;; -------------------------
;; Views

(defn home-page []
  [:div
   [:h1 "Reagent Design System"]
   [:h2 "Buttons"]
   (button "Button")
   (button-primary "Primary")
   (button-danger "Danger")])

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
