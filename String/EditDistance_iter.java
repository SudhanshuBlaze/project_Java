//Top down approach, but bottom up approach is preferred
import java.util.*;
class EditDistance_iter{

	public static void main(String args[]){

		String str1 = "gesek";
		String str2 = "geek";
		System.out.println("\n Min Ops: "+computeMinDistance(str1, str2));
	}

	static int computeMinDistance(String str1, String str2){
		int dp[][]=new int[str1.length()+1][str2.length()+1];
		int i,j;

		for(i=0;i<=str1.length();i++){
			for(j=0;j<=str2.length();j++){
//if anyone of the string is null-> '-' , then it will either delete all or insert all
				if(i==0)
					dp[i][j]=j;
				else if(j==0)
					dp[i][j]=i;
				else {
					if(str1.charAt(i-1)==str2.charAt(j-1))
						dp[i][j] =dp[i-1][j-1];
					else
						dp[i][j] =1+ Math.min(dp[i-1][j],Math.min(dp[i-1][j-1], dp[i][j-1]));
				}
			}
		}
		printDP(dp, str1.toCharArray(),str2.toCharArray());
		return dp[dp.length-1][dp[0].length-1];
	}
	static void printDP(int dp[][],char[] X, char[] Y){
		System.out.println("Our DP array for converting str1 to str2: \n");
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
}