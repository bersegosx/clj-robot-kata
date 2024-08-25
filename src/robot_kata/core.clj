(ns robot-kata.core)

(def DIRECTIONS-VECTOR {"N" [0 1]
                        "S" [0 -1]
                        "W" [-1 0]
                        "E" [1 0]})
(def DIRECTIONS "NESW")

(defn next-side [current-side point]
  (let [idx (clojure.string/index-of DIRECTIONS current-side)
        length (count DIRECTIONS)
        next-idx (+ point (cond
                            (= [idx point]
                               [0 -1]) length
                            (= [idx point]
                               [(dec length) 1]) -1
                            :else idx))]
    (str (get DIRECTIONS next-idx))))

(defn make-robot
  [x y dir]
  [x y dir])

(defn move-forward
  [[x y dir]]
  (let [[x1 y1] (DIRECTIONS-VECTOR dir)]
    (make-robot (+ x x1) (+ y y1) dir)))

(defn turn-left
  [[x y dir]]
  (make-robot x y (next-side dir -1)))

(defn turn-right
  [[x y dir]]
  (make-robot x y (next-side dir 1)))

(defn get-command
  [cmd]
  (case cmd
    "F" move-forward
    "L" turn-left
    "R" turn-right))

(defn execute-commands
  [robot [cmd-name & rest-cmd]]
  (if (empty? cmd-name)
    robot
    (let [cmd (get-command cmd-name)
          next-robot (cmd robot)]
      (println "Command" cmd-name next-robot)
      (execute-commands next-robot rest-cmd))))

(comment
  (make-robot 0 0 "N")
  (move-forward (make-robot 0 0 "E"))
  
  (next-side "E" -1)
  
  (->
   (make-robot 0 0 "N")
   (move-forward)
   (move-forward)
   (turn-left))
  (->
   (make-robot 0 0 "N")
   (execute-commands (clojure.string/split "FLFFLFFFRRRF" #"")))
  )