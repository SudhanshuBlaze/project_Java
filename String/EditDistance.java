//Top down approach
import java.util.Arrays;
class EditDistance{
	public static void main(String args[]){
		String s1 = "geek";
		String s2 = "gesek";
		int dp[][] = new int[s1.length()][s2.length()];
		for(int row[]: dp)
			Arrays.fill(row,-1);

		System.out.println("Number of changes to be made: "+editDist(s1.toCharArray(),s2.toCharArray(),0,0,dp));
	}

	static int editDist(char[] s1, char[] s2,int i, int j,int dp[][]) {
		if(i>=s1.length) 
			return s2.length -j;

		if(j>=s2.length)
			return s1.length -i;

		if( dp[i][j]!=-1)
			return dp[i][j];
		if(s1[i]==s2[j])
			return dp[i][j]=editDist(s1,s2,i+1,j+1,dp);

		else
			return dp[i][j]=1+ Math.min(editDist(s1,s2,i,j+1,dp),
					Math.min(editDist(s1,s2,i+1,j+1,dp),editDist(s1,s2,i+1,j,dp)));
	}
}

// All these operations are done on s1

// editDist(s1,s2,i,j+1); //insert
// editDist(s1,s2,i+1,j+1);  //replace
// editDist(s1,s2,i+1,j); // remove