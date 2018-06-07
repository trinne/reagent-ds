(ns reagent-ds.routes)

;; -------------------------
;; Routes
(def routes
  ["/" {"" :index
        "atoms" {"/buttons" :buttons}
        true :not-found}])