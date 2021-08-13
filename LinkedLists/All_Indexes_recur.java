import java.util.*;
class All_Indexes_recur{
	public static void main(String args[]){
		int arr[] = {52,34,6,8,6,6,0};
		System.out.println(Arrays.toString(find(arr,6,0,0)));
	}
	static int[] find(int[] arr, int key, int i, int count) {
		if(i==arr.length){
			int res[]=new int[count];
			System.out.println(count);
			return res;
		}
		if(arr[i]==key){
			int res[]=find(arr,key,i+1,count+1);
			res[count] =i;
			return res;
		}
		else 
			return find(arr,key,i+1,count);
	}
}