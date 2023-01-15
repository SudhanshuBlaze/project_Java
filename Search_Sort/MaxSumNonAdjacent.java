//DP approach: O(N), O(1)
import java.util.*;
class MaxSumNonAdjacent{
	public static void main (String [] args) {
		int arr[] = {6, 7, 1, 3, 8, 2, 4};
		// System.out.println(maxLootDP(arr));
		System.out.println(maxLootGreedy(arr));
	}

	static int maxLootGreedy(int arr[]){
		if(arr.length==1)
            return arr[0];
        if(arr.length==2)
            return Math.max(arr[0],arr[1]);
        int a=arr[0],b =arr[1] ,c=arr[0]+ arr[2],d=c;
        
        for(int i=3;i<arr.length;i++){
			d=arr[i]+ Math.max(a,b);
			a=b;
			b=c;
			c=d;
		}
		return Math.max(b,d);
	}




	static int maxLootDP(int arr[]){
		if(arr.length==1)
            return arr[0];
        if(arr.length==2)
            return Math.max(arr[0],arr[1]);
        
        int dp[]=new int[arr.length];
		dp[0]=arr[0];
		dp[1]=arr[1];
		dp[2]=arr[0]+arr[2];

		for(int i=3;i<arr.length;i++){
			dp[i]=arr[i]+ Math.max(dp[i-2],dp[i-3]);
		}
		return Math.max(dp[dp.length-2] ,dp[dp.length-1]);
	}

}