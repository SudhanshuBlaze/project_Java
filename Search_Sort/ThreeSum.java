/* Find the triplets that sum to a Given target value-> Two Pointer Algorithm

When there's no repetition of elements
Counts and Prints all the triplets, doesn't look for unique triplets,
 
We can use a HashSet to get Unique triplets
 */

import java.util.*;
public class ThreeSum{
	static int target;  //Global variable

	public static void main(String[] args){
		int arr[] ={2,-3,1,4,5,1,9,-5};
		target=6;
		// int arr[]={9, 1, 4, 5 ,45,1, 6, 10, 8};
		// target =10;
		triplets(arr,target);
	}
	static void triplets(int[] arr,int target){
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		for(int i=0;i<arr.length-2;i++){
			twoSum(arr,target-arr[i],i+1);
		}
	}

	static boolean twoSum(int[] arr,int x,int i){ // Two sum approach
		int j=arr.length-1;

		while(i<j){
			if((arr[i]+arr[j])<x)
				i++;
			else if((arr[i]+arr[j])>x)
				j--;
			else {   // Number Found
				System.out.printf("Triplets found are %d %d %d \n",target-x,arr[i],arr[j]);
				//continue the search by shrinking the search space
				i++;
				j--;
			}
		}
		return false;
	}
}