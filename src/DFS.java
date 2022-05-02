// DFS Algorithm
// Create an (empty) worklist arraylist of squares.
// Add the start square to the worklist. (Hint: maze.getStart() will return the Start square)
// Then apply the following repeatedly
// Is the worklist empty? If so, the exit is unreachable; terminate the algorithm by returning null (the maze is not solvable).
// Otherwise, grab the "next" location to explore from the worklist. 
// Does the square correspond to the exit square? If so, the finish was reachable; terminate the algorithm (found a solution!).
// Otherwise, it is a reachable non-finish location that we haven't explored yet. So, explore it as follows:
// compute all the adjacent up, right, down, left locations that are inside the maze and aren't walls, and
// add them to the worklist for later exploration provided they have not previously been added to the worklist.
// Also, record the fact that you've explored this location so you won't ever have to explore it again. Note that a location is considered "explored" once its neighbors have been put on the worklist. The neighbors themselves are not "explored" until they are removed from the worklist and checked for their neighbors.


import java.util.ArrayList;

public class DFS {
    private int[][] maze;
    private int mazeWidth;
    private int mazeHeight;
    private ArrayList<Point> visitedPoints;
    private ArrayList<Point> allThePoints;
    private ArrayList<Point> answerList;

    public DFS(int[][] maze){
        this.maze = maze;
        this.mazeHeight = maze[0].length;
        this.mazeWidth = maze.length;
        visitedPoints = new ArrayList<>();
        allThePoints = new ArrayList<>();
    }
    void addToAllThePoints(){
        for (int i=0; i<maze[0].length;i++) {
            for(int j=0; j<maze.length;j++){
                allThePoints.add(new Point(j, i, maze[j][i]));
            }
            
        }
    }
    public ArrayList<Point> getAnswerList(){
        Point curPoint = allThePoints.get(0);
        curPoint.setPreviousPoint(null);
        //while curPoint is not at the end location
        while(curPoint!=allThePoints.get(allThePoints.size()-1)){
            if(!visitedPoints.contains(curPoint)){
                visitedPoints.add(curPoint);
            }
            //If curPoint does not equal to itself when trying to find neighbors
            //Aka when curPoint has no neighbors that have not been visited
            if(!curPoint.equals(findNeighbor(curPoint))){
                curPoint = findNeighbor(curPoint);
            }
            //Else if it has no neighbors and the previous point does not equal to null
            else if(curPoint.equals(findNeighbor(curPoint))&&curPoint.getPreviousPoint()!=null){
                curPoint = curPoint.getPreviousPoint();
            }
            //It might has neighbor but it has no previous point
            else{
            }
        }
        visitedPoints.add(curPoint);
        return visitedPoints;
    };

    //Trying to see if there are neighbors around the current point that is 1 and has not been visited
    private Point findNeighbor(Point previousPoint){
        int x = previousPoint.getX();
        int y = previousPoint.getY();
        if(inBound(x, y-1)&&maze[x][y-1]==1&&!visitedPoints.contains(allThePoints.get(mazeWidth*(y-1)+x))){
            Point foundPoint = allThePoints.get(mazeWidth*(y-1)+x);
            foundPoint.setPreviousPoint(previousPoint);
            return foundPoint;
        }
        else if(inBound(x+1, y)&&maze[x+1][y]==1&&!visitedPoints.contains(allThePoints.get(mazeWidth*(y)+x+1))){       
            Point foundPoint = allThePoints.get(mazeWidth*(y)+x+1);
            foundPoint.setPreviousPoint(previousPoint);
            return foundPoint;
        }
        else if(inBound(x-1, y)&&maze[x-1][y]==1&&!visitedPoints.contains(allThePoints.get(mazeWidth*(y)+x-1))){
            Point foundPoint = allThePoints.get(mazeWidth*(y)+x-1);
            foundPoint.setPreviousPoint(previousPoint);
            return foundPoint;
        }
        else if(inBound(x,y+1)&&maze[x][y+1]==1&&!visitedPoints.contains(allThePoints.get(mazeWidth*(y+1)+x))){
            Point foundPoint = allThePoints.get(mazeWidth*(y+1)+x);
            foundPoint.setPreviousPoint(previousPoint);
            return foundPoint;
        }
        return previousPoint;
    }
    
    private boolean inBound(int x, int y){
        return x>=0 && x < mazeWidth && y>=0 && y <= mazeHeight;
    }
    
    public static void main(String[] args) {
    //MazeGenerator m1 = new MazeGenerator(10);
    
    
    // maze coded in y,x format
    int[][] maze = //m1.getHardCodedMaze();
    {
        {1,0,1,1,0,0,1,0,0,0}
        ,{1,1,1,1,1,1,1,1,1,1}
        ,{0,1,0,0,0,0,1,0,0,0}
        ,{0,1,1,1,0,0,1,0,1,0}
        ,{1,1,0,1,0,1,1,0,1,1}
        ,{1,0,0,1,0,0,0,1,1,0}
        ,{1,1,1,0,1,1,1,1,0,0}
        ,{0,1,0,0,1,0,0,0,0,0}
        ,{0,1,1,1,1,0,0,0,0,0}
        ,{0,0,0,0,1,1,1,1,1,1}}; 
        DFS d = new DFS(maze);
        long t0 = System.nanoTime();
        d.addToAllThePoints();
        d.getAnswerList();
        long t1 = System.nanoTime();
        System.out.println("time: "+ (t1-t0));
        d.printSolution();
    }

    private void printSolution() {
        for (Point point : visitedPoints) {
            System.out.println("x: "+point.getY()+" y: "+point.getX());
        }
    }
}
