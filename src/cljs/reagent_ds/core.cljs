(ns reagent-ds.core
  (:require [reagent.core :as r]
            [reagent.session :as session]
            [reagent-ds.pages.main :as main]
            [reagent-ds.design-system :as design-system]
            [reagent-ds.routes :refer [routes]]
            [accountant.core :as accountant]
            [bidi.bidi :as bidi]))

;; -------------------------
;; Navigation
(def nav (atom {:atoms {:buttons ["main" "secondary"]}
                :molecules nil
                :organisms {:heading nil
                            :navigation nil}}))

;; -------------------------
;; Navigation
(defn path-exists? [path]
      (boolean (bidi/match-route routes path)))

(defn navigate [path]
  (let [match (bidi/match-route routes path)]
    (session/put! :route {:current-page (:handler match)
                          :route-params (:route-params match)})))

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [main/page nav] (.getElementById js/document "app")))

(defn init! []
  (design-system/init-ds!)
  (accountant/configure-navigation! {:nav-handler navigate :path-exists? path-exists?})
  (accountant/dispatch-current!)
  (mount-root))
