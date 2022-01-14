// Using memoization
import java.util.*;
class LongPalinSubsequence_Recursive{
	public static void main(String[] args){
		String str="aabcbcdbca";  //-> abcbcba (7)
		// String str="bba";
		int dp[][] = new int[str.length()][str.length()];
		for( int rows[]: dp)
			Arrays.fill(rows,-1);
		System.out.println(getLps(str,0,str.length()-1, dp));
	}

	static int getLps(String str, int lo, int hi, int [][] dp){
		// not chars are left in a string to CHECK
		if(lo==hi)
			return 1;
		// when there's no char in between. EX: ab -> so no further function calls hence we 
		// return from right here
		if(dp[lo][hi]!=-1)
			return dp[lo][hi];

		if(str.charAt(lo)==str.charAt(hi) && lo+1==hi)
			return 2;
		// if match is found then continue the search for inner substrings EX: a....a
		if(str.charAt(lo)==str.charAt(hi))
			return dp[lo][hi]= 2+getLps(str,lo+1,hi-1,dp);

		// if match is not found, then keep branching
		else
			return Math.max(getLps(str,lo+1,hi, dp),getLps(str,lo,hi-1, dp));
			// return getLps(str,lo+1,hi)+getLps(str,lo,hi-1); //use this to get count of PalinSubs
		
		//        L(0, 5)
  //            /        \ 
  //           /          \  
  //       L(1,5)          L(0,4)
  //      /    \            /    \
  //     /      \          /      \
  // L(2,5)    L(1,4)  L(1,4)  L(0,3)
	}
}



// adbc
// ac, ab,dc