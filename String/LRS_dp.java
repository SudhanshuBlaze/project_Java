import java.util.Arrays;

public class LRS_dp {

	static int findLongestRepeatingSubSeq(int dp[][],char X[], int m, int n) {

		// if the value already present
		if (dp[m][n] != -1) {
			return dp[m][n];
		}

		// return if we have reached the end of either string
		if (m == 0 || n == 0) {
			return dp[m][n] = 0;
		}

		// if characters at index m and n matches and index is different
		if (X[m] == X[n] && m != n) {
			return dp[m][n] = findLongestRepeatingSubSeq(dp,X,m - 1, n - 1) + 1;
		}

		// else if characters at index m and n don't match
		else{
			int left=findLongestRepeatingSubSeq(dp,X, m - 1, n);
			int right=findLongestRepeatingSubSeq(dp,X, m, n - 1);
			return dp[m][n] = Math.max(left,right);
		}
	}

	static public void main(String[] args) {
		String str = "aabab";  //ab,ab, len=2
		int m = str.length();
		int dp[][]=new int[m][m];

		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		System.out.println("The length of the largest subsequence that"
				+ " repeats itself is : "
				+ findLongestRepeatingSubSeq(dp,str.toCharArray(), m-1, m-1));

	}
}
