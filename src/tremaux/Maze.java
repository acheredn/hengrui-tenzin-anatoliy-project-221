// Tremaux Algorithm Implementation

// Inspiration:
// 1) https://github.com/john-science/mazelib/blob/main/docs/MAZE_SOLVE_ALGOS.md
// 2) https://github.com/Ram-Raghav-S/Maze-Solving/tree/main/Maze%20Solving/src
// 3) https://github.com/mozdzyk/Maze
// 4) https://github.com/HirdayGupta/Tremaux-Maze-Solver/tree/master/src/mazeSolverV1

// Logic:
// Every time you visit a cell, mark it once.
// When you hit a dead end, turn around and go back.
// When you hit a junction you haven't visited, pick a new passage at random.
// If you're walking down a new passage and hit a junction you have visited, treat it like a dead end and go back.
// If walking down a passage you have visited before (i.e. marked once) and you hit a junction, take any new passage available, otherwise take an old passage (i.e. marked once).
// When you finally reach the end, follow cells marked exactly once back to the start.
// If the Maze has no solution, you'll find yourself at the start with all cells marked twice.

package tremaux;

import tremaux.Move;

public class Maze {
	private static int[][] maze;
	public static boolean isFinished;
	public Maze(){
		isFinished = false;
		 maze = new int[][]{ {1,0,1,1,0,0,1}
		 					,{1,1,1,1,1,1,1}
		 					,{0,1,0,0,0,1,1}
		 					,{0,1,1,1,0,1,2}}; 
				 	  
	}
	public static boolean checkMove(Move m){
		
		 if(m.getDestPos()[0]>=maze.length || m.getDestPos()[1]>=maze[0].length || m.getDestPos()[0]<0 || m.getDestPos()[1]<0 ){
			return false;
		}
		 else if( maze[m.getDestPos()[0]][m.getDestPos()[1]]==0){
			 return false;
		 }
		else if(maze[m.getDestPos()[0]][m.getDestPos()[1]]==2){
			
			isFinished = true;
			return true;
		}
		else return true;
	}
	
	public static int[][] getMaze(){
		return maze;
	}
	
	public void printMaze(){
		for(int i=0;i<maze.length;i++){
			for(int j=0;j<maze[0].length;j++){
				System.out.print(maze[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Maze maze = new Maze();
		Position p1 = new Position();
		maze.printMaze();
		p1.run();
	}
}