(ns mbstats-figrum.doo
  (:require [doo.runner :refer-macros [doo-all-tests]]
             [ mbstats-figrum.tests]
            ))

(doo-all-tests #"( mbstats-figrum)\..*-test")
