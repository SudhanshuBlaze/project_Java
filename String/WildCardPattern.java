import java.util.*;
class WildCardPattern{
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

    	for(int i= dp.length-1; i>=0; i--){
    		for(int j=dp[0].length-1; j>=0; j--){
    			//Tracing the edges
    			if(i==dp.length-1 && j==dp[0].length-1)//last cell
    				dp[i][j] =true;
    			else if(i==dp.length-1) //last row
    				dp[i][j] =false;
    			else if(j==dp[0].length-1){ //last column
    				//if there was "*" just above the last cell
    				if(pattern.charAt(i)=='*') 
    					dp[i][j] =dp[i+1][j];  //take bottom element
    				else
    					dp[i][j] =false;
    			}
    			//the Main part
    			else{
    				if(pattern.charAt(i)=='?')
    					dp[i][j] =dp[i+1][j+1];

    				else if(pattern.charAt(i)=='*')
    					dp[i][j]= dp[i+1][j] || dp[i][j+1];
    				
    				else if(pattern.charAt(i)==str.charAt(j)) //if chars match
    					dp[i][j] =dp[i+1][j+1];
    				else
    					dp[i][j]=false; //chars don't match
    			}

    		}
    	}
    	return dp[0][0];
    }
}