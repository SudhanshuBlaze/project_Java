/*Top Down approach
Time Complexity: O(N^2), further can be optimzied by removing multiple adjacent '*' */


import java.util.*;
class WildCardPattern_II{
	 public static void main(String args[]){
        String str = "baaabab";
        // String pattern = "*****ba*****ab";
        // String pattern = "aa?ab";
        String pattern = "b*b";
        // String pattern = "a*a";
        // String pattern = "baaabab";
        // String pattern = "?baaabab";
        // String pattern = "*baaaba*";

        System.out.println(strmatch(str, pattern));
    }

    static boolean strmatch(String str, String pattern){
    	boolean dp[][]=new boolean[pattern.length()+1][str.length()+1];//extra space for blank string-> ""

    	for(int i=0;i<dp.length;i++){
    		for(int j=0;j<dp[0].length;j++){
    			if(i==0 && j==0)
    				dp[i][j] =true;
    			else if(i==0)
    				dp[i][j] =false;
    			/*it's important to to fill the last row first then, column
                because it pattern.s.charAt(i) will give out of bounds because,
                value of i will go upto 1 greater than the pattern length due to '-'*/
    			else if(j==0){
    				if(pattern.charAt(i-1)=='*')
    					dp[i][j] =dp[i-1][j]; //depends upon previous
    				else
    					dp[i][j] =false;
    			}
    			else{

    				if(pattern.charAt(i-1)=='?')
    					dp[i][j] =dp[i-1][j-1];

    				else if(pattern.charAt(i-1)=='*')
    					dp[i][j] =dp[i][j-1] || dp[i-1][j];

    				else if(pattern.charAt(i-1)==str.charAt(j-1))
    					dp[i][j] =dp[i-1][j-1];
    				else
    					dp[i][j]=false;
    			}
    		}
    	}
    	return dp[dp.length-1][dp[0].length-1];
    }
}