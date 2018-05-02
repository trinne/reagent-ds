(ns reagent-ds.main
  (:gen-class)
  (:require [reagent-ds.token-loader :as tl]))

(defn -main [& args]
  (println (tl/create-tokens {:name "color"
                            :suffix "yml"})))