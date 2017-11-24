(ns euler-project.problem7
  (:require [clojure.math.numeric-tower :as math]))

;; https://projecteuler.net/problem=7
;;
;;    By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
;;
;;    What is the 10,001st prime number?

(defn any-divide?
  "Given a list of factors in increasing order, returns logical
   true if any of the elements in `factors` divides `product`"
  [factors product]
  (let [sqrt (math/sqrt product)]
    (reduce (fn [_ x]
              (cond
                (< sqrt x) (reduced false)
                (zero? (mod product x)) (reduced true)
                :else nil))
            nil
            factors)))

(defn primes
  "Returns a vector of the first `n` primes in ascending order."
  [n]
  (some
   (fn [primes] (if (= n (count primes)) primes))
   (reductions (fn [primes x]
                 (if-not (any-divide? primes x)
                   (conj primes x)
                   primes))
               [2]
               (drop 3 (range)))))

(defn get-result [] (last (primes 10001)))

(defn -main
  "Runs and prints the solution to problem 7"
  [& args]
  (println (str "The 10,001th prime number is " (get-result) ".")))
