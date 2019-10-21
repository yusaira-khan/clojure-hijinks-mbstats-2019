(ns mbstats-figrum.core
    (:require [rum.core :as rum]))

(enable-console-print!)

(println "This text is printed from src/mbstats-figrum/core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

(defonce valuemap {:intro (atom 0), :extro (atom 0)})
(defonce titlemap {:intro "Introvert", :extro "Extrovert"})
(defonce catagorylist [:intro :extro])
(defonce opposites {:intro :extro, :extro :intro})
(defn- change-value [key val] (reset! (valuemap key) val))
(defn- textarea-keydown [callback]
  (fn [e]
    (do
      (js/alert e)
        ;(callback (.. e -target -value))
        ) ) ) 
(rum/defc gimmeBold[]
  [:div.bold @(valuemap :intro)  ]
  )
(defn- introchange[e]
  ((change-value :intro (.. e -target -value))
  (rum/mount (gimmeBold) (. js/document (getElementById "bapp"))))
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
