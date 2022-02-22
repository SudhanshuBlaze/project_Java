/*No Duplicate elements should be present
Pivot element property-> 1) Next and previous elements both are greater, 2) Minimum element
*/
class PivotInRotatedArrBsearch{
	public static void main(String [] args) {
		// int[] arr = {6,1,3,4,5};
		int [] arr={3,4,5,1,2};
		System.out.println(findPivot(arr, arr.length));
	}
	static int findPivot(int[] arr, int N){

		int mid=-1, low=0, high=arr.length-1;
		while(low <= high){
			mid = low +(high-low)/2;
			/*We are using '%N' in case of just 'mid-1' and 'mid+1', 
			to prevent index out of bounds when 'mid' iw either at 0 or at N*/
			int next= (mid+1)%N;
			int prev= (mid-1+N)%N;
			
			// we are removing the sorted part of array, if the below condition is true,
			// then we are reduces the array to sorted array. ex: [6,"1,3",4,5]
			// if(arr[low]<=arr[high]){
			// 	System.out.println("Returned low pointer\n"+"low: "+low+" high: "+high);
			// 	return low;
			// }
			// else
			 if(arr[prev]>arr[mid] && arr[mid]< arr[next]){
				System.out.println("Returned mid pointer");
				return mid;
			}

			else{
				// we are also checking for the equality of the mid element because 
				//if low=mid or high=mid, then we still want to move one step to avoid
				// getting into infinity loop
				if(arr[mid]<=arr[high])
					high=mid-1;
				else if(arr[mid]>=arr[low])
					low=mid+1;
			}
		}
		return mid;
	}
}