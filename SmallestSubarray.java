class SmallestSubarray{
	public static void main(String args[]){
		int arr[]={1, 4, 45, 6, 0, 19};
		System.out.println(smallSub(arr,51));
	}
	static int smallSub(int[] arr,int x){
		int sum=0,start=0,end=0,minLen=arr.length+1;

		while(end<arr.length){

			while(sum<=x && end<arr.length)
				sum+=arr[end++];
			while(sum>x){
				if(end-start<minLen)
					minLen=end-start;

				sum-=arr[start++];
			}
			
		}
		return minLen;
	}
}