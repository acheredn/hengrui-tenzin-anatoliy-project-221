# hengrui-tenzin-anatoliy-project-221
Final project for COMP-221-02 Spring 2022. Authors: Hengrui, Tenzin, Anatoliy.

Given a binary rectangular matrix, it finds the path in a maze from a given source to a given destination.

 If source = (0, 0) and destination = (9, 9)

<img src= "https://github.com/acheredn/hengrui-tenzin-anatoliy-project-221/blob/main/Screen%20Shot%202022-05-02%20at%201.06.05%20AM.png" width=250><br>

<h2> How to run the program </h2>
Visualizer can be run by the main class of Visualizer.java. However, there may be issues with gradle although we generally did not have an issue.

DFS can be run with DFS.java, and Djikstras can be run with Djikstras.java. 

<h3> Djikstras </h3>

<h3> DFS </h3>
 * Create an (empty) worklist arraylist of squares.
 
 * Add the start square to the worklist. (Hint: maze.getStart() will return the Start square)
 
 * Then apply the following repeatedly
 
 * Is the worklist empty? If so, the exit is unreachable; terminate the algorithm by returning null (the maze is not solvable).
 
 * Otherwise, grab the "next" location to explore from the worklist. 
 
 * Does the square correspond to the exit square? If so, the finish was reachable; terminate the algorithm (found a solution!).
 
 * Otherwise, it is a reachable non-finish location that we haven't explored yet. So, explore it as follows:
 compute all the adjacent up, right, down, left locations that are inside the maze and aren't walls, and
 add them to the worklist for later exploration provided they have not previously been added to the worklist.
 
 * Also, record the fact that you've explored this location so you won't ever have to explore it again. Note that a location is considered "explored" once its neighbors have been put on the worklist. The neighbors themselves are not "explored" until they are removed from the worklist and checked for their neighbors.

<img src= "https://github.com/acheredn/hengrui-tenzin-anatoliy-project-221/blob/main/DFS.png" width=250><br>

<h3>Tremaux Algorithm</h3>

Tremaux algorithm is one of the most efficient ways to solve an unknown maze. We implemented it by splitting the logic into three self-explanatory classes: Maze, Move, Position. The main idea behind the algorithm is that it arbitrarily chooses path at junction, and marks the path points until found the solution, if there is one. According to our calculations, the time complexity of the algorithm is O(n).

To see the algorithm without visualizing, you should run **“Maze.java”**.  You can also change the structure of the maze in the same class. Make sure to put “2” in the array to indicate the end of the maze. You should run ***"Visualizer.java"*** to see it visualuzed with other algorithms we explored.

<img src= "https://github.com/acheredn/hengrui-tenzin-anatoliy-project-221/blob/main/Tremaux.png" width=250><br>

<h3> Presentation urls </h3>
Presentation
https://docs.google.com/presentation/d/1oPeGUCYF-pclySY9wsxppyEmUSsWIFw8Btk41j4qTA8/edit?usp=sharing

Jamboard for Djikstras path
https://jamboard.google.com/d/1eZ8n0q6BbHvvWsB0yxSfcf2nnWS6RLx4xwEzX3GzQ-I/edit?usp=sharing
