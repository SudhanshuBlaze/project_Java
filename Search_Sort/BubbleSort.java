import java.util.*;

class BubbleSort{
	public static void main(String[] args){
		int arr[] = {12,21,4,45,46,543,4,32};
		int i,j,temp;

		for(i = 0;i<arr.length-1;i++){		  // with every iteration it takes max number to end,
			for(j = 0;j<arr.length-i-1;j++){   // last number is not to be checked 
				if(arr[j]>arr[j+1]){
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			// System.out.println(Arrays.toString(arr));
		}
		System.out.println(Arrays.toString(arr));
	}
}