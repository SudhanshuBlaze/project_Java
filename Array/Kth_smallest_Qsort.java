import java.util.Arrays;
import java.util.Collections;

class Kth_smallest_Qsort {
	// Standard partition process of QuickSort. It considers the last element as pivot
	// and moves all smaller element to left of it and greater elements to right
	
	// 3,4,1,2 -> 1,2,3,4
	public static int partition(int arr[], int l,int r){
		int pivot = arr[r];
		int slow_idx=l-1;
		for(int i=l;i<r;i++){
			// just change this symbol to '>' in case of kth Largest element
			if(arr[i]<=pivot){
				slow_idx++;
				swap(arr,i,slow_idx);
			}
		}
		slow_idx++;
		swap(arr,r,slow_idx);
		return slow_idx;
	}

	static void swap(int arr[],int a,int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	static int findKth(int arr[],int l, int r, int k){

		if(arr[l]==arr[r])
			return arr[l];

		int pos=partition(arr,l,r);

		if(pos+1==k)
			return arr[pos];
		// check for the Kth smallest element in left half
		else if(pos+1>k)
			return findKth(arr,l,pos-1,k);
		// check for the Kth smallest element in right half
		else
			return findKth(arr,pos+1,r,k);
	}

	public static void main(String[] args){
		int arr[] = {3,4,1,2};
		int k = 3;
		System.out.println(findKth(arr,0,arr.length-1,k));
	}
}

