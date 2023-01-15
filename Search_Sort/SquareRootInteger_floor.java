 class SquareRootInteger_floor{
	public static int floorSqrt(int x){
		// Base Cases
		if (x == 0 || x == 1)
			return x;		

		//define search space
		int low=1, high=x/2,res=-1;
		while(low<= high){
			int mid=(low+high)/2;
			if(mid*mid==x)
				return mid;
			else{
				if(mid*mid<x){
					res=mid;  //this will store the floor value of sqrt(n)
					low=mid+1;
				}
				else{
					high=mid-1;
				}
			}
		}
		return res;
	}

	// Driver Method
	public static void main(String args[])
	{
		int x = 11;
		System.out.println(floorSqrt(x));
	}
}
