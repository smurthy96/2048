package api;

public class Move {
	
	private int oldIndex;
	private int oldIndex2;
	private int newIndex;
	private int value;
	private int givenRowOrColumn;
	private Direction givenDirection;
	
	public Move(int oldIndex,int newIndex,int value){
		this.oldIndex = oldIndex;
		this.newIndex = newIndex;
		this.value = value;
		
	}
	
	public Move(int oldIndex,int oldIndex2,int newIndex,int value){
		this.oldIndex = oldIndex;
		this.newIndex = newIndex;
		this.oldIndex2 = oldIndex2;
		this.value = value;
		
	}
	
	public void setDirection(int givenRowOrColumn,Direction givenDirection){
		this.givenRowOrColumn = givenRowOrColumn;
		this.givenDirection = givenDirection;
		
	}
	public int getOldIndex(){
		return this.oldIndex;
	}
	
	public int getOldIndex2(){
		return this.oldIndex2;
	}
	
	public int getNewIndex(){
		return this.newIndex;
	}
	
	public boolean isMerged(){
		
	}
	
	public Direction getDirection(){
		
	}
	
	public int getRowOrColumn(){
		
	}
	
	public int getValue(){
		
	}
	
	public boolean equals(Object obj){
		
	}
	
	public String toString(){
		
	}
	
}
