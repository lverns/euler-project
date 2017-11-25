(ns euler-project.problem10
  (:require [euler-project.problem7 :as problem7]))

;; https://projecteuler.net/problem=10
;;
;;    The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
;;
;;    Find the sum of all the primes below two million.


(defn sum-of-primes
  "Returns the sum of primes that are strictly less than `m`"
  [m]
  (reduce +
          (take-while #(< % m)
                      (problem7/lazy-primes))))

(defn result
  []
  (sum-of-primes 2000000))

(defn -main
  "Computes the solution to problem 10 and prints to stdout."
  [& args]
  (println (str "The sum of all primes below 2 million is " (result) ".")))

