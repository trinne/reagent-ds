(ns reagent-ds.pages.main
  (:require [reagent-ds.templates.main :as tpl]))

(defn page [nav]
  (tpl/default {:navigation nav
                :heading "Reagent Design System"
                :main-content "This is the content of the Reagent Design System"}))