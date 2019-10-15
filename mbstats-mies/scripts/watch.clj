(require '[cljs.build.api :as b])

(b/watch "src"
  {:main 'mbstats-mies.core
   :output-to "out/mbstats_mies.js"
   :output-dir "out"})
