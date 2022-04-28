
import edu.macalester.graphics.*;

public class Visualizer {

    public Visualizer () {

    }

    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("test", 200, 200);
        Line a = new Line(0, 0, 112, 112);
        canvas.add(a); 
    }
    
    
}
