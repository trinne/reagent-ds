(ns reagent-ds.core
    (:require [reagent.core :as r]
              [reagent-ds.pages.main :as main]
              [reagent-ds.design-system :as design-system]))

;; -------------------------
;; Navigation
(def nav (atom {:atoms {:buttons ["main" "secondary"]}
                :molecules nil
                :organisms {:heading nil
                            :navigation nil}}))

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render (main/page nav) (.getElementById js/document "app")))

(defn init! []
  (design-system/init-ds!)
  (mount-root))
