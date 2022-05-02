import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Dijkstra{

    private int[][] maze;
    private int mazeWidth;
    private int mazeHeight;
    private ArrayList<Point> allThePoints;
    private ArrayList<Point> allThePointsInTheGraph;
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
            Point p = 
        }
    }

    /**
     * 
     * @return whether this point's neighbor
     */
    private ArrayList<Point> findNeigborPoints(Point point){
        ArrayList<Point> newNeighborList = new ArrayList<>();
        int x = point.getX();
        int y = point.getY();
        if(inBound(x, y-1)&&maze[x][y-1]==1&&!visitedPoints.contains(allThePoints.get(mazeWidth*(y-1)+x))){
            Point foundPoint = allThePoints.get(mazeWidth*(y-1)+x);
            foundPoint.setPreviousPoint(point);
            newNeighborList.add(foundPoint);
        }
        if(inBound(x+1, y)&&maze[x+1][y]==1&&!visitedPoints.contains(allThePoints.get(mazeWidth*(y)+x+1))){       
            Point foundPoint = allThePoints.get(mazeWidth*(y)+x+1);
            foundPoint.setPreviousPoint(point);
            newNeighborList.add(foundPoint);
        }
        if(inBound(x-1, y)&&maze[x-1][y]==1&&!visitedPoints.contains(allThePoints.get(mazeWidth*(y)+x-1))){
            Point foundPoint = allThePoints.get(mazeWidth*(y)+x-1);
            foundPoint.setPreviousPoint(point);
            newNeighborList.add(foundPoint);
        }
        if(inBound(x,y+1)&&maze[x][y+1]==1&&!visitedPoints.contains(allThePoints.get(mazeWidth*(y+1)+x))){
            Point foundPoint = allThePoints.get(mazeWidth*(y+1)+x);
            foundPoint.setPreviousPoint(point);
            newNeighborList.add(foundPoint);
        }
        return newNeighborList;
    }

    private boolean inBound(int x, int y){
        return x>=0 && x < mazeWidth && y>=0 && y <= mazeHeight;
    }

}