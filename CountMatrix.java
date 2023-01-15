// Java program to find the row 
// with maximum number of 1s 
import java.io.*; 

class CountMatrix { 
	static int R = 4, C = 4; 
	// Function to find the index of first index 
	// of 1 in a boolean array arr[] 
	static int first(int arr[], int low, int high) 
	{ 
		int res = -1;
		if (high >= low) { 
			// Get the middle index 
			// Check if the element at middle index is first 1 
			while(low <= high){
				int mid = low + (high - low) / 2; 

				if (arr[mid] == 1) {
					res=mid;
					high=mid-1;	
				}

				// If the element is 0, recur for right side 
				else if (arr[mid] <1) 
					low=mid+1;
				// If element is not first 1, recur for left side 
				else
					high=mid-1;
			}
		} 
		return res; 
	} 

	// Function that returns index of row 
	// with maximum number of 1s. 
	static int rowWithMax1s(int mat[][]) {

		int first_index,max_row_index=Integer.MAX_VALUE;
	 	int max=first(mat[0],0,mat.length-1); //checking for first row
	 	if(max==0) return 0;  // if 1 is at 0th index then return the row (as it is the row with max 1s)
		
		for(int i = 1; i < mat.length;i++){

			if(max!=-1 && mat[i][max]==1){
				first_index=first(mat[i],0,max-1);
				System.out.println(first_index);
				if(first_index!=-1 && first_index<max){
					max=first_index;
					max_row_index=i;
				}
			}
			else{
				if(max==-1) max=first(mat[i],0,C-1);
				System.out.println(max);
				max_row_index=Math.min(max_row_index,i);
			}
		}
		return max_row_index;

	} 
	// Driver Code 
	public static void main(String[] args) 
	{ 
		int mat[][] = { { 0, 0, 0, 0 }, 
						{ 0, 1, 1, 1 }, 
						{ 1, 1, 1, 1 }, 
						{ 0, 0, 0, 0 } }; 
		System.out.println("Index of row with maximum 1s is "
											+ rowWithMax1s(mat)); 
	} 
} 


