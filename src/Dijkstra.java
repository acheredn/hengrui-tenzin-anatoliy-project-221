import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Dijkstra{
    private int[][] maze;
    private ArrayList<Point> allThePoints;
    private ArrayList<Point> visitedPoints;
    private HashMap<Point, ArrayList<Point>> pointNeighborMap;
    private ArrayList<Point> dijkstraForTheShortestDistance;
    private PriorityQueue<Point> pointsQueue;
    public Dijkstra(int[][] maze){
        this.maze = maze;
        allThePoints = new ArrayList<Point>();
        visitedPoints = new ArrayList<Point>();
        initializeAllThePoints();
    }
    private void initializeAllThePoints(){
        for(int i =0;i<maze[0].length;i++){
            for(int j = 0;j<maze.length;j++){
                allThePoints.add(new Point(j,i,maze[i][j]));
            }
        }
    }
    
    private void initializePointNeighborMap(){
        for(Point point:allThePoints){
            pointNeighborMap.put(point, findNeigborPoints(point));
        }
    }

    private void doDijkstra(){
        //Add the starting point
        visitedPoints.add(allThePoints.get(0));
        pointsQueue.add(allThePoints.get(0));
        while(visitedPoints.size()!=allThePoints.size()){
        }
    }

    /**
     * @param point
     * @return whether this point has neighbors or not
     */
    private boolean find(Point point){
        return false;
    }
    /**
     * 
     * @return whether this point's neighbor
     */
    private ArrayList<Point> findNeigborPoints(Point point){
        ArrayList<Point> newNeighborList = new ArrayList<>();
        while(hasNeighbor(point)){
            newNeighborList.add(e)
        }
        return newNeighborList;
    }
}