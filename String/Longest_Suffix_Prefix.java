// Time complexity: O(N)
// Space complexity: O(N)
import java.util.*;
class Longest_Suffix_Prefix{
	public static void main(String args[]){
		// String pattern ="AACBCBCBCBCCCC";
		// String pattern = "ABABCABAB";
		String pattern = "ABCABCABAB";
		// String pattern ="ABCCABAB";
		lps(pattern.toCharArray());
	}
//lps stands for longest proper prefix which is also suffix
	static void lps(char[] pattern){
		int N=pattern.length;
		int lps[]=new int[N];
		// 'i' starts from 1 because a string of signle char will have lps value of 1
		int i=1;  //moves linearly
		int slow_idx = 0;

		while(i<lps.length){
			if(pattern[i]==pattern[slow_idx]){
				// only increment slow_idx when there is a match because slow_idx is the value
				// of longest prefix and suffix
				slow_idx++;
				lps[i]=slow_idx;
				i++;
			}
			//search for previous pattern
			else {
				if(slow_idx!=0){
					slow_idx=lps[slow_idx-1];  //send slow_idx to previous step
				}
				// here, slow_idx=0, we can't send it back further
				else{
					lps[i]=slow_idx;  //slow_idx=0
					i++;
				}
			}
		}
		System.out.println(Arrays.toString(lps));
		System.out.println(lps[N-1]);
	}
}