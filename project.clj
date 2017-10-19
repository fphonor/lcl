(defproject cheshire-cat "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]

                 [com.cognitect/transit-clj "0.8.300"]
                 [com.cognitect/transit-cljs "0.8.243"]

                 [compojure "1.5.1"]
                 [ring/ring-defaults "0.2.1"]
                 [ring/ring-json "0.4.0"]
                 [org.clojure/clojurescript "1.9.946"]
                 [cljs-http "0.1.43"]
                 [org.clojure/core.async "0.3.443"]
                 [enfocus "2.1.1"]
                 [hiccup "1.0.5"]
                 [enlive "1.1.6"]
                 [liberator "0.15.1"]]
  :plugins [[lein-ring "0.9.7"]
            [lein-cljsbuild "1.1.7"]]
  :ring {:handler cheshire-cat.handler/app}
  :cljsbuild {:builds [{
                       :source-paths ["src-cljs"]
                       :compiler {
                                  :output-to "resources/public/main.js"
                                  :optimizations :whitespace
                                  :pretty-print true}}]}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
