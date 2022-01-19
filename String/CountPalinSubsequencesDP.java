class CountPalinSubsequencesDP{
	public static void main(String args[]){
		String str="abccbc";
		System.out.println("Count of Palin Substrings: "+ count(str));
	}
	static int count(String s){
		int dp[][]=new int[s.length()][s.length()];

		for(int d=0;d<s.length();d++){
			for(int i=0,j=d;j<s.length();j++,i++){
				if(d==0)
					dp[i][j]=1;
				else if(d==1){
					if(s.charAt(i)==s.charAt(j))
						dp[i][j]=3;
					else
						dp[i][j]=2;
				}
				else{
					if(s.charAt(i)==s.charAt(j))
						dp[i][j] = dp[i+1][j]+dp[i][j-1]+1;
					else
						dp[i][j] = dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];
				}
			}	
		}
		return dp[0][s.length()-1];
	}
}