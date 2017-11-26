(ns euler-project.problem7
  (:require [clojure.math.numeric-tower :as math]))

;; https://projecteuler.net/problem=7
;;
;;    By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
;;    that the 6th prime is 13.
;;
;;    What is the 10,001st prime number?

(defn not-prime?
  "When given a strictly increasing list of all primes less than `product`,
   returns logical true if any of the elements in `factors` divides `product`"
  [factors product]
  (let [sqrt (math/sqrt product)]
    (reduce (fn [_ x]
              (cond
                (< sqrt x) (reduced false)
                (zero? (mod product x)) (reduced true)
                :else nil))
            nil
            factors)))

(defn- lazy-primes-helper
  "When given a strictly increasing list of all primes less than `product`,
   returns a stictly increasing lazy seq containing all primes greater than or
   equal to `product`."
  [primes product]
  (if (not-prime? primes product)
    (recur primes (inc product))
    (lazy-seq (cons product
                    (lazy-primes-helper (conj primes product) (inc product))))))

(defn lazy-primes
  "Returns a strictly increasing lazy sequence containing all primes."
  []
  (lazy-primes-helper [] 2))


;; This solution uses trial division to produce new primes. While the Sieve of
;; Eratosthenes has a better time complexity, my attempt to implement it
;; was a little _slower_ than trial division (for this particular problem, on my
;; particular machine).

(defn get-result [] (nth (lazy-primes) 10000))


(defn -main
  "Runs and prints the solution to problem 7"
  [& args]
  (println (str "The 10,001th prime number is " (get-result) ".")))
