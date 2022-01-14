import java.util.*;
class ChocolateDistribution{
	public static void main(String args[]){
		// int arr[] = {3, 4, 1, 9, 56, 7, 9, 12};
		// System.out.println(findDiff(arr,arr.length, 5));

		int arr[]={7, 3, 2, 4, 9, 12, 56};
		System.out.println(findDiff(arr,arr.length, 3));

		// int arr[]={7, 3, 2, 4, 9, 12, 56};
		// System.out.println(findDiff(arr,arr.length, 2));
	}
	static long findDiff(int[] arr, int n, int m) {
		Arrays.sort(arr);
        
        int lo=0,hi=n-1;
        int niter=n-m;
        long min=Long.MAX_VALUE;
        while(niter-->0){
            if((arr[hi-1]-arr[lo])<(arr[hi]-arr[lo+1])){
                hi--;   
            }
            else{
                lo++;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Low: "+lo+ " hi: "+hi);
        return arr[hi]-arr[lo];
	}
}