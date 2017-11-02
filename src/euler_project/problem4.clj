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


(defn reverse-range
  "Produces a lazy list containing all the integers from high to low (both inclusive),
   when high is greater than or equal to low."
  [high low]
  (cond
    (< high low) '()
    (= high low) (list low)
    :else (lazy-seq (cons high
                             (reverse-range (dec high) low)))))

(def result
  (for [x (reverse-range 999 100)
        y (reverse-range 999 100)
        :when (palindrome? (str (* x y)))]
    (* x y)))

(def solution (apply max result))
solution
;; => 906609
