(ns ^:figwheel-no-load reagent-ds.dev
  (:require
    [reagent-ds.core :as core]
    [devtools.core :as devtools]))


(enable-console-print!)

(devtools/install!)

(core/init!)
