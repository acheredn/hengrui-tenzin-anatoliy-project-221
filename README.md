# hengrui-tenzin-anatoliy-project-221
Final project for COMP-221-02 Spring 2022. Authors: Hengrui, Tenzin, Anatoliy.


Given a binary rectangular matrix, it finds the shortest path’s length in a maze from a given source to a given destination.

 

 If source = (0, 0) and destination = (7, 5), the shortest path from source to destination has length 12.

 

 [ 1  1  1  1  1  0  0  1  1  1 ]
 
 [ 0  1  1  1  1  1  0  1  0  1 ]
 
 [ 0  0  1  0  1  1  1  0  0  1 ]
 
 [ 1  0  1  1  1  0  1  1  0  1 ]
 
 [ 0  0  0  1  0  0  0  1  0  1 ]
 
 [ 1  0  1  1  1  0  0  1  1  0 ]
 
 [ 0  0  0  0  1  0  0  1  0  1 ]
 
 [ 0  1  1  1  1  1  1  1  0  0 ]
 
 [ 1  1  1  1  1  0  0  1  1  1 ]
 
 [ 0  0  1  0  0  1  1  0  0  1 ]

<img src= "https://github.com/acheredn/hengrui-tenzin-anatoliy-project-221/blob/main/Screen%20Shot%202022-05-02%20at%201.06.05%20AM.png" width=250><br>

<h2>Tremaux Algorithm</h2>

Tremaux algorithm is one of the most efficient ways to solve an unknown maze. We implemented it by splitting the logic into three self-explanatory classes: Maze, Move, Position.

To see the algorithm without visualizing, you should run **“Maze.java”**.  You can also change the structure of the maze in the same class. Make sure to put “2” in the array to indicate the end of the maze. 
