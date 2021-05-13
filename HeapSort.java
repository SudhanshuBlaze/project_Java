// Implementation of Max-heap for 

import java.util.*;

class HeapSort{

	static int arr[]={8,7,6,5,4,3,2,1,0};  //Global

	public static void main(String[] args){
		// int arr[]={4,10,5,3,1};
		sort(arr,arr.length);
		System.out.println(Arrays.toString(arr));
	}

	static void sort(int[] arr,int len){
		int i;
		//creating a max heap(re-arrange array)
		for(i=len/2-1;i>=0;i--)  //start heapifying with lowest(last root with children)
			heapify(arr,len,i); 

		// swapping first element(max) with last element, heapify again
		for(i=len-1;i>=0;i--){

			swap(0,i);               // 'i' is the limit reached(or length of array)
			heapify(arr,i,0);        // call max heapify on the reduced heap 
		}
	}

	static void heapify(int arr[],int len,int root){

		int largest=root, left=2*root+1, right=2*root+2;

		if(left<len && arr[left]>arr[largest])
			largest=left;     //if left child is larger(than root) then change largest to left

		if(right<len && arr[right]>arr[largest])
			largest=right;   //if right child is larger(than largest so far) then change largest to right

		//if any of the above "if" block is executed then largest!=root
		if(largest!=root){ // If largest is not root, then make it root

			swap(largest,root);          //swap left/right whichever is larger with root
			heapify(arr,len,largest);   //changed root to largest
		} 
	}

	static void swap(int a, int b){   // no need to receive array as its static
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
}