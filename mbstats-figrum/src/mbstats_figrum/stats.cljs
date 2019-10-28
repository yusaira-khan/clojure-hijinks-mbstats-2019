(ns mbstats-figrum.stats)

(deftype Stat   [title    letter  label opposite-label value])
(def intro (Stat. "Introvert" "I"   :intro :extro          0))
(def extro (Stat. "Extrovert" "E"   :extro :intro          0))
(def judge (Stat. "Judging"   "J"   :judge :perce          0))
(def perce (Stat. "Perceiving""P"   :perce :judge          0))
(def intui (Stat. "Intuition" "N"   :intui :sense          0))
(def sense (Stat. "Sensing"   "S"   :sense :intui          0))
(def think (Stat. "Thinking"  "T"   :think :feel           0))
(def feel  (Stat. "Feeling"   "F"   :feel  :think          0))
(def allstats {
   :intro intro, :intui intui, :judge judge :think think
   :extro extro, :sense sense, :perce perce :feel  feel
               })

(defn title [label] (:title (allstats label))) 
(defn letter [label] (:letter (allstats label)))
(defn opposite [label] (:opposite-label (allstats label)))
