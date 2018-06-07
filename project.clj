(defproject reagent-ds "0.0.0.2"
  :description "FIXME: write description"
  :url "https://github.com/trinne/velho-ds"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.9.0"]

                 ;; Filesystem support
                 [me.raynes/fs "1.4.6"]

                 ;; Yaml
                 [io.forward/yaml "1.0.8"]

                 ;; Front end
                 [org.clojure/clojurescript "1.10.238"]
                 [reagent "0.8.0"]
                 [stylefy "1.5.0"]
                 [bidi "2.1.3"]
                 [venantius/accountant "0.2.4"]
                 [reagent-utils "0.3.1"]]

  :plugins [[lein-cljsbuild "1.1.5"]
            [lein-figwheel "0.5.16" :exclusions [org.clojure/clojure]]]

  :source-paths ["src/clj" "src/cljs"]

  :main ^:skip-aot reagent-ds.main

  :min-lein-version "2.5.0"
  :clean-targets ^{:protect false}
[:target-path
 [:cljsbuild :builds :app :compiler :output-dir]
 [:cljsbuild :builds :app :compiler :output-to]]

  :resource-paths ["public"]

  :figwheel {:http-server-root "."
             :nrepl-port 7002
             :nrepl-middleware ["cemerick.piggieback/wrap-cljs-repl"]
             :css-dirs ["public/css"]}

  :cljsbuild {:builds {:app
                       {:source-paths ["src/cljs" "env/dev/cljs"]
                        :compiler
                                      {:main "reagent-ds.dev"
                                       :output-to "public/js/app.js"
                                       :output-dir "public/js/out"
                                       :asset-path "js/out"
                                       :source-map true
                                       :optimizations :none
                                       :pretty-print true}
                        :figwheel
                                      {:on-jsload "reagent-ds.core/mount-root"
                                       :open-urls ["http://localhost:3449/index.html"]}}
                       :release
                       {:source-paths ["src/cljs" "env/prod/cljs"]
                        :compiler
                                      {:output-to "public/js/reagent-ds.js"
                                       :output-dir "public/js/release"
                                       :asset-path "js/out"
                                       :optimizations :advanced
                                       :pretty-print false}}}}

  :aliases {"package" ["do" "clean" ["cljsbuild" "once" "release"]]}

  :profiles {:dev {:dependencies [[binaryage/devtools "0.9.7"]
                                  [figwheel-sidecar "0.5.15"]
                                  [org.clojure/tools.nrepl "0.2.13"]
                                  [com.cemerick/piggieback "0.2.2"]]}})
