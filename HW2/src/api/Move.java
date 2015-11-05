package api;

public class Move {
	
	private int oldIndex;
	private int oldIndex2;
	private int newIndex;
	private int value;
	private int givenRowOrColumn;
	private Direction givenDirection;
	
	//non merge move
	public Move(int oldIndex,int newIndex,int value){
		this.oldIndex = oldIndex;
		this.newIndex = newIndex;
		this.value = value;
		
	}
	
	//Merge Move
	/**
	 * 
FIND THE NEXT OCCUPIED CELL AFTER INDEX call it INDEX1

FIND THE NEXT OCCUPIED CELL AFTER INDEX1 call it INDEX2

IF YOU CAN'T FIND INDEX2 then it is a non merge move (VALUE at INDEX1 -> INDEX, 0 -> INDEX1)

IF YOU FOUND INDEX2
CHECK WHETHER THE VALUE AT INDEX1 == VALUE AT INDEX2
IF YES THEN MERGE (VALUE at INDEX1+INDEX2 -> INDEX, 0 -> INDEX1, 0 -> INDEX2)

IF NO THEN DON'T it is a non merge move (VALUE at INDEX1 -> INDEX, 0 -> INDEX1)

IF YOU CAN'T FIND INDEX1 RETURN NULL
	 * @param oldIndex
	 * @param oldIndex2
	 * @param newIndex
	 * @param value
	 */
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
