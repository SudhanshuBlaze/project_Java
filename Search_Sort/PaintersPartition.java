/*Given an array A of non-negative integers and a positive integer k, 
we have to divide A into k of fewer partitions such that the maximum sum of the elements 
in a partition, overall partitions is minimized.
Note: any painter will only paint continuous sections of boards

Time complexity: O(N*log(sum(arr[])))

Binary search takes-> log(sum(arr[]))
Assigning the mid value function takes->O(N)
*/
import java.util.*;
class PaintersPartition{
	public static void main(String args[]){
		int boards[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 }; //len of each board
		int painters=3;
		System.out.println(partition(boards,painters));
	}
	static long partition(int boards[], int k){
		//if high is big value then calculate it using for-loop by adding each elements
		long low=Arrays.stream(boards).max().getAsInt(), high=Arrays.stream(boards).sum();
		long res=-1;
		while(low<= high){
			long mid=low + (high-low)/2;
			if(allocateBoards(boards,mid,k)){
				res= mid;
				high=mid-1;
			}
			else
				low= mid + 1;
		}
		return res;
	}

	static boolean allocateBoards(int boards[], long boardLen, int reqdPainters){
		int currPainters=1;
		int maxBoard=boards[0];
		for(int i=1;i<boards.length;i++){
			if(maxBoard+boards[i]<=boardLen)
				maxBoard+=boards[i];
			
			else{
				maxBoard=boards[i];
				currPainters++;
			}
		}
		if(currPainters>reqdPainters)
			return false;
		return true;
	}
}



