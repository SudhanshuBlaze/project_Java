import java.util.*;

class TrappingRainWater {
	static int findWater(int arr[]){

		int lo=0,hi=arr.length-1,lmax=0,rmax=0,res=0;

		while(lo<=hi){
			if(arr[lo]<arr[hi]){
				if(arr[lo]>lmax)
					lmax=arr[lo];
				else
					res+=lmax-arr[lo];
				lo++;
			}
			else{
				if(arr[hi]>rmax)
					rmax=arr[hi];
				else 
					res+=rmax-arr[hi];
				hi--;
			}
		}
		return res;	
	}

	public static void main(String[] args)
	{
		int arr[] = { 0, 1, 0, 2, 1, 0, 1,3, 2, 1, 2, 1 };
		int n = arr.length;

		System.out.println("Maximum water that "+ "can be accumulated is "
						+ findWater(arr));
	}
}

