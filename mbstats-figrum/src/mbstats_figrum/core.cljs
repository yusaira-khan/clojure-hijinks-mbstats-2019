(ns mbstats-figrum.core
  (:require [rum.core :as rum]
            [cljs.reader :refer [read-string]])) 

(enable-console-print!)

(println "example print")


(defonce valuemap {:intro (atom 0), :extro (atom 0)})
(defonce titlemap {:intro "Introvert", :extro "Extrovert"})
(defonce catagorylist [:intro :extro])
(defonce opposites {:intro :extro, :extro :intro})
(defn- change-value [key val] (reset! (valuemap key) (+ (read-string val) 1)))
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
(defn- label-component-tag [label] (keyword (concat "label#" label "-lab"))) ;:label#intro-lab
(defn- label-component-val [label] ( (titlemap label :intro))) ;:label#intro-lab
(rum/defc label-component [label] [(label-component-tag label) (label-component-val label)])
(defn- writeable-component-tag [label] (keyword (concat "textarea#" label "-val"))) ;:textarea#intro-val
(defn- writeable-component-attr [label] ({:on-change (symbol (concat label "change"))})) ;{onchange introchange}
(defn- writable-component-value [label] (@valuemap (keyword label)))
(rum/defc writable-component [label] [(writeable-component-tag label) (writeable-component-attr label)( writable-component-value label)])

(rum/defc gencomps[label]
  [label-component writable-component])
(rum/defc mbprint [](concat 
  [:div
   [:h3 "Edit!!!!!!!!!!!!!! this and watch it change!"]]
  (gencomps "intro")
  (gencomps "extro")
   )
   )

(rum/mount (mbprint)
           (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
