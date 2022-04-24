import java.util.ArrayList;
import java.util.PriorityQueue;

public class BruteForce {
    private int[][] maze;
    private int mazeWidth;
    private int mazeHeight;
    private ArrayList<Point> visitedPoints;
    private ArrayList<Point> answerList;

    public BruteForce(int[][] maze){
        this.maze = maze;
        this.mazeHeight = maze[0].length;
        this.mazeWidth = maze.length;
        visitedPoints = new ArrayList<>();
    }
    
    private void getAnswerList(){
        Point curPoint = new Point(0, 0);
        curPoint.setPreviousPoint(null);
        //while curPoint is not at the end location
        while(curPoint!=new Point(maze[0].length,maze.length)&&curPoint!=null){
            visitedPoints.add(curPoint);
            curPoint = findNeighbor(curPoint);
        }
        
    };
    private Point findNeighbor(Point previousPoint){
        int x = previousPoint.getX();
        int y = previousPoint.getY();
        if(inBound(x, y)){
            if(maze[x][y-1]==1){
                Point foundPoint = new Point(x,y-1);
                foundPoint.setPreviousPoint(previousPoint);
                if(!visitedPoints.contains(foundPoint)){
                    return foundPoint;
                }
            }
        }
        else if(inBound(x+1, y)){
            if(maze[x+1][y]==1){
                Point foundPoint = new Point(x+1,y);
                foundPoint.setPreviousPoint(previousPoint);
                if(!visitedPoints.contains(foundPoint)){
                    return foundPoint;
                }
            }
        }
        else if(inBound(x-1, y)){
            if(maze[x-1][y]==1){
                Point foundPoint = new Point(x-1,y);
                foundPoint.setPreviousPoint(previousPoint);
                if(!visitedPoints.contains(foundPoint)){
                    return foundPoint;
                }
            }
        }
        else if(inBound(x,y+1)){
            if(maze[x][y+1]==1){
                Point foundPoint = new Point(x,y+1);
                foundPoint.setPreviousPoint(previousPoint);
                if(!visitedPoints.contains(foundPoint)){
                    return foundPoint;
                }
            }
        }
        return null;
    }
    private boolean inBound(int x, int y){
        return x>=0 && x < mazeWidth && y>=0 && y <= mazeHeight;
    }
    
    public static void main(String[] args) {
    MazeGenerator m1 = new MazeGenerator(10);
    BruteForce b1 = new BruteForce(m1.getMaze());
    b1.getAnswerList();
    b1.printSolution();
    }

    private void printSolution() {
        for (Point point : visitedPoints) {
            System.out.println("x: "+point.getX());
            System.out.println("y: "+point.getY());
        }
    }
}

// 128 Maze Solver Algorithem
// At the start (hint: look at the stepCount variable)
// Create an (empty) worklist (queue/stack) of squares. (Hint: makeEmpty())
// Add the start square to the worklist. (Hint: maze.getStart() will return the Start square)
// Then apply the following repeatedly
// Is the worklist empty? If so, the exit is unreachable; terminate the algorithm by returning null (the maze is not solvable).
// Otherwise, grab the "next" location to explore from the worklist. (Hint: Use the next() method)
// Does the square correspond to the exit square? If so, the finish was reachable; terminate the algorithm (you've found a solution, yey!).
// Otherwise, it is a reachable non-finish location that we haven't explored yet. So, explore it as follows:
// compute all the adjacent up, right, down, left locations that are inside the maze and aren't walls, and
// add them to the worklist for later exploration provided they have not previously been added to the worklist.
// Also, record the fact that you've explored this location so you won't ever have to explore it again. Note that a location is considered "explored" once its neighbors have been put on the worklist. The neighbors themselves are not "explored" until they are removed from the worklist and checked for their neighbors.