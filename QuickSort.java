//worst case: O(n^2)  ,ex:- arr={1,2,3,4,5,6,7,8....}

import java.util.*;

class QuickSort{
	public static void main(String[] args){
		int arr[] = {12,1,2,134,5,62};
		sort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	static void sort(int arr[] ,int start,int end){

		if(start<end){	//enter into the function only if the condition is true
			int pivot = partition(arr,start,end);

			sort(arr,start,pivot-1);  // sort values left of pivot
			sort(arr,pivot+1,end);    // sort values right of pivot
		}
	}

	static int partition(int arr[],int start,int end){

		int small_index =start-1;  //alt. small_index=start, later small_index++, do not add +1 while returning or swapping the pivot
		int pi = arr[end];
		int i;
		for(i=start;i< end;i++){  // i runs between subarr[start,end-1], because last element pivot
			if(arr[i] < pi){      // comparing all the elements of array
				small_index++;	  // increment small_index if condition is true, else it stays there with larger number
				swap(arr,small_index,i);				
			}
		}
		swap(arr,small_index+1,end);   //swapping pivot
		return small_index+1;		//return pivot
	}

	static void swap(int arr[],int a,int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}