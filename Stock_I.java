class Stock_I{
	public static void main(String[] args) 
	{ 
		int arr[] = {20,12,3,10,6,1}; 
		int size = arr.length; 
		System.out.println("MaximumDifference is " + maxDiff(arr, size)); 
	} 
	static int maxDiff(int arr[], int size) {
		int min_value =Integer.MAX_VALUE;  //keep track of new min value and calculate diff with it.
		int max_diff = Integer.MIN_VALUE; 

		for(int i=0;i<arr.length;i++) {
			if(arr[i] < min_value)
				min_value=arr[i];
			else if(arr[i]-min_value>max_diff)
				max_diff=arr[i]-min_value;
		}
		if(max_diff<=0)  // Not possible
			return 0;
		else
			return max_diff;
	}
}