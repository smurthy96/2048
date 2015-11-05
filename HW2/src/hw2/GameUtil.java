package hw2;

import java.util.ArrayList;

import api.Move;

public class GameUtil {

	private static Move useMove;
	
	public GameUtil(){
		
	}
	
	public static int findNextNonemptyCell(int[] arr,int start){

		for(int i =start;i<arr.length;i++){
			if(!(arr[i]==0)){
				return i;
			}
		}
		return -1;
		
	}
	
	/**
	 * It will find the immediate tile to the right to merge left if it is the same
	 * number
	 * 
	 * @param arr
	 * @param index
	 * @return
	 */
	public static Move findNextMove(int[] arr, int index){
		findNextnonEmptyCell(arr,index); 
		
	}
	
	public static void applyOneMove(int[] arr, Move move){
		for(int a:arr){
			
		}
		
	}
	
	public static ArrayList<Move> collapseArray(int[] arr){
		
		
		return null;
		
	}
}
