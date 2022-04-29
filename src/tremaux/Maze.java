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