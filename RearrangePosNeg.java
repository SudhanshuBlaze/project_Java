
import java.util.*;
class RearrangePosNeg{
	public static void main(String[] args){
		int arr[]={-5, 3, 4, 5, -6, -2, 8, 9, -1, -4};
		arrange(arr);
	}
	static void arrange(int arr[]){
		int i,slow_idx=0;

		//puts all the neg numbers to side of array and pos numbers to another
		for(i=0;i<arr.length;i++){
			if(arr[i]>0){
				swap(arr,slow_idx,i);
				slow_idx++;
			}
		}
		int k=0;
		System.out.println(Arrays.toString(arr)+", idx= "+slow_idx);

		while(k<arr.length && slow_idx<arr.length){
			swap(arr,k,slow_idx);
			k=k+2;
			slow_idx++;
		}

		System.out.println("Re-arranged array"+Arrays.toString(arr));
	}


	static void swap(int arr[],int a,int b) {
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
}