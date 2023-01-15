/*
AP series: a+d, a+2d, a+3d, ...
Nth term = a + (n - 1) d,
a is first term, d is common difference, n is the nth term

Approach: Calculate mid, 
	if mid is equal to the expected mid of the progression then upto this point(mid), 
	the progression is correct, look in right half

	else if mid is not equal to the expected mid of the progression, 
	then some number os missing on the left half-> look in left half
*/
class APMissingNum{
	public static void main(String args[]){
		int series[]  = {1, 6, 11, 16, 21, 31};
		System.out.println(findMissingNum(series, series.length));
	}

	static int findMissingNum(int[] series, int n){
	//calculate common difference
		int d=(series[n-1]-series[0])/n;
		int a=series[0];
		int low=0, high=n-1;
		while(low<= high){
			int mid=(low + high)>>1;
			if(mid>0 && series[mid]!= series[mid-1]+d)
				return series[mid]-d;

			else if(series[mid]!= series[mid+1]-d)
				return series[mid]+d;

			else if( a+mid*d == series[mid] )
				low =mid+1;
			else
				high = mid-1;
		}
		return -1;
	}
}