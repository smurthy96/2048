package hw2;

import java.util.ArrayList;

import api.Move;

public class GameUtil {

	public static void main(String[] args){
		
		int[] arr = new int[5];
		
		arr[0] =4;
		arr[1] =2;
		arr[2] =0;
		arr[3] =2;
		arr[4] =0;
		
		int index1 = findNextNonemptyCell(arr,1);
		int index2 = findNextNonemptyCell(arr,index1);
		
		System.out.println(index2);
		
	}
	
	private static Move useMove;
	private static int[] temparr;
	
	public GameUtil(){
		
	}
	
	public static int findNextNonemptyCell(int[] arr,int start){
		for(int i = start+1;i<arr.length;i++){
			if(arr[i] != 0){
				return i-1;
			}
		}
		return -1;
	}

	public static Move findNextMove(int[] arr, int index){
		
		
		int index1 = findNextNonemptyCell(arr,index);
		int index2 = findNextNonemptyCell(arr,index1);
		
		//System.out.println(index1);
		//System.out.println(index2);
		
		if(arr[index1] == arr[index2] &&index2 != -1){
			System.out.println("BRUH BRUH");
			return new Move(index1,index2,index,arr[index1]);
		}
		else{
			System.out.println("LOL LOL");
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
