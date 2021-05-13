class BinarySearchIter{
	public static void main(String[] args){
		int arr[] = {1,2,3,4,4,4,4,4,5,6,7};
		System.out.println(search(arr,0,arr.length-1,8));
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
}