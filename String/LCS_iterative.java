
import java.util.*;
//Top-down approach
public class LCS_iterative{
	static int lcs( char[] X, char[] Y, int m, int n ){
		int dp[][] = new int[m+1][n+1];
  
    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
    for (int i=0; i<dp.length; i++){
      for (int j=0; j<dp[0].length; j++){
      	//if anyone of the string is empty then return 0.
        if (i == 0 || j == 0)
            dp[i][j] = 0;   //fill first row and column with '0', we need it for comparison(padding)
        
        //i=1,j=1, but we need to start from 0 for string
        else if (X[i-1] == Y[j-1]) //if there is a match, then increment the new number with 1(memoization)
            dp[i][j] = dp[i-1][j-1] + 1;
        else
        	// continue the greatest value onto the next cell
            dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); // since we want longest, so we have to always take the greater value 
      }
    }
    printDP(dp,X,Y);

    return dp[m][n];
	}

	static void printDP(int dp[][],char[] X, char[] Y){
		System.out.println("\t Our DP array: \n");
    	System.out.print("  - "+Arrays.toString(Y)+"\n");
		int k=0;
    	for (int[] row : dp){
    		if(k==0)
            	System.out.println("-"+Arrays.toString(row));
            else
            	System.out.println(Arrays.toString(row));
            if(k<X.length)
    			System.out.print(X[k]);
            k++;
        }
	}

	public static void main(String[] args)
	{
		String s1 = "STROING";
		String s2 = "LONGEST";

		char[] X=s1.toCharArray();
		char[] Y=s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		System.out.println("\nLength of LCS is" + " " +
									lcs( X, Y, m, n ) );
	}

}
