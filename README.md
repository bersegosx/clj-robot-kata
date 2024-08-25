# Robot Kata

> from https://www.playfulpython.com/become-better-at-programming/

Here is the problem statement:

* Imagine a robot that is at position (0, 0) and facing North.
* It can take 3 commands: Move forward, turn left or turn right.
* Turning left or right changes the orientation of the robot by 90 degrees without changing the position. For example, turn left will make the robot remain at (0, 0) but it will face West now
* Moving forward will move the robot 1 step in the direction faced, so if it is at (0, 0) and facing West, after moving forwards it will be at (-1, 0) and still facing West

Given a sequence of commands (eg: FLFFLFFFRRRF) then calculate the final position and orientation of the robot.