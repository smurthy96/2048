package hw2;

import java.util.ArrayList;

import api.Move;

public class GameUtil {

	private static Move useMove;
	private static int[] temparr;
	
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

	public static Move findNextMove(int[] arr, int index){
		
		
		int index1 = findNextNonemptyCell(arr,index);
		int index2 = findNextNonemptyCell(arr,index1);
		
		

		if(index1 == index2 && index1 != -1 && index2 != -1){
			return new Move(index1,index2,index,arr[index1]);
		}
		else{
			return new Move(index1,index,arr[index1]);
		}
		
	}
	
	public static void applyOneMove(int[] arr, Move move){
		int oldIndex1 = move.getOldIndex();
		int oldIndex2 = move.getOldIndex2();
		int newIndex = move.getNewIndex();
		int value = move.getValue();
		
		temparr = arr;
		temparr[newIndex] = arr[oldIndex1]+arr[oldIndex2];
		
		
	}
	
	public static ArrayList<Move> collapseArray(int[] arr){
		
		
		
		
	}
}
