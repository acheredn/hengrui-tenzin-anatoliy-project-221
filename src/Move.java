
import java.util.ArrayList;

public class Move {

	int[] destPos;
	int[] currPos;
	private boolean additionalMove;
	ArrayList<String> moveDir = new ArrayList<String>();
	public Move(int[] inpPos, String dir){
		if(dir!="")
			moveDir.add(dir);
		additionalMove = true;
		currPos = inpPos;
		if(dir!="")
		setDestination();
	}
	public Move(int[] inpPos, ArrayList<String> dir){
		if(dir!=null){
			moveDir = (dir);
			if(moveDir.size()>=2)
				additionalMove = false;
			else
				additionalMove = true;	
		}
		
		currPos = inpPos;
		if(dir!=null)
		setDestination();
	}
	
	public void setDestination(){
		if(moveDir.get(moveDir.size()-1).equals(null)) destPos=currPos;
		else if(moveDir.get(moveDir.size()-1).equalsIgnoreCase("UP")){
			destPos = new int[]{currPos[0]-1,currPos[1]};
		}
		else if(moveDir.get(moveDir.size()-1).equalsIgnoreCase("DOWN")){
			destPos =  new int[]{currPos[0]+1,currPos[1]};
		}
		else if(moveDir.get(moveDir.size()-1).equalsIgnoreCase("LEFT")){
			destPos = new int[]{currPos[0],currPos[1]-1};
		}
		else if(moveDir.get(moveDir.size()-1).equalsIgnoreCase("RIGHT")){
			destPos = new int[]{currPos[0],currPos[1]+1};
		}
		else destPos = null;
	}
	
	public int[] getDestPos(){
		return destPos;
	}
	
	public int[] getCurrPos(){
		return currPos;
	}
	
	public String getDir(){
		if(moveDir.size()!=0)
		return moveDir.get(moveDir.size()-1);
		else return null;
	}
	
	public void print(){
		System.out.println(moveDir);
	}
	
	public boolean getAdditionalMove(){
		return additionalMove;
	}

	public static String switchDir(String d)
	{
		if(d.equals("UP"))
		{
			return "DOWN";
		}
		else if(d.equals("DOWN"))
		{
			return "UP";
		}
		else if(d.equals("RIGHT"))
		{
			return "LEFT";
		}
		else if(d.equals("LEFT"))
		{
			return "RIGHT";
		}
		else return null;
	}
	
	public static String getRightDir(String d){
		if(d.equals("UP"))
		{
			return "RIGHT";
		}
		else if(d.equals("DOWN"))
		{
			return "LEFT";
		}
		else if(d.equals("RIGHT"))
		{
			return "DOWN";
		}
		else if(d.equals("LEFT"))
		{
			return "UP";
		}
		else return null;
	}
}