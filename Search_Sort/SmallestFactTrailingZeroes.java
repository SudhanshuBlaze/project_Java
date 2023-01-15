/*
Given a number n. The task is to find the smallest number whose factorial contains at least n trailing zeroes.

Time complexity: O(log2 N * log5 N).
*/
class SmallestFactTrailingZeroes{
	public static void main(String args[]){
		int numOfZeroes = 6;
		System.out.println(findNum(numOfZeroes));
	}
	static int findNum(int numOfZeroes){
		int low=0, high=numOfZeroes*5;
		int res=-1;
		while(low<= high){
			int mid= low + (high-low)/2;
			
			if(isValid(mid, numOfZeroes)){
				res =mid;
				high=mid-1;
			}
			else
				low=mid+1;
		}
		return res;
	}

	static boolean isValid(int currFact,int reqdZeroes){
		int cntFive =0;
		//Ex: currFact=25, cnt+=25/5 -> cnt=5; cnt+=25/25 -> cnt=6
		for (int i=5; currFact/i>=1; i*=5){
			cntFive+=currFact/i;
		}
		if(cntFive<reqdZeroes)
			return false;
		return true;
	}
}







