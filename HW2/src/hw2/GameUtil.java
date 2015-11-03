package hw2;

import java.util.ArrayList;

import api.Move;

public class GameUtil {

	public GameUtil(){
		
	}
	
	public static int findNextNonemptyCell(int[] arr,int start){
		
		
		return start;
		
	}
	
	public static Move findNextMove(int[] arr, int index){
		
		
		return null;
		
	}
	
	public static void applyOneMove(int[] arr, Move move){
		for(int a:arr){
			
		}
		
	}
	
	public static ArrayList<Move> collapseArray(int[] arr){
		ArrayList<Integer> tempArray = new ArrayList<Integer>(arr.length);
		int i =0;
		for(int a: arr){
			i ++;
			if(!(a==0)){
				tempArray.add(a);
			}
			else{
				tempArray.add(arr.length - i, a);
			}
		}
		
		return null;
		
	}
}
