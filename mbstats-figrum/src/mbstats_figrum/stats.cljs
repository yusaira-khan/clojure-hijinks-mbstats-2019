(ns mbstats-figrum.stats)
(defn- zero[] (atom 0))
(defrecord Stat   [title    letter  label opposite-label value])
(def intro (Stat. "Introvert" "I"   :intro :extro        (zero)))
(def extro (Stat. "Extrovert" "E"   :extro :intro        (zero)))
(def judge (Stat. "Judging"   "J"   :judge :perce        (zero)))
(def perce (Stat. "Perceiving""P"   :perce :judge        (zero)))
(def intui (Stat. "Intuition" "N"   :intui :sense        (zero)))
(def sense (Stat. "Sensing"   "S"   :sense :intui        (zero)))
(def think (Stat. "Thinking"  "T"   :think :feel         (zero)))
(def feel  (Stat. "Feeling"   "F"   :feel  :think        (zero)))
(def allstats {
   :intro intro, :intui intui, :judge judge :think think
   :extro extro, :sense sense, :perce perce :feel  feel
               })

(defn title [label] (:title (allstats label))) 
(defn letter [label] (:letter (allstats label)))
(defn opposite [label] (:opposite-label (allstats label)))
(defn- atval [label] (:value (allstats label)))
(defn change [label value] (reset! (atval label) value ))
(defn retr [label] @(atval label))
