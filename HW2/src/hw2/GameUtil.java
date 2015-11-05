package hw2;

import java.util.ArrayList;

import api.Move;

public class GameUtil {

	public static void main(String[] args){
		
		int[] arr = new int[5];
		
		arr[0] =4;
		arr[1] =0;
		arr[2] =2;
		arr[3] =0;
		arr[4] =2;
		
		findNextMove(arr,1);
		
	}
	
	private static Move useMove;
	private static int[] temparr;
	
	public GameUtil(){
		
	}
	
	public static int findNextNonemptyCell(int[] arr,int start){
		
		for(int i = start+1;i<arr.length;i++){
			if(arr[i] != 0){
				return i;
			}
		}
		return -1;
	}

	public static Move findNextMove(int[] arr, int index){
		
		
		int index1 = findNextNonemptyCell(arr,index);
		int index2 = findNextNonemptyCell(arr,index1);

		
		if(index1 != -1 && index2 != -1 && arr[index1] == arr[index2]){
			return new Move(index1,index2,index,arr[index1]);
		}
		else if(index1 != -1){
			return new Move(index1,index,arr[index1]);
		}
		else{
			return null;
		}
		
	}
	
	public static void applyOneMove(int[] arr, Move move){
		int oldIndex1 = move.getOldIndex();
		int oldIndex2 = move.getOldIndex2();
		int newIndex = move.getNewIndex();
		int value = move.getValue();
		temparr = arr;
		
		if(oldIndex2 == 0){
			
			temparr[newIndex] = arr[oldIndex1];
			temparr[oldIndex1] = 0;
			
		}
		else{
			temparr[newIndex] = arr[oldIndex1] + arr[oldIndex2];
			temparr[oldIndex1] = 0;
			temparr[oldIndex2] = 0;
		}
		
		
		
		
	}
	
	public static ArrayList<Move> collapseArray(int[] arr){
		ArrayList<Move> retMoves = new ArrayList<Move>();
		
		for(int i =0;i<arr.length;i++){
			if(arr[i] != 0){
				retMoves.add(findNextMove(arr,i));
			}
		}
		return retMoves;
		
		
	}
}
