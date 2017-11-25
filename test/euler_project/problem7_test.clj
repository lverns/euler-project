(ns euler-project.problem7-test
  (:require [euler-project.problem7 :as problem7]
            [clojure.test :as t :refer [deftest is are]]))

;; Tests for `not-prime?`

(deftest not-prime?__false-when-empty
  (is (not (problem7/not-prime? [] 2))))

(deftest not-prime?__false-when-not-contains-divisors
  (is (not (problem7/not-prime? [2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59
                                 61 67 71 73]
                                79))))

(deftest not-prime?__true-when-contains-divisors
  (is (true? (problem7/not-prime? [2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53
                                   59 61 67 71 73]
                                  74))))


;; Tests for `lazy-primes`

(deftest lazy-primes__first-three
  (is (= (take 3 (problem7/lazy-primes)) '(2 3 5))))

(deftest lazy-primes__sixth-correct
  (is (= (nth (problem7/lazy-primes) 5) 13)))


;; Tests for `get-results`

(deftest solution-computed-correctly
  (is (= (problem7/get-result) 104743)))
