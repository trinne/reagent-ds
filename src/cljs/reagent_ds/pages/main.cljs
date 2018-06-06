(ns reagent-ds.pages.main
  (:require-macros [reagent-ds.macros :refer [$->]])
  (:require [reagent-ds.templates.main :as tpl]
            [reagent-ds.atoms.buttons :as btn]))

(defn page-content []
  [:div
   [:h1 "This is the content of the Reagent Design System"]
   [btn/button {:content "Default"
                :style {:margin "5px"}}]
   [btn/button-primary {:content "Primary"
                        :style {:margin "5px"}}]
   [btn/button-danger {:content "Danger"
                       :style {:margin "5px"}}]
   ($-> [btn/button {:content "Default"}])
   ($-> [btn/button-primary {:content "Primary"}])
   ($-> [btn/button-danger {:content "Danger"}])])

(defn page [nav]
  (tpl/default {:navigation nav
                :heading "Reagent Design System"
                :main-content [page-content]}))