import java.util.*;

class ClosestNums{
	public static void main(String[] args){
		int arr[] = {5,4,3,2,1};
		System.out.println(Arrays.toString(func(arr)));
	}
	static int[] func(int arr[]){
		Arrays.sort(arr);
		return arr;
	}

}