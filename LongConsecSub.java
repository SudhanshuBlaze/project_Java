// Java program to find longest consecutive subsequence 
// @author SudhanshuBlaze

import java.io.*; 
import java.util.*; 

class LongConsecSub { 
	// Returns length of the longest 
	// consecutive subsequence 

	static int findLongestConseqSubseq(int arr[], int n) 
	{ 
		HashSet<Integer> set = new HashSet<Integer>(); // take cares of duplicate elements
		int ans = 1,ct=1; 

		// Hash all the array elements 
		for (int i = 0; i < n; ++i) 
			set.add(arr[i]); 

		// check each possible sequence from the start 
		// then update optimal length 
		for (int i = 0; i < n; ++i) 
		{ 
			// if current element is the starting 
			// element of a sequence 
			if (!set.contains(arr[i] - 1)){
				// Then check for next elements 
				// in the sequence 
				
				ct=1; // reset counter
				while (set.contains(arr[i] +ct)){
					ct++;
				// update optimal length if this length is more 
					ans=Math.max(ans,ct);
				} 
			}
		} 
		return ans; 
	} 

	// Driver Code 
	public static void main(String args[]) 
	{ 
		int arr[] = { 1,2,3,4 ,6}; 
		int n = arr.length; 
		System.out.println( 
			"Length of the Longest consecutive subsequence is "
			+ findLongestConseqSubseq(arr, n)); 
	} 
} 
