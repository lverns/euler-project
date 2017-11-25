(ns euler-project.problem10-test
  (:require [euler-project.problem10 :as problem10]
            [clojure.test :as t :refer [deftest is]]))

;; Tests for `sum-of-primes`

(deftest sum-of-primes__below-10
  (is (= (problem10/sum-of-primes 10) 17)))


;; Test for `result`

(deftest result__correct
  (is (= (problem10/result) 142913828922)))

