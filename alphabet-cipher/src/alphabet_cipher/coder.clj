(ns alphabet-cipher.coder)

(defn alph-char [start end]
  (map char (range (int start) (inc (int end)))))

(defn alph-str [char-seq]
  (apply str char-seq))

(defn encode [keyword message]
  "encodeme")

(defn decode [keyword message]
  "decodeme")

(defn decipher [cipher message]
  "decypherme")

