/*
Pre-requisites: AP series, Tn= a+(n-1)d,
In this case value of 'd' is 2, as -> p1->R, p2->2R, p3->3R, p4->4R minutes

For example if a cook is ranked 2.. he will cook one prata in 2 minutes one more prata in the next 4 mins an one more in the next 6 minutes hence in total 12 minutes he cooks 3 pratas in 13 minutes also he can cook only 3 pratas as he does not have enough time for the 4th prata

Time complexity: O(N*log(1e8))
*/
import java.util.*;
class ROTI_PRATA{

	static long calculateTime(int arr[], int k){
		long low=0, high=(long)1e8;
		long res=-1;
		while(low<= high){
			
			long mid=low +(high-low)/2;
			if(allocateCooks(arr, mid, k)){
				res=mid;
				high=mid-1;
			}
			else
				low=mid + 1;
		}
		return res;
	}
	static boolean allocateCooks(int arr[], long barrierTime, int reqdParatha){
		int currParatha=0;
		for(int i=0;i<arr.length;i++){
			
			//d-> common difference
			int time=arr[i], d=2;

			while(time<=barrierTime){
				time+=arr[i]*d;
				d++;
				currParatha++;
			}
		}
		if(currParatha<reqdParatha)
			return false;
		return true;
	}

	public static void main(String [] args){
		int prathas=10;
		int rank[]={1, 2, 3, 4};

		//  int prathas=8;
		// int rank[]={1};
		System.out.println(calculateTime(rank, prathas));
	}
}



