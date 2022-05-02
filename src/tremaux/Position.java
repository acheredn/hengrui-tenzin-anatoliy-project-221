package tremaux;

import java.util.ArrayList;
import tremaux.Move;

public class Position {
	int[] currPos;
	boolean backtrack;
	ArrayList<Move> moveList = new ArrayList<Move>();
	ArrayList<Point> resultPoints = new ArrayList<Point>();
	public Position(){
		backtrack = false;
		currPos = new int[]{0,0};
		moveList.add(new Move(currPos,""));
	}
	
	public void tryMove(){
		String[] dir = {"UP","DOWN","LEFT","RIGHT"};
		int c = moveList.size();
		ArrayList<String> tempDir = new ArrayList<String>();
		for(int i=0;i<dir.length;i++){
			String s = dir[i];
			if(moveList.size()>1){
				if(s.equals(Move.switchDir(moveList.get(moveList.size()-1).getDir())))
					continue;
			}
			if(Maze.checkMove(new Move(currPos, s))){
				tempDir.add(s);
			}
			
			
		}
		if(tempDir.size()!=0){
		Move temp = new Move(currPos, tempDir);
		currPos = temp.getDestPos();
		moveList.add(temp);
		
		}
		if(moveList.size()==c&&moveList.size()>1){
			backtrack();
		}
		resultPoints.add(new Point(currPos[1],currPos[0],1));
		System.out.println("x:" + currPos[0]+","+ "y:" + currPos[1]);		
	}
	public void backtrack(){
		backtrack = true;
		System.out.println(backtrack);
		int i = (moveList.size()-1);
		String d = Move.switchDir(moveList.get(i).getDir());
		while(moveList.get(i).moveDir.size()==1){
			d = Move.switchDir(moveList.get(i).getDir());
			Move t = new Move(currPos, d);
			moveList.add(t);
			System.out.println(t.getDir());
			currPos = t.getDestPos();
			i--;
		}
		if(Maze.checkMove(new Move(currPos, d))){
		Move t = new Move(currPos, d);
		moveList.add(t);
		System.out.println(t.getDir());
		currPos = t.getDestPos();
		}
		
		moveList.get(i).moveDir.remove(moveList.get(i).moveDir.size()-1);
		Move t = new Move(currPos, moveList.get(i).moveDir.get(moveList.get(i).moveDir.size()-1));
		moveList.add(t);
		System.out.println(t.getDir());
		currPos = t.getDestPos();
		
	}
	public int run(){
		int count = 0;
		while(!(Maze.isFinished)){
			tryMove();
			count++;
		}
		System.out.println("DONE");
		return count;
	}
	public ArrayList<Point> getResultPoint (){
		return resultPoints;
	}
}