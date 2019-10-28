(ns mbstats-figrum.stats)


(def title {:intro "Introvert"
            :extro "Extrovert"
            :judge "Judging"
            :perce "Perceiving"
            :sense "Sensing"
            :intui "Intuition"
            :think "Thinking"
            :feel "Feeling"} )
(def letter {:intro "I"
             :extro "E"
             :judge "J"
             :perce "P"
             :sense "S"
             :intui "N"
             :think "T"
             :feel "F"})
(def opposite {:intro :extro
               :extro :intro
               :judge :perce
               :perce :judge
               :sense :intui
               :intui :sense
               :feel :think
               :think :feel
               })
(defrecord Stat   [title    letter  label opposite-label value])
(def intro (Stat. "Introvert" "I"   :intro :extro          0))
(def extro (Stat. "Extrovert" "E"   :extro :intro          0))
(def judge (Stat. "Judging"   "J"   :judge :perce          0))
(def perce (Stat. "Perceiving" "P"  :perce :judge          0))
