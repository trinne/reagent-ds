(ns reagent-ds.prod
  (:require
    [reagent-ds.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
