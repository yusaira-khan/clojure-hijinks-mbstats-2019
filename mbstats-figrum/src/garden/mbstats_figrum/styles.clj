(ns mbstats-figrum.styles
  (:require [garden.def :refer [defrule defstyles]]
            [garden.stylesheet :refer [rule]]
            [garden.selectors :refer [defclass selector]]
            ))
(defclass bold)
(defstyles screen
    [[:body
     {:font-family "Helvetica Neue"
      :font-size   "16px"
      :line-height 1.5}]
    [bold {
           :font-weight "bold";
           :font-size "24px"
           }]
    ])

