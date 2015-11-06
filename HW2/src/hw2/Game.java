package hw2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import api.Direction;
import api.Move;
import api.Result;
import api.TilePosition;

public class Game {

	private int givenSize = 0;
	private Random givenRandom;
	private int[][] tilesrc = new int[givenSize][givenSize];
	
	public Game(int givenSize){
		this.givenSize = givenSize;
	}
	
	public Game(int givenSize, Random givenRandom){
		this.givenSize = givenSize;
		this.givenRandom = givenRandom;
	}
	
	public int getCell(int row, int col){
		return tilesrc[row][col];
	}
	
	public void setCell(int row,int col, int val){
		
		tilesrc[row][col] = val;
		
	}
	
	public int getSize(){
		return this.givenSize;
	}
	
	public int getScore(){
		return 5;
	}
	
	public int[] copyRowOrColumn(int rowOrColumn,Direction dir){
		int[] tempArr = new int[this.givenSize];
		for(int i =0; i < this.givenSize;i++){
			if(dir == Direction.RIGHT){
				tempArr[i]=this.tilesrc[rowOrColumn][i]; 
			}
			else if(dir == Direction.LEFT){
				tempArr[i]=this.tilesrc[rowOrColumn][this.givenSize-i];
			}
			else if(dir==Direction.DOWN){
				tempArr[i]=this.tilesrc[i][rowOrColumn];
			}
			else if(dir == Direction.UP){
				tempArr[i]=this.tilesrc[this.givenSize - i][rowOrColumn];
			}
			else{
				return null;
			}
		}
		
		return tempArr;
		
	}
	
	public void updateRowOrColumn(int[] arr,int rowOrColumn,Direction dir){
		
		for(int i =0; i < this.givenSize;i++){
			if(dir == Direction.RIGHT){
				this.tilesrc[rowOrColumn][i] = arr[i]; 
			}
			else if(dir == Direction.LEFT){
				this.tilesrc[rowOrColumn][this.givenSize-i]=arr[i];
			}
			else if(dir==Direction.DOWN){
				this.tilesrc[i][rowOrColumn]=arr[i];
			}
			else if(dir == Direction.UP){
				this.tilesrc[this.givenSize - i][rowOrColumn]=arr[i];
			}
			else{
				continue;
			}
		}
		
		
	}
	
	public Result collapse(Direction dir){
		int[] arrcol = new int[this.givenSize];
		for(int i =0; i < this.givenSize;i++){
			
			for(int j=0;j<this.givenSize;j++){
				
				if(dir == Direction.RIGHT){
					GameUtil.collapseArray(tilesrc[j]);
				}
				else if(dir == Direction.LEFT){
				}
				else if(dir==Direction.DOWN){
				}
				else if(dir == Direction.UP){
				}
				else{
					continue;
				}
			}
		}
		
	}
	
	public TilePosition generate(){
		return null;
		
	}
	
}
