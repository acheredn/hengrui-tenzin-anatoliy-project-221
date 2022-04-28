
import edu.macalester.graphics.*;
import java.awt.Color;

public class Visualizer {

    public Visualizer () {

    }

    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("Maze", 1000, 1000);

        MazeGenerator maze = new MazeGenerator(10);
        for (int i = 0; i < maze.getMaze().length; i++){
            for (int j = 0; j < maze.getMaze()[0].length; j++) {
                if (maze.getMaze()[i][j] == 1){
                    Rectangle pathExist = new Rectangle(i*20, j*20, 20, 20);
                    pathExist.setFillColor(Color.GREEN);
                    canvas.add(pathExist);
                } else {
                    Rectangle pathNotExist = new Rectangle(i*20, j*20, 20, 20);
                    pathNotExist.setFillColor(Color.RED);
                    canvas.add(pathNotExist);
                }
            }
        }
    }
    
    
}
