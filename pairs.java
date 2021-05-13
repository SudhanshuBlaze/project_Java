//Count pairs with given sum

// Input  :  arr[] = {1, 5, 7, -1, 5}, 
//           sum = 6
// Output :  3
// Pairs with sum 6 are (1, 5), (7, -1) &
//                      (1, 5) 

import java.util.*;
class pairs{

	public static void main(String args[]){
		int arr[]={1,5,7,-1,5};
		int target_sum=6;
		System.out.println("Count of pairs= "+count(arr,target_sum));
	}

	static int count(int arr[], int target_sum){
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		int count_twice=0;

		// Creating a frequency table here
		for (int e:arr){
			if(map.containsKey(e))
				map.put(e,map.get(e)+1);
			else 
				map.put(e,1);
		}

		for (int e:arr){

			if(map.containsKey(target_sum-e))  // iterate through each element and increment the 
				count_twice+=map.get(target_sum-e);   // count (Notice that every pair is counted twice)

			//if (e,e) pair of same element satisfies the condition, 
            // then we need to ensure that the count is 
           	// decreased by one.
			if(target_sum-e==e)  
				count_twice--;
		}
		return count_twice/2;    // count_twice always even

	}
}