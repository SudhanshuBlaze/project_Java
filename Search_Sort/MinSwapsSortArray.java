/*
Step:1 check whether the sorted element is at correct position or not
 by comparing it with unsorted element, if not then go to step 2

Step:2 Put the sorted element at its correct position by swapping it with the unsorted element

Put the sorted element at correct position in UNSORTED array, and put the unsorted element 
at the position of sorted element in the UNSORTED array by getting its index using MAP.

Step:3 Update the HashMap with the new indices (correct indices)
*/

import java.util.*;
class MinSwapsSortArray{
	public static void main(String [] args) {
		int []arr = {7, 16, 14, 17, 6, 9, 5, 3, 18};
		// int []arr = {1,5,4,3,2};
        System.out.println(minSwaps(arr));
	}

	static int minSwaps(int unsorted[]){
		int len= unsorted.length, swaps=0;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0; i<len;i++){
			map.put(unsorted[i],i);
		}
		int sorted[] = Arrays.copyOfRange(unsorted, 0, len);
		Arrays.sort(sorted);  //time complexity of entire algorithm: O(NlogN)
		for(int i=0; i<len;i++){
			if(sorted[i]!=unsorted[i]){
				swaps++;

				int curr_unsorted_element = unsorted[i]; //aux variable-> value of unsorted[i] changes after swapping
				swap(unsorted, i, map.get(sorted[i]));
				map.put(curr_unsorted_element,map.get(sorted[i]));
				map.put(sorted[i],i);
			}
		}
		System.out.println(Arrays.toString(unsorted));
		return swaps;
	}
	static void swap(int[] unsorted,int a, int b){
		int temp=unsorted[a];
		unsorted[a]=unsorted[b];
		unsorted[b]=temp;
	}
}