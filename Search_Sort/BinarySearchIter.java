class BinarySearchIter{
	public static void main(String[] args){
		int arr[] = {1,2,2,4,4,4,4,4,5,7,9};
		// System.out.println(search(arr,0,arr.length-1,3));
		System.out.println(smallerElement(arr,0,arr.length-1,8));
	}
	static int search(int arr[],int low,int high,int x){
		while(low <= high){
			int mid = low + (high-low)/2;  // to avoid stack overflow
			if(arr[mid]==x)
				return mid;
			else if(arr[mid]<x)
				low=mid+1;
			else 
				high=mid-1;
		}
		return -1;
	}

/*Approach: When you want the smaller number or equal number than the key then return high,
else return low if you want the greater number than the key. Reason: the loop ends when 
low and high crosses each other, so high goes to the key or the number which is smaller than key,
as in this condition 'arr[mid]==x' in this condition, we are incrementing 'low' in order to
search for same number present later in the array(returns last occurence)

*/

	static int smallerElement(int arr[],int low,int high, int x){
		int mid=-1;
		while(low <= high){
			mid = low +(high-low)/2;
			if(arr[mid]==x){
				low = mid+1;
			}
			else if(arr[mid]<x){
				low = mid+1;
			}
			else{
				high = mid-1;
			}
		}
		return high;
	}
}