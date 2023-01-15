// basically we will be finding index of minimum number in the array, as it is equal to the number of rotations
// ex: [6,7,1,2,3,4,5] , number of rotations are 2, 1 is at index of 2

class Rotation_nums{

	public static void main(String[] args) {
		int arr[] = {6,7,1,2,3,4,5};
		System.out.println(func(arr,0,arr.length-1));
	}
	static int func(int[] arr, int low,int high){

		int N=arr.length;
		int next,prev,mid;
		while(low<=high){  
			mid= low+(high-low)/2;

			if(arr[low]<=arr[high])   
				return low;

			next= (mid+1)%N;    //to avoid negative indexing we are using this formula
			prev= (mid-1+N)%N;
			if(arr[mid]<=arr[next] && arr[mid]<=arr[prev])  // previous and next element of the pivot(smallest element) are always greater 
				return mid; 

			else if(arr[mid]<=arr[high])
				high=mid-1;
			else if(arr[low]<=arr[mid])
				low=mid+1;
		}
		return -1;

	}	


}