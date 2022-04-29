
import edu.macalester.graphics.*;
import java.awt.Color;

public class Visualizer {

    public Visualizer () {

    }

    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("Maze", 500, 500);

        MazeGenerator maze = new MazeGenerator(10);
        for (int i = 0; i < maze.getMaze().length; i++){
            for (int j = 0; j < maze.getMaze()[0].length; j++) {
                if (maze.getMaze()[i][j] == 1){
                    Rectangle pathExist = new Rectangle(i*40, j*40, 40, 40);
                    pathExist.setFillColor(Color.GREEN);
                    canvas.add(pathExist);
                } else {
                    Rectangle pathNotExist = new Rectangle(i*40, j*40, 40, 40);
                    pathNotExist.setFillColor(Color.RED);
                    canvas.add(pathNotExist);
                }
            }
        }
    }
    
    
}
