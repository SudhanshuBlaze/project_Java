/*
When there's no repetition of elements
Counts and Prints all the triplets, doesn't look for unique triplets,
 */

import java.util.*;
class ThreeSum_Hash{

	public static void main (String [] args) {
		//no repetitive numbers
		int arr[]={9, 1, 4, 5 ,45, 6, 10, 8};
		int target=10;
		// int arr[] = {1,1,4,4,2};
		// int target =7;
		System.out.println("Count of triplets: "+find3Numbers(arr, arr.length,target));
	}

	public static int find3Numbers(int A[], int n, int X) { 
    	int count =0;
        for (int i = 0; i < n - 2; i++) {
        	//creating new hash set at each step because we don't want to print duplicates
        	HashSet<Integer> s = new HashSet<Integer>();
			int curr_sum = X - A[i];
			for (int j = i + 1; j < n; j++){

				if (s.contains(curr_sum - A[j])){
					count++;
					System.out.printf("Triplet is %d,%d, %d\n", A[i],A[j], curr_sum - A[j]);				
				}
				else
					s.add(A[j]);
			}
    	}
    	return count;
    }
}