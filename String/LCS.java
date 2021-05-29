import java.util.Arrays;
public class LCS{

	static int lcs( char[] s1, char[] s2, int i, int j,int dp[][] ){

		if(i>=s1.length || j>=s2.length)
			return 0;

		else if(dp[i][j]!=-1)
			return dp[i][j];
		
		else if(s1[i]==s2[j]){
			return 1+lcs(s1,s2,i+1,j+1,dp); //increment both if there is a match
		}
		else{
			int left=lcs(s1,s2,i+1,j,dp);
			int right=lcs(s1,s2,i,j+1,dp);
			return dp[i][j]= Math.max(left,right);
		}
	}

	public static void main(String[] args){
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";
		int dp[][]=new int[s1.length()+1][s2.length()+1];

		for (int[] row : dp)
            Arrays.fill(row, -1);

		char[] X=s1.toCharArray();
		char[] Y=s2.toCharArray();
		int i=0, j=0;

		System.out.println("Length of LCS is" + " " +
									lcs( X, Y, i, j, dp ) );

		for (int[] row : dp)
            System.out.println(Arrays.toString(row));
	}
}
