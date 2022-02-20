// Java program to search an element in an array where difference between all
// elements is 1

import java.io.*;

class StepArray_I {
	static int search(int arr[], int N, int key){
		for(int i= 0;i<N;i++){
			// if(arr[i]<key){
				// i+= key-arr[i];
			// }
			// else if(arr[i]>key){
			// 	i+=arr[i]-key;
			// }
			if(arr[i]!=key)
				i+=Math.abs(arr[i]-key);
			if(arr[i]==key)
				return i;
		}
		return -1;
	}

	public static void main (String[] args) {
		int arr[] = {8 ,7, 6, 7, 6, 5, 4, 3, 2, 3, 4, 3 };
		int N = arr.length;
		int key = 3;
		System.out.println("Element " + key +" is present at index "+ search(arr,N,3));
	}
}

