(ns alphabet-cipher.coder)

(defn alph-char [start end]
  (map char (range (int start) (inc (int end)))))

(defn alph-str [char-seq]
  (apply str char-seq))

(def alphabet
  (alph-str (alph-char \a \z)))

(defn alph-shift [alph offset]
  (apply str (concat (drop offset alphabet)
          (take offset alphabet))))

(defn encode [keyword message]
  "encodeme")

(defn decode [keyword message]
  "decodeme")

(defn decipher [cipher message]
  "decypherme")

