(ns euler-project.problem4-test
  (:require  [clojure.test :as t :refer [deftest is]]
             [euler-project.problem4 :as problem4]))

;; Tests for `palindrome?`

(deftest palendrome-even-length
  (is (true? (problem4/palindrome? "hannah"))))

(deftest non-palendrome-even-length
  (is (not (problem4/palindrome? "lavrne"))))

(deftest palendrome-odd-length
  (is (true? (problem4/palindrome? "hanah"))))

(deftest non-palendrome-odd-length
  (is (not (problem4/palindrome? "lavrne"))))


;; Tests for `result`

(deftest computes-correct-result
  (let [palindrome (problem4/result)]
    (is (= (:factor-1 palindrome) 913))
    (is (= (:factor-2 palindrome) 993))
    (is (= (:product palindrome) 906609))))
