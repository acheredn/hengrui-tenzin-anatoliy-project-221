// Tremaux Algorithm for Maze Solving:

// 1. Every time you visit a cell, mark it once.
// 2. When you hit a dead end, turn around and go back.
// 3. When you hit a junction you haven't visited, pick a new passage at random.
// 4. If you're walking down a new passage and hit a junction you have visited, treat it like a dead end and go back.
// 5. If walking down a passage you have visited before (i.e. marked once) and you hit a junction, take any new passage available, otherwise take an old passage (i.e. marked once).
// 6. When you finally reach the end, follow cells marked exactly once back to the start.
// 7. If the Maze has no solution, you'll find yourself at the start with all cells marked twice.


public class Tremaux {

    private int[][] maze;
    private int mazeWidth;
    private int mazeHeight;
    private int[] position;

    private ArrayList<Point> visitedPoints;
    private ArrayList<Point> answerList;

    public Tremaux(int[][] maze){
        this.maze = maze;
        this.mazeHeight = maze[0].length;
        this.mazeWidth = maze.length;

        visitedPoints = new ArrayList<>();
}


