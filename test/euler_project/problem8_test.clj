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


;; Tests for `products`

(deftest products__run-of-4
  (let [result-list (problem8/products problem8/thousand-digit-list 4)
        largest (apply max-key :product result-list)]
    (is (every? #(= 4 (count (:factors %))) result-list))
    (is (= (:product largest) 5832))
    (is (= (:factors largest) '(9 9 8 9)))))

(deftest products__run-of-5
  (let [result-list (problem8/products problem8/thousand-digit-list 5)
        largest (apply max-key :product result-list)]
    (is (every? #(= 5 (count (:factors %))) result-list))
    (is (= (:product largest) 40824))))


;; Tests for `result`

(deftest result__correct
  (is {:product (problem8/result)} 23514624000))
