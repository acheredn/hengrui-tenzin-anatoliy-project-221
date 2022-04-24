import java.util.*;
import java.lang.Math;

public class MazeGenerator{
    private int[][] maze;
    
    public MazeGenerator (int size) {
        maze = new int[size][size];
        generateMaze();
    }

    private void generateMaze () {
        for (int i = 0; i < maze.length; i++) {
            for(int j = 0; j < maze.length; j++) {
                maze [i][j] = (int) Math.floor(Math.random() * 2);
            }
        }
    }

    public void printMaze () {
        for (int i = 0; i < maze.length; i++) {
            for(int j = 0; j < maze.length; j++) {
                System.out.print(maze [i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        MazeGenerator mazeGen = new MazeGenerator(5);
        mazeGen.printMaze();
    }

    public int[][] getMaze() {
        return maze;
    }
    
}