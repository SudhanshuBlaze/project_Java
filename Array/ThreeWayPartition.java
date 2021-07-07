// sort an array of 0s, 1s and 2s
import java.util.*;
class ThreeWayPartition{
	public static void main(String[] args){
		int arr[]={1, 14, 5, 20, 4, 2, 54, 20, 87, 98,15, 3, 1, 32};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	static void sort(int [] arr){
		int low=0,mid=0,high=arr.length-1,low_range=14,high_range=20;

		while(mid<=high){
				if(arr[mid]<low_range){
					swap(arr,low,mid);
					low++;
					mid++;
				}
				else if(arr[mid]>high_range){
					swap(arr,mid,high); // do not increment mid index as ,you will be needing the check which value has been swapped at mid index
					high--;   
				}
				else if(arr[mid] > arr[high]){
					swap(arr, low, mid);
					mid++;
				}
				else    //if( low_range<=arr[mid] && arr[mid]<=high_range )
					mid++;
		}
	}
	static void swap(int[] arr,int a, int b){
		int tmp=arr[a];
		arr[a]=arr[b];
		arr[b]=tmp;
	}
}