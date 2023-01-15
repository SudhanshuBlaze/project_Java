class BinarySearch{
	public static void main(String[] args){
		int arr[] = {12,6,3,9,23,0};
		System.out.println(search(arr,0,arr.length-1,9));
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