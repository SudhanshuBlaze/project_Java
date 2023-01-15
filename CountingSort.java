import java.util.*;

class CountingSort{
	public static void main(String[] args){
		int arr[] = {7,1,3,9,1};
		sort(arr);
	}
	static void sort(int[] arr){
		int max=Arrays.stream(arr).max().getAsInt();
		int min=Arrays.stream(arr).min().getAsInt();

		int range=max-min+1;
		int keys[]=new int[range];
		int res[]=new int[arr.length];

		int i;
		for(i=0;i<arr.length;i++)    //creating keys
			keys[arr[i]-min]++;

		for(i=0;i<keys.length-1;i++)   //hashing(unique keys)
			keys[i+1]+=keys[i];
		System.out.println(Arrays.toString(keys));

			//placing the elements
		for(i=arr.length-1;i>=0;i--){  //iterating the from the end makes the algo a stable sorting algorithm 
			res[ keys[arr[i]-min] -1] =arr[i];   
			keys[arr[i]-min]--;
		}
		System.out.println(Arrays.toString(res));
		
	}
}