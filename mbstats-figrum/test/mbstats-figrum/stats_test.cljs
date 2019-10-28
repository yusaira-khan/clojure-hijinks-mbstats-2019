(ns mbstats-figrum.stats-test
  (:require [cljs.test :refer-macros [is testing]]
            [devcards.core :refer-macros [deftest]]
            [mbstats-figrum.stats :as stats]))

(deftest intro-test
  (testing "Can get intro stat"
    (is (=(stats/getstats :intro) "hi")) ))
