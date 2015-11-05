package api;

public class TesterMain {
	public static void main(String[] args){
		int index = 1;
		int index1 = 0;
		int index2 = 0;
		int[] arr = new int[5];
		
		arr[0] = 4;
		arr[1] = 0;
		arr[2] = 2;
		arr[3] = 0;
		arr[4] = 0;
		
		for(int i = index;i<arr.length;i++){
			if(!(arr[i] == 0)){
				System.out.println(i);
				index1 = i;
				for(int j = index1; j < arr.length;j++){
					if(!(arr[j] == 0)){
						index2 = j;
						break;
					}

					
				}
				
			}
			else{
				break;
			}
			
		}
		
		if(arr[index1] == arr[index2]){
			//System.out.println("Found 2 occupied cell"+"  "+(index1 +" "+index2));
		}
		else{
			System.out.println("NO second occupied cell");
		}
	
	}
}
