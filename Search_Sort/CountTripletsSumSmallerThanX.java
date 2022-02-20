// count all the triplets whose sum is smaller than 'X'
import java.util.*;
class CountTripletsSumSmallerThanX{
	static int arr[] = new int[]{5, 1, 3, 4, 7};
	
	static int countTriplets(int len, int targetSum){
		Arrays.sort(arr);
	
		int countTriplets = 0;
	
		// Every iteration of loop counts triplet with first element as arr[i].
		for (int i = 0; i < len - 2; i++){
			// Initialize other two elements as corner elements of subarray arr[j+1..k]
			int lo = i + 1, hi = len - 1;
			while (lo < hi){
				if((arr[i]+arr[lo]+arr[hi]) >= targetSum){
					hi--;  //decrease the total sum
				} else{
					countTriplets+=hi-lo;
					lo++;  //increase sum by one step
				}
			}
			
		}
		return countTriplets;
	}
	
	public static void main(String[] args){
		int targetSum = 12;
		System.out.println(countTriplets(arr.length, targetSum));
	}
}
