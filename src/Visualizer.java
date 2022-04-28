
import edu.macalester.graphics.*;
import java.awt.Color;

public class Visualizer {

    public Visualizer () {

    }

    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("test", 1000, 1000);
        Rectangle pathExist = new Rectangle(10, 10, 100, 100);
        pathExist.setFillColor(Color.BLACK);
        canvas.add(pathExist);
    }
    
    
}
