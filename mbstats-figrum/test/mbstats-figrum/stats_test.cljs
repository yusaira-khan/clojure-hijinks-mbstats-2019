(ns mbstats-figrum.stats-test
  (:require [cljs.test :refer-macros [is testing]]
            [devcards.core :refer-macros [deftest]]
            [mbstats-figrum.stats :as stats]))

(deftest title-test
  (testing "Titles"
    (is (= (stats/title :intro) "Introvert"))
    (is (= (stats/title :extro) "Extrovert"))))
