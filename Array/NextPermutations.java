// 1,5,4,3,2
// 2,1,3,4,5

// 4,3,2,1

import java.util.Arrays;
class NextPermutations{
	public static void main(String args[]){
		// int arr[]={1, 2, 3, 6, 5, 4};
		// int arr[] = {4,3,2,1};
		nextGreater(arr);
	}
	static void nextGreater(int arr[]){
		int pos=-1;   //if the entire array is in descending order then reverse entire array
		int n = arr.length;
		// find first element smaller than its previous
		for(int i=n-1;i>0;i--){
			if(arr[i]>arr[i-1]){
				pos=i-1;
				break;
			}
		}
		//finding and swapping the smaller element with the first element,
		// which is greater(from end)
		for(int i=n-1;pos!=-1 && i>pos;i--){
			if(arr[i]>arr[pos]){
				swap(arr,i,pos);
				break;
			}
		}
		//reverse rest elements from pos
		for(int k=n-1, i=pos+1; k>=(n+pos+1)/2 && i<=(n+pos+1)/2;i++,k--){
			swap(arr,i,k);
		}
		System.out.println(Arrays.toString(arr));
	}
	static void swap(int[] arr,int a, int b){
		int tmp=arr[a];
		arr[a]=arr[b];
		arr[b]=tmp;
	}
}