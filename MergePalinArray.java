
class MergePalinArray {
	static int findMinOps(int[] arr) 
	{ 
		int lo=0, hi=arr.length-1,count=0;

		while(lo<hi){
			if(arr[lo]==arr[hi]){
				lo++;
				hi--;
			}
			//if lo is smaller then merge it with the number after it to increment it
			if(arr[lo]<arr[hi]){
				lo++;
				arr[lo]+=arr[lo-1];
				count++;
			}	
			//if hi is smaller then merge it with the number before it to increment it
			if(arr[hi]>arr[lo]){
				hi--;
				arr[hi]+=arr[hi+1];
				count++;
			}
		}

		return count; 
	} 
	public static void main(String[] args) 
	{ 
		int arr[] = new int[]{1, 4, 5, 9, 1} ; 
		System.out.println("Count of minimum operations is "+ 
								findMinOps(arr)); 
	
	} 
} 

