(ns euler-project.problem4)

;; https://projecteuler.net/problem=4
;;
;;    A palindromic number reads the same both ways. The largest palindrome made from
;;    the product of two 2-digit numbers is 9009 = 91 × 99.
;;
;;    Find the largest palindrome made from the product of two 3-digit numbers.
;;
;; "3-digit number" is not defined explicitly here, so I'll assume that it means
;; any integer in the range [100,999].

(defn palindrome? [s]
  (= s (apply str (reverse s))))

(def all-palindromes
  (for [x (range 100 999)
        y (range 100 999)
        :when (palindrome? (str (* x y)))]
    (* x y)))

(defn -main [& args]
  (println (apply max all-palindromes)))
