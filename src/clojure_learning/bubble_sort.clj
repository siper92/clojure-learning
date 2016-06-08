(ns clojure-learning.bubble-sort)

(defn- bubble [values_map x]
  (let [values (get values_map :values)
        swaps (get values_map :swaps)]
    (if-let [last_value (peek values)]
      (if (> last_value x)
        {:swaps (+ swaps 1) :values (conj (pop values) x last_value)}
        {:swaps swaps :values (conj values x)})
      {:swaps swaps :values [x]})))

(defn bubble-sort [sort_data]
  (let [has_values (contains? sort_data :values)
        values_to_sort (if has_values
                         (get sort_data :values)
                         sort_data)
        swaps (if has_values
                (get sort_data :swaps)
                0)
        sorted_data (reduce bubble {:swaps swaps :values []} values_to_sort)
        values (get sorted_data :values)]
    (if (= values_to_sort values)
      sort_data
      (recur sorted_data))))

(defn -main
  []
  (let [result (bubble-sort [3 2 1]) swaps (get result :swaps) values (get result :values)]
    (do
      (println (format "Array is sorted in %d swaps." swaps))
      (println (format "First Element: %d" (first values)))
      (println (format "Last Element: %d" (peek values))))))