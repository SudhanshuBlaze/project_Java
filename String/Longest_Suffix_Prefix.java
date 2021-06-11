// Time complexity: O(N)
// Space complexity: O(N)

class Longest_Suffix_Prefix{
	public static void main(String args[]){
		String pattern ="AAACAAAA";
		// String pattern = "ABABCABAB";
		// String pattern ="ABABCABAB";
		lps(pattern.toCharArray());
	}

	static void lps(char[] pattern){
		int N=pattern.length;
		int lps[]=new int[N];
		int i=1;  //moves linearly
		int slow_idx = 0;

		while(i<N){
			if(pattern[i]==pattern[slow_idx]){
				slow_idx++;
				lps[i]=slow_idx;
				i++;
			}
			//search for 
			else {
				if(slow_idx!=0){
					slow_idx=lps[slow_idx-1];
				}

				else{
					lps[i]=slow_idx;  //slow_idx=0
					i++;
				}
			}
		}
		System.out.println(lps[N-1]);
	}
}