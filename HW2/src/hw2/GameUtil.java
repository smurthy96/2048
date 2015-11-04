package hw2;

import java.util.ArrayList;

import api.Move;

public class GameUtil {

	private Move useMove;
	
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
		
		for(int i =index;i<arr.length;i++){
			if(!(arr[i] == 0)){
				for(int a:arr){
					if(!(a==0)){
						if(a==arr[i]){
							return 
						}
					}
				}
			}
			else{
				
			}
		}
		
		return null;
		
	}
	
	public static void applyOneMove(int[] arr, Move move){
		for(int a:arr){
			
		}
		
	}
	
	public static ArrayList<Move> collapseArray(int[] arr){
		
		
		return null;
		
	}
}
