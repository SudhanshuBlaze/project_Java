// ascending order
// swap : O(n)

// select the lowest element in the Unsorted section of the array and 
//Bring it to the starting point
// change the counter for unsorted array by 1(in 2nd loop j=i)

import java.util.*;
class SelectionSort{

	public static void main(String[] args){
		int arr[] = {12,21,4,45,46,543,4,32,1,1};
		int i,j,min_index,temp;

		for(i =0;i<arr.length;i++){
			// min_index stores the index of smallest element in the unsorted section of the array
			min_index=i;			
			for(j=i;j<arr.length;j++){  
				if(arr[min_index]>arr[j])
					min_index=j;
			}
			temp=arr[min_index];
			arr[min_index]=arr[i];
			arr[i]=temp;
		}
		System.out.println(Arrays.toString(arr));
	}
}