(ns cheshire-cat.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [liberator.core :refer :all]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.util.response :refer [response]]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/cheshire-cat" [] 
       (response {:name "Cheshire Cat" :status :grinning}))
  (ANY "/cat" []
       (resource :available-media-types ["text/plain"
                                         "text/html"
                                         "application/json"]
                 :handle-ok
                 #(let [media-type (get-in % [:representation :media-type])]
                    (case media-type
                      "text/plain" "Cat"
                      "text/html" "<html><h2>Cat</h2></html>"
                      "application/json" {:cat true}
                      ))
                 :handle-not-acceptable "No cats Here!"))
  (route/not-found "Not Found"))

(def app
  (-> app-routes
      (wrap-json-response)
      (wrap-defaults site-defaults)))
