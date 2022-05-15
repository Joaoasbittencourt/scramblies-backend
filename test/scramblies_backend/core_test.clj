(ns scramblies-backend.core-test
  (:require [clojure.test :refer :all]
            [scramblies-backend.core :refer :all]
            [scramblies-backend.scramble :refer :all]))

(deftest test-scramble
  (testing "scramble? should be able to compare 2 strings"
    (is (= (scramble? "rekqodlw" "world") true))
    (is (= (scramble? "cedewaraaossoqqyt" "codewars") true))
    (is (= (scramble? "katas"  "steak") false))
    (is (= (scramble? "stea"  "steak") false))
    (is (= (scramble? ""  "") true))
    (is (= (scramble? ""  "a") false))
    (is (= (scramble? "aa"  "a") true))
    (is (= (scramble? "e"  "e") true))))
