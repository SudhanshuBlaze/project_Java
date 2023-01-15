/*
determine the maximum sum subset having sum less than or equal S
*/
import java.util.*;
class MeetInTheMiddle{
	
	// Find all possible sum of elements/subsets of a[] and store in x[]
	static ArrayList<Long> calcsubarray(long a[],ArrayList<Long> sub,int start, int end){
		int len=end-start;
		for(int i = 0; i < (1 << len); i++){
			long s = 0;
			for(int j = 0; j < len; j++)
				if ((i & (1 << j)) == 0){  // ()!=0
					s += a[j + start];
				}					
			sub.add(s);
		}
		return sub;
	}

	// Returns the maximum possible sum less or equal to S
	static long solveSubsetSum(long a[], int n, long S){
		ArrayList<Long> X=new ArrayList<Long>();
		ArrayList<Long> Y=new ArrayList<Long>();
		// Compute all subset sums of first and second halves
		X=calcsubarray(a, X, 0, n/2);
		Y=calcsubarray(a, Y,n/2, n);
		
		int size_X = 1 << (n / 2);
		int size_Y = 1 << (n - n / 2);
		
		// Sort Y (we need to use binary search on it)
		Collections.sort(Y);
		
		// To keep track of the maximum sum
		//of a subset such that the maximum sum is less than S
		long max = 0;
		
		// Traverse all elements of X and do
		// Binary Search for a pair in Y with maximum sum less than S.
		for(int i = 0; i < size_X; i++){
			if (X.get(i) <= S){
				
// lower_bound() returns the first address which has value greater than or equal to S-X[i].
				int cnt = lower_bound(Y, S - X.get(i));
		
/*If S-X[i] was not in array Y then decrease p by 1, because if the same value is not 
present then the lower bound returns the greater value, but we don't want the greater value
 as it will exceed the limit of <=S*/
				if (cnt == size_Y || Y.get(cnt) != (S - X.get(i)))
					cnt--;
		//update max elements which is less than or equal to S
				if (Y.get(cnt) + X.get(i) > max)
					max = Y.get(cnt) + X.get(i);
			}
		}
		return max;
	}

	static int lower_bound(ArrayList<Long> Y, long key){

		// Initialise starting index and ending index
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
		// if key is greater than arr[n-1]
		if(low < N && Y.get(low) < key) {
		low++;
		}
		
		// Return the lower_bound index
		return low;
	}
	public static void main (String[] args){
		long a[] = { 3, 34, 4, 12, 5, 2 };
		// long a[] ={1,3,5};
		int n = a.length;
		long S = 10;
		System.out.println("Largest value smaller " +"than or equal to given " +"sum is " +
						solveSubsetSum(a, n, S));
	}
}
