(ns reagent-ds.pages.main
  (:require-macros [reagent-ds.macros :refer [$->]])
  (:require [reagent.session :as session]
            [reagent-ds.templates.main :as tpl]
            [reagent-ds.atoms.buttons :as btn]))
(defmulti page-contents identity)

(defmethod page-contents :buttons []
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

(defmethod page-contents :not-found []
  [:div
   [:h1 "This is the content of the Reagent Design System"]
   [:h2 "Page not found :("]])

(defmethod page-contents :index []
  [:div
   [:h1 "This is the content of the Reagent Design System"]])

(defn page [nav]
  [tpl/default {:navigation nav
                :heading "Reagent Design System"
                :main-content (page-contents (:current-page (session/get :route)))}])