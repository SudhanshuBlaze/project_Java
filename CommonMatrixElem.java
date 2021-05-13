// Java Program to prints common element in all rows of matrix(Works for all kinds of matrices even the sorted ones )
import java.util.*; 

class CommonMatrixElem 
{ 
	static void printCommonElements(int mat[][],int R,int C){

		Map<Integer,Integer> map = new HashMap<>(); 
		for(int i=0;i<C;i++)
			map.put(mat[0][i],1);  // initalize 1st row elements with value 1 ,even though duplicates are present
		
		for(int i=1;i<R;i++)	//traverse the array
			for(int j=0;j<C;j++){
				// If element is present in the map and is not duplicated in current row. 
				if(map.get(mat[i][j])!=null && map.get(mat[i][j])==i){
					map.put(mat[i][j],map.get(mat[i][j])+1);
				}
			}

		for(Map.Entry<Integer,Integer> entry: map.entrySet())
			if(entry.getValue()==R)  	// Find element having count equal to number of rows 
				System.out.print(entry.getKey()+" ");
	}
		
	// Driver code 
	public static void main(String[] args) 
	{ 
		int mat[][] = 
		{ 
			{1, 2, 1, 4, 8}, 
			{3, 7, 8, 5, 1}, 
			{8, 7, 7, 3, 1}, 
			{8, 1, 2, 7, 9}, 
		}; 

		printCommonElements(mat,mat.length,mat[0].length); 
	} 
} 

// This code contributed by Rajput-Ji 

