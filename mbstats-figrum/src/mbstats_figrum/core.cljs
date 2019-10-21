(ns mbstats-figrum.core
    (:require [rum.core :as rum]))

(enable-console-print!)

(println "This text is printed from src/mbstats-figrum/core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

(defonce valuemap {:intro (atom 0), :extro (atom 0)})
(defonce titlemap {:intro "Introvert", :extro "Extrovert"})
(defonce catagorylist [:intro :extro])
(defn- textarea-keydown [callback]
  (fn [e]
    (do
      (js/alert e)
        ;(callback (.. e -target -value))
        ) ) ) 
(rum/defc gimmeBold[]
  [:div ]
  )
(rum/defc mbprint []
  [:div
   [:h3 "Edit!!!!!!!!!!!!!! this and watch it change!"]
   [:label#intro-lab "Introvert"]
   [:textarea#intro-val {:on-change (fn [e]
                                      (js/alert (.. e -target -value)))} "woo"]
   ])

(rum/mount (mbprint)
           (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
