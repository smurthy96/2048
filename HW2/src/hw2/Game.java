package hw2;

import java.util.Random;

import api.Direction;
import api.Result;
import api.TilePosition;

public class Game {

	private int givenSize;
	private Random givenRandom;
	
	public Game(int givenSize){
		this.givenSize = givenSize;
	}
	
	public Game(int givenSize, Random givenRandom){
		this.givenSize = givenSize;
		this.givenRandom = givenRandom;
		
	}
	
	public int getCell(int row, int col){
		
		return (Integer) null;
	}
	
	public void setCell(int row,int col, int val){
		
	}
	
	public int getSize(){
		return this.givenSize;
	}
	
	public int getScore(){
		return 5;
	}
	
	public int[] copyRowOrColumn(int rowOrColumn,Direction dir){
		return null;
		
	}
	
	public void updateRowOrColumn(int[] arr,int rowOrColumn,Direction dir){
		
	}
	
	public Result collapse(Direction dir){
		
		
		return null;
		
	}
	
	public TilePosition generate(){
		return null;
		
	}
	
}
