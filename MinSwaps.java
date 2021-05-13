import java.util.*;
class MinSwaps{
	public static void main(String[] args){

		
		int arr[]={2, 7, 9, 5, 8, 7, 4};
		int pivot=3;  //index of number 5
		System.out.println("Number of Swaps "+minSwaps(arr, pivot));
		System.out.println("Arranged element around the pivot "+Arrays.toString(arr));
	}

	static int minSwaps(int[] arr, int pivot){  // Partioning function of Quicksort
		int count=0, slow_idx=0;

		for(int i=0; i<arr.length;i++){
			if(arr[i]<arr[pivot]){
				// increment count only if slow_idx is not equal to current index
				if(i!=slow_idx) 
					count++;
				swap(arr,i,slow_idx);
				slow_idx++;
			}
		}
		if(slow_idx!=pivot) count++;
		swap(arr,slow_idx,pivot);
		return count;
	}

	static void swap(int arr[],int a,int b){
		int tmp=arr[a];
		arr[a]=arr[b];
		arr[b]=tmp;
	}
}