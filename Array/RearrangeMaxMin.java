// 1,2,3,4 -> 4,1,3,2
import java.util.*;
class RearrangeMaxMin {
	// sorted array
	public static void rearrange(int arr[], int n){
		int minIdx=0, maxIdx=n-1;
		int maxVal=arr[n-1]+1;

		for(int i=0; i<arr.length; i++){
			if(i%2 == 0){
				arr[i]+= (arr[maxIdx]%maxVal)*maxVal;
				maxIdx--;
			}
			else if(i%2 == 1){
				// we multiply by maxVal so to get the new value we have to divide by maxVal
				// and to get the original/old value we do %
				arr[i]+= (arr[minIdx]%maxVal)*maxVal;
				minIdx++;
			}
		}
		for(int i=0; i<arr.length; i++){
			arr[i] /= maxVal;
		}

	}
	public static void main(String args[]){
		int arr[] = { 1, 3, 4,7,9,0
	};
		int n = arr.length;

		rearrange(arr, n);

		System.out.print(Arrays.toString(arr));
	}
}