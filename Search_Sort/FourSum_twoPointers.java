/*Counts and prints all unique values in the case of duplicates.

We will use jumps to eradicate duplicate elements
*/
import java.util.*;
class FourSum_twoPointers{

	public static void main(String and[]){
		int arr[] = {10,2,3,3,3,4,5,7,8};
		int target= 23;

		// int arr[] = {0,0,1,1,2};
		// int target=3;
		System.out.println(fourSum(arr, target));
	}
	static ArrayList<ArrayList<Integer>> fourSum(int arr[], int target){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(arr);
		for (int i=0; i < arr.length-3; i++){
			for (int j=i+1; j < arr.length-2; j++){
				
				int target_2= target-(arr[i]+arr[j]);
				int lo=j+1, hi=arr.length-1;
				while(lo<hi){

					int twoSum=arr[lo]+arr[hi];
					if(twoSum<target_2)
						lo++;
					else if(twoSum>target_2)
						hi--;
					else{
						ArrayList<Integer> quad=new ArrayList<>();
						quad.add(arr[i]);
						quad.add(arr[j]);
						quad.add(arr[lo]);
						quad.add(arr[hi]);
						res.add(quad);
						//skipping duplicates, since the array is sorted the duplicate 
						// will be right next
						while(lo<hi && arr[lo]==quad.get(2)) lo++;	
						while(lo<hi && arr[hi]==quad.get(3)) hi--;
					}
				}
				while(j<arr.length-3 && arr[j]==arr[j+1]) j++;
			}
			while(i<arr.length-4 && arr[i]==arr[i+1]) i++;
		}
		return res;
	}	

}