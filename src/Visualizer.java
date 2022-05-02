
import edu.macalester.graphics.*;

import java.awt.Color;
import java.util.*;

public class Visualizer {

    public Visualizer () {

    }

    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("Maze", 1000, 1000);
        Rectangle[][] visualMaze = new Rectangle[10][10];
        int[][] maze = {
                         {1,0,1,0,0,0,1,0,0,0}
                        ,{1,1,1,1,1,1,1,1,1,1}
                        ,{0,0,0,0,0,1,0,1,0,0}
                        ,{0,1,1,1,1,1,1,1,1,0}
                        ,{1,1,0,1,0,0,0,0,1,1}
                        ,{1,0,0,1,0,0,0,0,1,0}
                        ,{1,1,1,1,1,1,1,1,1,0}
                        ,{0,1,0,0,1,0,0,0,0,0}
                        ,{0,1,1,1,1,0,0,0,0,0}
                        ,{0,0,0,0,1,1,1,1,1,1}}; 

        for (int i = 0; i < maze.length; i++){
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 1){
                    Rectangle pathExist = new Rectangle(j*40, i*40, 40, 40);
                    pathExist.setFillColor(Color.GREEN);
                    canvas.add(pathExist);
                    visualMaze[i][j] = pathExist;
                } else {
                    Rectangle pathNotExist = new Rectangle(j*40, i*40, 40, 40);
                    pathNotExist.setFillColor(Color.RED);
                    canvas.add(pathNotExist);
                    visualMaze[i][j] = pathNotExist;
                }
            }
        }
        canvas.draw();
        canvas.pause(1000);


        DFS dfs = new DFS(maze);
        dfs.addToAllThePoints();
        ArrayList<Point> path = dfs.getAnswerList();
        System.out.println(path.size());
        for(Point point:path){
            visualMaze[point.getX()][point.getY()].setFillColor(Color.BLUE);
        }

        System.out.println("visual maze 1" + visualMaze[0][0].getHeight());
        for (int i = 0; i < visualMaze.length; i++){
            for (int j = 0; j < visualMaze[0].length; j++) {
                canvas.add(visualMaze[i][j]);
            }
        }


        //Tremaux Visualizer
        Maze mTwo = new Maze();
        int[][] mazeTwo = mTwo.getMaze();
        Rectangle[][] visualMazeTwo = new Rectangle[10][10];

        for (int i = 0; i < maze.length; i++){
            for (int j = 0; j < maze[0].length; j++) {
                if (mazeTwo[i][j] == 1){
                    Rectangle pathExist = new Rectangle(500 + j*40, i*40, 40, 40);
                    pathExist.setFillColor(Color.GREEN);
                    canvas.add(pathExist);
                    visualMazeTwo[i][j] = pathExist;
                } else {
                    Rectangle pathNotExist = new Rectangle(500 + j*40, i*40, 40, 40);
                    pathNotExist.setFillColor(Color.RED);
                    canvas.add(pathNotExist);
                    visualMazeTwo[i][j] = pathNotExist;
                }
            }
        }
        canvas.draw();
        canvas.pause(1000);

        Position p = new Position();
        p.run();
        ArrayList<Point> pathTwo = p.getResultPoint();
        System.out.println(pathTwo);
        System.out.println(pathTwo.size());
        for(Point point:pathTwo){
            visualMazeTwo[point.getX()][point.getY()].setFillColor(Color.BLUE);
        }

        for (int i = 0; i < visualMazeTwo.length; i++){
            for (int j = 0; j < visualMazeTwo[0].length; j++) {
                canvas.add(visualMazeTwo[i][j]);
            }
        }

        

    }
    
    
}
