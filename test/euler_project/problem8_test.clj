(ns euler-project.problem8-test
  (:require [euler-project.problem8 :as problem8]
            [clojure.test :as t :refer [deftest is are]]))

;; Tests for `char-to-int`

(deftest char-to-int__single-digits
  (are [input expected-out] (= (problem8/char-to-int input) expected-out)
    \0 0
    \1 1
    \2 2
    \3 3
    \4 4
    \5 5
    \6 6
    \7 7
    \8 8
    \9 9))


;; Tests for `result`

(deftest result-correct
  (is {:product (problem8/result)} 23514624000))
