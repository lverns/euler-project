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

(defn palindrome?
  "Returns true iff passed a string that is a palindrome."
  [s]
  (= s (apply str (reverse s))))

(def all-palindromes
  (for [x (range 100 1000)
        y (range x 1000)
        :when (palindrome? (str (* x y)))]
    {:factor-1 x
     :factor-2 y
     :product (* x y)}))

(defn result
  "Returns a map describing the solution to problem 4"
  []
  (apply max-key :product all-palindromes))

(defn -main
  "Finds the solution to problem 4 and prints to stdout."
  [& args]
  (let [largest-palindrome (result)]
    (println
     (str "The largest palindrome formed by the multiplication of two 3-digit "
          "numbers is " (:product largest-palindrome) " and is the product of "
          (:factor-1 largest-palindrome) " and " (:factor-2 largest-palindrome) "."))))
