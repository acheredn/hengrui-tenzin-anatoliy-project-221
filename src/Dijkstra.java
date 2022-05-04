import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Dijkstra{

    private int[][] maze;
    private int mazeWidth;
    private int mazeHeight;
    private int numberOfOnes;
    private ArrayList<Point> allThePoints;
    private ArrayList<Point> visitedPoints;
    private PriorityQueue<Point> pointsQueue;
    private ArrayList<Point> dijkstraForTheShortestDistance;
    private HashMap<Point, ArrayList<Point>> pointNeighborMap;


    public Dijkstra(int[][] maze){
        this.maze = maze;
        mazeHeight = maze.length;
        mazeWidth = maze[0].length;
        allThePoints = new ArrayList<Point>();
        visitedPoints = new ArrayList<Point>();
        pointNeighborMap = new HashMap<>();
        pointsQueue = new PriorityQueue<Point>();
        dijkstraForTheShortestDistance = new ArrayList<>();
        numberOfOnes = 0;
        for(int i = 0; i<mazeWidth;i++){
            for(int j = 0;j<mazeHeight;j++){
                if(maze[i][j]==1){
                    numberOfOnes++;
                }
            }
        }
        initializeAllThePoints();
        initializePointNeighborMap();
        doDijkstra();
        backTracking();
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
            pointNeighborMap.put(point, findNeighborPoints(point));
        }

    }
    
    private void doDijkstra(){
        //Add the starting point
        pointsQueue.add(allThePoints.get(0));
        while(visitedPoints.size()!=numberOfOnes){
            Point p = pointsQueue.poll();
            while(visitedPoints.contains(p)){
                p = pointsQueue.poll();
            }
            visitedPoints.add(p);
            if(p!=null){
            ArrayList<Point> neighboList = findNeighborPoints(p);
            for(Point point:neighboList){
                if(!visitedPoints.contains(point)){
                    point.setPreviousPoint(p);
                    point.setValue(1+p.getValue());
                    pointsQueue.add(point);
                }
            }
            
            }
        }
    }

    /**
     * 
     * @return whether this point's neighbor
     */
    private ArrayList<Point> findNeighborPoints(Point point){
        ArrayList<Point> newNeighborList = new ArrayList<>();
        int x = point.getX();
        int y = point.getY();
        if(point.getValue()!=0){
            if(inBound(x, y-1)&&maze[y-1][x]==1){
                Point foundPoint = allThePoints.get(mazeWidth*(y-1)+x);
                newNeighborList.add(foundPoint);
            }
            if(inBound(x+1, y)&&maze[y][x+1]==1){       
                Point foundPoint = allThePoints.get(mazeWidth*(y)+x+1);
                newNeighborList.add(foundPoint);
            }
            if(inBound(x-1, y)&&maze[y][x-1]==1){
                Point foundPoint = allThePoints.get(mazeWidth*(y)+x-1);
                newNeighborList.add(foundPoint);
            }
            if(inBound(x,y+1)&&maze[y+1][x]==1){
                Point foundPoint = allThePoints.get(mazeWidth*(y+1)+x);
                newNeighborList.add(foundPoint);
            }
        }
        return newNeighborList;
    }
    private void backTracking(){
        Point p = visitedPoints.get(visitedPoints.size()-1);
        getDijkstraForTheShortestDistance().add(p);
        while(p.getPreviousPoint()!= null){
            p = p.getPreviousPoint();
            getDijkstraForTheShortestDistance().add(p);
        }
    }
    public ArrayList<Point> getDijkstraForTheShortestDistance() {
        return dijkstraForTheShortestDistance;
    }

    private boolean inBound(int x, int y){
        return x>=0 && x < mazeWidth && y>=0 && y < mazeHeight;
    }
    
    public static void main(String[] args) {
        int[][] maze = //m1.getHardCodedMaze();
    {
        {1,0,0,1},
        {1,1,1,1},
        {1,0,1,0},
        {1,0,1,1},
    } ;
        Dijkstra d = new Dijkstra(maze);
        
        d.getDijkstraForTheShortestDistance();
    }
}