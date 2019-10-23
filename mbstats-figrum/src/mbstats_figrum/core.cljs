(ns mbstats-figrum.core
  (:require [rum.core :as rum]
            [cljs.reader :refer [read-string]])) 

(enable-console-print!)

(println "example print")


(defonce valuemap {:intro (atom 0), :extro (atom 0)})
(defonce titlemap {:intro "Introvert", :extro "Extrovert"})
(defonce catagorylist [:intro :extro])
(defonce opposites {:intro :extro, :extro :intro})
(defn- change-value [key val] (reset! (valuemap key)   (read-string val)))
(defn- align-opposite-val [key] (reset! (valuemap (opposites key)) (- 100 @(valuemap key) )))
(defn- textarea-keydown [callback]
  (fn [e]
    (do
      (js/alert e)
        ;(callback (.. e -target -value))
        ) ) ) 
(rum/defc gimmeBold[]
  [:div.bold [:div (titlemap :intro)] [:div @(valuemap :intro)]  [:div (titlemap :extro)] [:div @(valuemap :extro)]  ]
  
  )
(defn- introchange[e]
  ((change-value :intro (.. e -target -value))
   (align-opposite-val :intro)
   (rum/mount (gimmeBold) (. js/document (getElementById "bapp")))
   )
  )
(defn- extrochange[e]
  (js/alert (.. e -target -value))
)

(rum/defc mbprint []
  [:div
   [:h3 "Edit!!!!!!!!!!!!!! this and watch it change!"]
   [:label#intro-lab (titlemap :intro)]
   [:textarea#intro-val {:on-change introchange} @(valuemap :intro)]
   [:label#extro-lab  (titlemap :extro)]
   [:textarea#extro-val {:on-change extrochange}
                        @(valuemap :extro)]
   ])

(rum/mount (mbprint)
           (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
