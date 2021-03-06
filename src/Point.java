
public class Point implements Comparable<Point>{
    private int x;
    private int y;
    private int value;
    private Point previousPoint;

    public Point(int x, int y,int value){
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValue() {
        return value;
    }
    
    public void setPreviousPoint(Point previousPoint) {
        this.previousPoint = previousPoint;
    }

    public Point getPreviousPoint() {
        return previousPoint;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    @Override
    public int compareTo(Point o) {
        return this.getValue()-o.getValue();
    }
}
