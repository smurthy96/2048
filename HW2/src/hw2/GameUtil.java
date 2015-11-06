package hw2;

import java.util.ArrayList;

import api.Move;

public class GameUtil {

	public static void main(String[] args){
		
		int[][] arr = new int[5][5];
		
		for(int i =0;i < 5;i++){
			for(int j=0;j<5;j++){
				arr[i][j] = i*j;
			}
		}

		for(int i =0;i < 5;i++){
			for(int j=0;j<5;j++){
				System.out.print(" "+arr[i][j]);
			}
			System.out.println();
		}
//		Move m = findNextMove(arr,0);
//		applyOneMove(arr, m);
		System.out.println("");
		for(int i =0;i<5;i++){
			System.out.print(arr[i][2]);
		}
		
	}
	
	
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
			return new Move(index1,index2,index+1,arr[index1]);
		}
		else if(index1 != -1){
			return new Move(index1,index+1,arr[index1]);
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
		
		if(!(move.isMerged())){
			
			arr[newIndex] = value;
			arr[oldIndex1] = 0;
			
		}
		else{
			arr[newIndex] = value*2;
			arr[oldIndex2] = 0;
//			for(int i =0; i < arr.length;i++){
//				System.out.println(arr[i]);
//			}
		}
		
		
		
		
	}
	
	public static ArrayList<Move> collapseArray(int[] arr){
		ArrayList<Move> retMoves = new ArrayList<Move>();
		
		for(int i =0;i<arr.length;i++){ 
			Move m = findNextMove(arr,i);
			if(m != null){			
				retMoves.add(m);
				applyOneMove(arr, m);
				}		
			}

		return retMoves;
		
		
	}
}
