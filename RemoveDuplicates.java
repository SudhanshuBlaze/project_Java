import java.util.*;
class RemoveDuplicates{
	public static void main(String[] args){
		int arr[] = {100,100,90,80,40,40};
		remove(arr);
	}
	static void remove(int arr[]){

		ArrayList<Integer> res=new ArrayList<Integer>();
		res.add(arr[0]);
		for(int i=1;i<arr.length;i++){
			if(arr[i]!=arr[i-1])
			res.add(arr[i]);
		}
		System.out.println(res);
	}
}