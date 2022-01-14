// sort an array of 0s, 1s and 2s -> QuickSort partition function does not work properly
import java.util.*;
class DutchNationalFlag{
	public static void main(String[] args){
		int arr[]={0,2,1,1,2,0,0,2,2,0,0};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	static void sort(int [] arr){
		int low=0,mid=0,high=arr.length-1;

		while(mid<=high){
			switch(arr[mid]){
				case 0:
					swap(arr,low,mid);
					low++;
					mid++;
					break;
				case 1:
					mid++;  // low index stays behind
					break;
				case 2:
					swap(arr,mid,high); // do not increment mid index as ,you will be needing the check which value has been swapped at mid index
					high--;   
					break;
			}
		}
	}
	static void swap(int[] arr,int a, int b){
		int tmp=arr[a];
		arr[a]=arr[b];
		arr[b]=tmp;
	}
}