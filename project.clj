(defproject euler-project "0.1.0-SNAPSHOT"
  :description "A project for holding solutions to some Euler Project problems"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/math.numeric-tower "0.0.4"]]
  :profiles {:problem4 {:main euler-project.problem4}
             :problem7 {:main euler-project.problem7}
             :problem8 {:main euler-project.problem8}}
  :aliases {"problem4" ["with-profile" "problem4" "run"]
            "problem7" ["with-profile" "problem7" "run"]
            "problem8" ["with-profile" "problem8" "run"]})
