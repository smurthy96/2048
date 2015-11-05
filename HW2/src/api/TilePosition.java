package api;

public class TilePosition {
	
	private int givenRow;
	private int givenCol;
	private int givenValue;
	public TilePosition(int givenRow,int givenCol,int givenValue){
		this.givenRow = givenRow;
		this.givenCol = givenCol;
		this.givenValue = givenValue;
	}
	
	public int getRow(){
		return this.givenRow;
		
	}

	public int getCol(){
		return this.givenCol;
		
	}
	
	public int getValue(){
		return this.givenValue;
		
	}
	
	public boolean equals(Object obj){
		return false;
		
	}
	
	public String toString(){
		return null;
		
	}
}
