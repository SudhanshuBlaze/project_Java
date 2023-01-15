// Given: Sorted array or sort the array manually
class DiffPairTwoPointer{

	static boolean findPair(int arr[],int n){
		int size = arr.length;

		// Initialize positions of two elements
		int i = 0, j = 1;  //NOTE: this is the point from where we can control the diff value

		// Search for a pair
		while (i < size && j < size){
			if (i != j && (arr[j] - arr[i] == n || arr[i] - arr[j] == n)){
				System.out.print("Pair Found: "+
								"("+arr[i]+", "+ arr[j]+")");
				return true;
			}
			else if (arr[j] - arr[i] < n)
				j++;
			else
				i++;
		}

		System.out.print("No such pair");
		return false;
	}
	public static void main (String[] args){
		int arr[] = {1, 8, 30, 40, 100};
		int n = -60;
		findPair(arr,n);
	}
}