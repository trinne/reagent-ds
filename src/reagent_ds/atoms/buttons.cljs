(ns reagent-ds.atoms.buttons)

(def button-style {:style {:font-size     "1rem"
                           :padding       "0.5rem 1rem"
                           :border        "1px solid rgba(50, 50, 50, .5)"
                           :border-radius "7%"}})
(def primary-style {:style {:backgroundColor "rgb(50, 100, 230)"}})
(def danger-style {:style {:backgroundColor "red"}})

(defn merge-styles [a b]
  {:style (merge (:style a) (:style b))})

(defn button
  ([content]
   (button content nil))
  ([content args]
   (let [styles (merge-styles button-style args)]
     [:button styles content])))

(defn button-primary [content & args]
  (button content primary-style))

(defn button-danger [content & args]
  (button content danger-style))
