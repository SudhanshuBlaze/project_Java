/*Note: Time Complexity of this approach is O(N^2), because merge is O(N^2), 
Space complexity: O(1),
Time complexity of standard merge sort is O(N logN), Space complexity: O(N)*/

import java.util.*;
class MergeSortInPlace{
	public static void main(String args[]){
		int arr[] = { 12, 11, 13, 5, 6, 7 };
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
	}
	static void sort(int arr[], int start, int end){
		if(start <end){
			int mid=start + (end - start)/2;
			sort(arr, start, mid);
			sort(arr, mid+1, end);	
			mergeInPlace(arr, start, mid,end);		
		}
	}

	static void mergeInPlace(int arr[], int start, int mid, int end){
		int start2=mid+1;
		//if last element of first sorted array is less than first element of 
		//second sorted array, then the array is already sorted
		if(arr[mid]<=arr[start2])
			return;
		while(start<=mid && start2<=end){
			if(arr[start]<=arr[start2])
				start++;
			//shifting the elements right side, starting from ending
			else{
				int smallerVal=arr[start2];
				int shiftIndex=start2;

				while(start!=shiftIndex){
					arr[shiftIndex]=arr[shiftIndex-1];
					shiftIndex--;
				}
				arr[start]=smallerVal;
				start++;
				start2++;
				mid++; //important step since the size(one step shifted right) of first array 
				//is increased due to insertion of an element from second array,
				// the mid is also shifted towards right side
			}
		}
	}
}




