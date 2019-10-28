(ns mbstats-figrum.stats-test
  (:require [cljs.test :refer-macros [is testing]]
            [devcards.core :refer-macros [deftest]]
            [mbstats-figrum.stats :as stats]))

(deftest title-test
  (testing "Titles"
    (is (= (stats/title :intro) "Introvert"))
    (is (= (stats/title :extro) "Extrovert"))
    (is (= (stats/title :judge) "Judging"))
    (is (= (stats/title :perce) "Perceiving"))
    (is (= (stats/title :sense) "Sensing"))
    (is (= (stats/title :intui) "Intuition"))
    (is (= (stats/title :think) "Thinking"))
    (is (= (stats/title :feel) "Feeling"))
    ))


(deftest letter-test
  (testing "Letters"
    (is (= (stats/letter :intro) "I"))
    (is (= (stats/letter :extro) "E"))
    (is (= (stats/letter :judge) "J"))
    (is (= (stats/letter :perce) "P"))
    (is (= (stats/letter :sense) "S"))
    (is (= (stats/letter :intui) "N"))))


(defn- opposite? [lab1 lab2]
  (and
   (is (= (stats/opposite lab2) lab1))
   (is (= (stats/opposite lab1) lab2))))

(deftest opposite-test
  (testing "Opposites"
    (is (opposite? :intro :extro))
    (is (opposite? :sense :intui))
    (is (opposite? :think :feel))
    (is (opposite? :judge :perce))))

;defn- (val? [label])
;(deftest valueset (is (update :intro 10)))
