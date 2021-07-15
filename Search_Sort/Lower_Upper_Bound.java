class Lower_Upper_Bound{
	static int lower_bound(int arr[], int N, int X){

		// Initialise starting index and ending index
		int low = 0;
		int high = N-1;

		while (low < high) {
			int mid = low + (high - low) / 2;

			if (X <= arr[mid])
				high = mid;

			else 
				low = mid + 1;
		}
		// if X is greater than arr[n-1]
		if(low < N && arr[low] < X) {
		low++;
		}
		
		// Return the lower_bound index
		return low;
	}

	// Function to implement upper_bound
	static int upper_bound(int arr[], int N, int X){
		int low = 0;
		int high = N-1;

		//Note: Till low is less than high
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (arr[mid]<=X)
				low = mid + 1;
			
			else 
				high = mid;
		}
		// if X is greater than arr[n-1]
		if(low < N && arr[low] <= X)
			low++;
	
		return low;
	}


	// Driver Code
	public static void main(String[] args){
		int arr[] = { 4,6, 10, 12, 18, 20 ,20};
		int N = arr.length;

		// Element whose lower bound and upper bound to be found
		int X = 6;
		System.out.println(lower_bound(arr, N, X));
		System.out.println(upper_bound(arr, N, X));
	}

}