import java.util.*;
class Find_MissingRepeating{

	public static void main(String [] args){
		// int arr[] = {4, 3, 6, 2, 1, 1};
		int arr[] = {1,3,3};
		find(arr);
	}
	static void find(int arr[]){
		int len = arr.length;
		for(int i = 0; i < len; i++){
			arr[arr[i]%len] = arr[arr[i]%len]+(len*2);
		}
		for (int i =0;i<len;i++){
			if(arr[i]/(len*2)==0 || arr[i]/(len*2) >1){
				if(i==0)
					System.out.println(i+len);
				else
					System.out.println(i);
			}
			// System.out.println("value: "+ arr[i] +" Freq of "+i+" is: " + arr[i]/(len*2));
		}
		System.out.println(Arrays.toString(arr));
	}

}