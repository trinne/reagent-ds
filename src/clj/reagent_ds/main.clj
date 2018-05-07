(ns reagent-ds.main
  (:gen-class)
  (:require [reagent-ds.token-loader :as tl]))

(defn -main [& args]
  (tl/create-tokens-from-path "resources/tokens"))