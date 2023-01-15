// Counting First and Last Occurrence of a number : O(log(n))
// Whenever you have a sorted array think in terms of Binary Search

class Occurrence_of_a_num{

	public static void main(String[] args){
		int arr[] = {1,1,1,2,3,4,5,5,5,5,6,7,8,9,11};
		int x=1;
		int first_occur =search(arr,0,arr.length-1,x,true);
		if(first_occur==-1)
			System.out.println("No occurence");
		else{
		int last_occur  =search(arr,0,arr.length-1,x,false);
		System.out.println(last_occur-first_occur+1);
		}
	}

	static int search(int arr[], int low, int high,int x,boolean flag){

		int result=-1;     	 //if element not found then return -1
		while(low<=high){
			int mid= low+(high-low)/2;

			if(arr[mid]==x){
				result=mid;      //store the previous the answer
				if(flag)
					high=mid-1;    // searching starts again in left sub_array(first occurence)
				else 
					low=mid+1;     // searching starts again in right sub_array(last occurence)
			}
			
			else if(arr[mid]<x)
				low=mid+1;
			else
				high=mid-1;
		}
		return result;
	}
}