import java.util.*;

class MinAbsDiff{
	public static void main(String[] args){
		int arr[] = {5,4,3,2,1};
		ArrayList<Integer> res= func(arr);
		for(int e :res)
			System.out.print(e+" ");
	}

	static ArrayList<Integer> func(int arr[]){
		ArrayList<Integer> list=new ArrayList<>();

		int min=Integer.MAX_VALUE;
		int curr_value;
		Arrays.sort(arr);
		for(int i=0;i<arr.length-1;i++){
			curr_value=Math.abs(arr[i]-arr[i+1]);
			min=Math.min(min,curr_value);
		}
		for(int i=0;i<arr.length-1;i++){
			if(Math.abs(arr[i]-arr[i+1])==min);
			list.add(arr[i]);
			list.add(arr[i+1]);
		}
		return list;
	}
}