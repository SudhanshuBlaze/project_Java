import java.util.*;
class KMP{
	public static void main(String args[]){
		String txt = "AAAAAAAAAAAAAAAAAB";
   		String pat = "AAAB";

   		KMPsearch(txt,pat);
	}

	static void KMPsearch(String txt, String pat){
		int lps[]=new int[pat.length()];
		lps(pat.toCharArray(), lps);

		int i=0, j=0;

		while(i<txt.length()){
			if(txt.charAt(i)==pat.charAt(j)){
				i++;
				j++;
			}

			if(j==pat.length()){
				System.out.println("Pattern found at: " +(i-j));
				j=lps[j-1];
			}
			else if(i<txt.length() && txt.charAt(i)!=pat.charAt(j)){
				if(j!=0)
					j=lps[j-1];
				else
					i++;
			}
		}
		System.out.println(Arrays.toString(lps));

	}

	static void lps(char[] pattern , int lps[]){
		// 'i' starts from 1 because a string of signle char will have lps value of 1
		int i=1;  //moves linearly
		int slow_idx = 0;  //slow_idx is also the current answer

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
				//here, slow_idx=0, we can't send it back further
				else{
					lps[i]=slow_idx;  //slow_idx=0
					i++;
				}
			}
		}
	}
}