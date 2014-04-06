(ns crab.core
  (:gen-class)
  (import (javax.swing JFrame JLabel ImageIcon)))

(defn createwin
  []
  (let [win (JFrame. "CRAB")]
    ;(.setSize win 200 200)
    (.add win (JLabel. (ImageIcon. "resources/crab.jpg")))
    (.pack win)
    (.show win)))

(defn -main
  "do you even crab?"
  [& args]
  (println "so unexpected")
  (createwin))
