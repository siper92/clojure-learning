(ns clojure-learning.odd-even-chars)

(defn separate-even-and-odd-chars
  [word]
  (loop [i 0 wordLenght (count word) parts {:odd "" :even ""}]
    (let [type (if (not (odd? i))
                 :odd
                 :even)]
      (if (> i (count word))
        parts
        (recur (+ i 1) wordLenght (assoc parts type (str (get parts type) (get word i))))))))

(defn -main [& args]
  ; (let lines (line-seq (java.io.BufferedReader. *in*)))
  (let [N (let lines (line-seq (java.io.BufferedReader. *in*))) words (rest N)]
    (doseq [word words]
      (let [wordLenght (count word)]
        (let [wordParts (separate-even-and-odd-chars word)]
          (println (format "%s %s" (get wordParts :odd) (get wordParts :even))))))))
