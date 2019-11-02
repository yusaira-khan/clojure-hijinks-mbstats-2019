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


(deftest value-not-change
  (testing "Independent values" 
    (is (= 0 (stats/retr :intro)))
    (is (stats/change :intro 30))
    (is (= 30 (stats/retr :intro)))
    (is (= 70 (stats/retr :extro)))
    (is (= 0 (stats/retr :intui)))
    (is (stats/change :extro 60))
    (is (= 60 (stats/retr :extro)))
    (is (= 40 (stats/retr :intro)))
    (is (stats/reset-all ))
    (is (= 0 (stats/retr :intro)))
    ))
(deftest internal-function-test
  (testing "internal functions. requires private functions to be public"
    (is (= 30 (* 2 3 5)))
    (is (= '(0 0 0 0) (stats/retr-seq stats/entp)))
    (is (= 0 ( reduce *(stats/retr-seq stats/entp))))
    ;(is (re))
    ))
(deftest get-intro-when-greater
  (testing "Getting intro when opposite is greater"
    (is (stats/change :extro 30))
    (is (stats/change :intui 50))
    (is (stats/change :think 10))
    (is (stats/change :perce 40))
    (is (=
         (stats/mb :entp )
           (* 30 50 10 40)
         )
    )
    (is (= (stats/mb :isfj ) (* 70 50 90 60)))
    (is (stats/reset-all ))
    ))
