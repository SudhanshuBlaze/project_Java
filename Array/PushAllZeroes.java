import java.util.Arrays;
class PushAllZeroes{
	public static void main(String[] args){
		int arr[]={2,0,0,3,1,0};
		System.out.println(Arrays.toString(sort(arr)));
	}

	public static int[] sort(int [] arr){
		int slow_idx=-1;
		for(int i=0; i<arr.length; i++){	
			if(arr[i]!=0){
				slow_idx++;
				swap(arr,slow_idx,i);
			}
		}
		return arr;
	}
	static void swap(int[] arr,int a, int b){
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
}