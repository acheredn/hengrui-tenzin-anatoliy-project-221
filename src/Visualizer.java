
import edu.macalester.graphics.*;
import java.awt.Color;
import java.util.*;

public class Visualizer {

    public Visualizer () {

    }

    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("Maze", 500, 500);
        Rectangle[][] visualMaze = new Rectangle[10][10];
        int[][] maze = {
                         {1,0,1,1,0,0,1,0,0,0}
                        ,{1,1,1,1,1,1,1,1,1,1}
                        ,{0,1,0,0,0,0,1,0,0,0}
                        ,{0,1,1,1,0,0,1,0,1,0}
                        ,{1,1,0,1,0,1,1,0,1,1}
                        ,{1,0,0,1,0,0,0,1,1,0}
                        ,{1,1,1,1,1,1,1,1,0,0}
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

        canvas.pause(10000);
        canvas.removeAll();

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
        

    }
    
    
}
