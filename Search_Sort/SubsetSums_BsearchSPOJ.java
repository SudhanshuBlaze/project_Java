/*
determine the maximum sum subset having sum in the given range

Note: Spcl Case: lb<=0<=ub 
if there is in the range, then adding NO element also satisfies condition and gets counted
*/
import java.util.*;
class SubsetSums_BsearchSPOJ{
	
	// Find all possible sum of elements/subsets of a[] and store in x[]
	static ArrayList<Long> sumSubarray(long a[],ArrayList<Long> sub,int start, int end){
		int len=end-start;
		for(int i = 0; i < (1 << len); i++){
			long s = 0;
			for(int j = 0; j < len; j++)
				if ((i & (1 << j)) != 0){  // ()==0
					s += a[j + start];
				}					
			sub.add(s);
		}
		return sub;
	}

	// Returns the maximum possible sum less or equal to S
	static long solveSubsetSum(long a[], int n, long left, long right){
		ArrayList<Long> X=new ArrayList<Long>();
		ArrayList<Long> Y=new ArrayList<Long>();
		// Compute all subset sums of first and second halves
		X=sumSubarray(a, X, 0, n/2);
		Y=sumSubarray(a, Y,n/2, n);
		// Sort Y (we need to do doing binary search in it)
		Collections.sort(Y);
		System.out.println(X.toString());
		System.out.println(Y.toString());
		// To keep track of the maximum sum
		//of a subset such that the maximum sum is less than S
		
		// Traverse all elements of X and do
		// Binary Search for a pair in Y with maximum sum less than S.
		int count = 0;
		for(int i = 0; i < X.size(); i++){				
				// lower_bound() returns the first address which has value greater than 
				//or equal to left-X[i].
				int lb = lower_bound(Y, left - X.get(i));
				int ub=  upper_bound(Y,right-X.get(i));
				count +=ub -lb;	
		}
		// System.out.println(lower_bound(Y,1));
		return count;
	}

	static int upper_bound(ArrayList<Long> Y, long key){
		int N=Y.size();
		int low = 0;
		int high = N-1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (Y.get(mid)<=key)
				low = mid + 1;
			
			else 
				high = mid;
		}
		if(low < N && Y.get(low) <= key)
			low++;
	
		return low;
	}

	static int lower_bound(ArrayList<Long> Y, long key){
		int N=Y.size();
		int low = 0;
		int high = N-1;

		while (low < high) {
			int mid = low + (high - low) / 2;

			if (key <= Y.get(mid))
				high = mid;

			else 
				low = mid + 1;
		}
		if(low < N && Y.get(low) < key) {
		low++;
		}
		
		// Return the lower_bound index
		return low;
	}
	public static void main (String[] args){
		//spcl Case
		// long a[] = {1,2};  //1 ≤ N ≤ 34
		// int low=0, high=3;

		long a[] = {1,2};  //1 ≤ N ≤ 34
		int low=1, high=3;

		System.out.println("Count: "+solveSubsetSum(a,a.length,low,high));
	}
}
