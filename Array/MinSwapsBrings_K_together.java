class MinSwapsBrings_K_together{
	public static void main(String args[]){
		int arr[] = {2, 7, 9, 5, 8, 7, 4};
		System.out.println(getMinSwaps(arr,5));
	}
	//sliding window technique, we'll take a window of size of number of elements 
	// less than equal to k, then we'll slide the window from left to right keeping
	// the count of 'bad' elements in each window. 'Bad' elements refers to elements
	// which are not less than or equal to 'k' and needs to be swapped.
	static int getMinSwaps(int[] arr, int k){
		int bad = 0,good=0, minSwaps=0;
		// here we determine the size of window(or the number of good elements)
		for(int i=0;i<arr.length;i++)
			if(arr[i]<=k)
				good++;
		// mumber of bad elements in the initial window
		for(int i=0;i<good;i++)
			if(arr[i]>k)
				bad++;
		// 'j' starts from the first element outside the window
		int i=0,j=good;
		minSwaps=bad;
		while(j<arr.length){
			if(arr[i]>k)
				bad--;
			if(arr[j]>k)
				bad++;
			if(minSwaps>bad)
				minSwaps=bad;
			i++;
			j++;
		}
		return minSwaps;
	}

}