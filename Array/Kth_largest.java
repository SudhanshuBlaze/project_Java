// 1) Using Heap
// 2) Using BubbleSort

// Implementation of Max-heap for Sorting in Ascending order
 //A simple optomization is to create a Max Heap of the given n elements and call heapify() k times.
 // max_heap extracts the largest element and puts it at last.

import java.util.*;

class Kth_largest{

	static int arr[]={8,7,6,5,4,3,2,1,0};

	public static void main(String[] args){
		// int arr[]={4,10,5,3,1};
		sort(arr,arr.length,2);
		bubbleSort(arr,arr.length,2);  

		System.out.println(Arrays.toString(arr));
	}

	static void sort(int[] arr,int len,int k){

		int i,calls=0;  //calls is num of function calls
		//creating a max heap(re-arrange array)
		for(i=len/2-1;i>=0;i--)
			heapify(arr,len,i);    // heapify executes 1 or no times for each iteration, does not recur

		// swapping first element(max) with last element
		for(i=len-1;i>=0;i--){

			if(calls==k){
				System.out.println("Using HeapSort: "+arr[arr.length-k]);
				return;
			}

			swap(0,i);               // 'i' is the limit reached(or length of array)
			heapify(arr,i,0);        // call max heapify on the reduced heap 
			calls++;
		}
	}

	static void heapify(int arr[],int len,int root){

		int largest=root, left=2*root+1, right=2*root+2;

		if(left<len && arr[left]>arr[largest])
			largest=left;     //if left child is larger(than root) then change largest to left

		if(right<len && arr[right]>arr[largest]) 
			largest=right;   //if right child is larger(than largest so far) then change largest to right

		//if any of the above "if" block is executed then largest!=root
		if(largest!=root){      // If largest is not root

			swap(largest,root);          //swap left/right whichever is larger with root
			heapify(arr,len,largest);   //changed root to largest
		} 
	}

	static void swap(int a, int b){   // no need to receive array as its static
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}

	static void bubbleSort(int arr[],int len,int k){
		int i,j,temp;
		for(i = 0;i<k;i++){		  // with every iteration it takes max number to end,
			for(j = 0;j<len-i-1;j++){   // last number is not to be checked 
				if(arr[j]>arr[j+1]){
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			// System.out.println(Arrays.toString(arr));
		}
		System.out.println("Using BubbleSort: "+arr[len-k]);
	}
}
