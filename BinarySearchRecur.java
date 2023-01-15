class BinarySearchRecur{
	public static void main(String[] args){
		int arr[]={1,7,7,7,7,10,12,14,19,20};  //sorted array
		System.out.println(search(arr,0,arr.length-1,7));
	}
	static int search(int arr[],int start,int end,int x){

		if(start<=end){

		int mid=start+(end-start)/2;
		if(arr[mid]==x)
			return mid;
		if(arr[mid]<x)
			return search( arr, mid+1, end, x);
		else if(arr[mid]>x)
			return search( arr, start, mid-1, x);
		}
			return -1;   //when number not found 
	}
}