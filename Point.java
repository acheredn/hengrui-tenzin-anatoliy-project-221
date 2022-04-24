public class Point {
    private int x;
    private int y;
    private Point previousPoint;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPreviousPoint(Point previousPoint) {
        this.previousPoint = previousPoint;
    }

    public Point getPreviousPoint() {
        return previousPoint;
    }
}
