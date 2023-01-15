// Java program to find longest consecutive subsequence 
// @author SudhanshuBlaze

import java.io.*; 
import java.util.*; 

class LongConsecSub { 
	// Returns length of the longest 
	// consecutive subsequence 

	static int findLongestConseqSubseq(int arr[], int n) 
	{ 
		HashSet<Integer> set=new HashSet<Integer>();
	   int maxCount=0, count;  //if empty array by default maxCount is 0
	   for(int e: arr)
	    set.add(e);
	    
	    for(int i=0;i<n;i++){
	        if(!set.contains(arr[i]-1)){
	            count=1; //one element present so count 1 by default
	            int nextSubs=arr[i]+1;  //used to find next subsequences
	            while(set.contains(nextSubs)){
	                nextSubs++;
	                count++;
	            }
	   	        maxCount=Math.max(maxCount,count);
	        }
	    }
	    return maxCount;
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
