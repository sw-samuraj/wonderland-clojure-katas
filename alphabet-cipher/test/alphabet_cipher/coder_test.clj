(ns alphabet-cipher.coder-test
  (:require [clojure.test :refer :all]
            [alphabet-cipher.coder :refer :all]))

(deftest test-alph-char
  (testing "sequence of characters"
    (is (= '(\a \b \c \d)
           (alph-char \a \d)))
    (is (= '(\x \y \z)
           (alph-char \x \z)))))

(deftest test-alph-str
  (testing "string alphabet"
    (is (= "abcd"
           (alph-str (alph-char \a \d))))
    (is (= "xyz"
           (alph-str (alph-char \x \z))))))

(deftest test-alphabet
  (testing "alphabet as a string"
    (is (= "abcdefghijklmnopqrstuvwxyz"
           alphabet))))

(deftest test-alph-shift
  (testing "alphabet shift"
    (is (= "abcdefghijklmnopqrstuvwxyz"
           (alph-shift alphabet 0)))
    (is (= "bcdefghijklmnopqrstuvwxyza"
           (alph-shift alphabet 1)))
    (is (= "cdefghijklmnopqrstuvwxyzab"
           (alph-shift alphabet 2)))
    (is (= "zabcdefghijklmnopqrstuvwxy"
           (alph-shift alphabet 25)))))

(deftest test-encode
  (testing "can encode given a secret keyword"
    (is (= "hmkbxebpxpmyllyrxiiqtoltfgzzv"
           (encode "vigilance" "meetmeontuesdayeveningatseven")))
    (is (= "egsgqwtahuiljgs"
           (encode "scones" "meetmebythetree")))))

(deftest test-decode
  (testing "can decode an cyrpted message given a secret keyword"
    (is (= "meetmeontuesdayeveningatseven"
           (decode "vigilance" "hmkbxebpxpmyllyrxiiqtoltfgzzv")))
    (is (= "meetmebythetree"
           (decode "scones" "egsgqwtahuiljgs")))))

(deftest test-decipher
  (testing "can extract the secret keyword given an encrypted message and the original message"
    (is (= "vigilance"
           (decipher "opkyfipmfmwcvqoklyhxywgeecpvhelzg" "thequickbrownfoxjumpsoveralazydog")))
    (is (= "scones"
           (decipher "hcqxqqtqljmlzhwiivgbsapaiwcenmyu" "packmyboxwithfivedozenliquorjugs")))))
