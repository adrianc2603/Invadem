# Invadem
## By Adrian Currington 

### Background Information 
The original Invadem project was given as an assignment for my first-year Object-Oriented Programming course, INFO1113. However, in my second-year Software Construction and Design course, SOFT2201, I learnt of the many design patterns applied to real-world programming problems. This inspired me to refactor the orignial Invadem project into suitable design patterns.  

### Game Description 
Invadem is based on the famous Space Invaders game. The player will control a tank and shoot bullets at the enemies that appear on screen. The invaders will slowly move down the screen, and the game will be lost if they reach the barriers protecting the tank. In the first level, a random invader will shoot a bullet every 5 seconds. The time between invaders shooting decreases as each level passes, until they are shooting bullets every 1 second.

There are 4 rows of invaders. The bottom 2 rows are regular invaders, which shoot regular bullets that take 3 shots to completely destroy the tank and barriers. The second row from the top are power invaders, which shoot power bullets that destroy the tank and barriers in 1 shot. These 3 rows of invaders can be destroyed by tank bullets in one shot. The top row of invaders are armoured invaders. These shoot regular bullets, but require 3 tank bullets to shoot them for them to be completely destroyed.

### Controls
MOVE LEFT: Left Arrow Key

MOVE RIGHT: Right Arrow Key

SHOOT BULLET: Spacebar

PAUSE/UNPAUSE: P

QUIT: Q

DISPLAY CONTROLS: C

START/RESUME GAME: G

### Play on Your Machine 
Make sure your machine is running Java 8 (I used Java 8.0.265-zulu) and Gradle (I used Gradle 6.6). Then run into the command line 'gradle build' followed by 'gradle run'.

1. [Install Gradle](https://gradle.org/install/)

2. Build the game:

        gradle build
            
3. Run the game:

        gradle run            

### Acknowledgements 
I acknowledge that all images used for each Component was supplied by the INFO1113 Semester 2, 2019 staff, and are not created by me.
