// Find the triplets that sum to a Given target value-> Two Pointer Algorithm
import java.util.*;
public class ThreeSum{
	static int target;  //Global variable

	public static void main(String[] args){
		int arr[] ={2,-3,1,4,5,1,9,-5};
		target=6;
		triplets(arr,target);
	}
	static void triplets(int[] arr,int target){
		Arrays.sort(arr);
		for(int i=0;i<arr.length-2;i++){
			if (twoSum(arr,target-arr[i],i+1)) return;
		}
		System.out.println("Not found");
		return;
	}

	static boolean twoSum(int[] arr,int x,int i){ // Two sum approach
		int j=arr.length-1;

		while(i<j){
			if((arr[i]+arr[j])<x)
				i++;
			else if((arr[i]+arr[j])>x)
				j--;
			else {   // Number Found
				System.out.printf("Triplets found are %d %d %d ",target-x,arr[i],arr[j]);
				return true;
			}
		}
		System.out.println("Not found triplets");
		return false;
	}
}