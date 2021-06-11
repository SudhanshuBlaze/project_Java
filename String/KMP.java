import java.util.*;
class KMP{
	public static void main(String args[]){
		String txt = "AAAAAAAAAAAAAAAAAB";
   		String pat = "AAAAB";

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
		int i=1;  //moves linearly
		int slow_idx = 0;

		while(i<lps.length){
			if(pattern[i]==pattern[slow_idx]){
				slow_idx++;
				lps[i]=slow_idx;
				i++;
			}
			//search for previous pattern
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
	}
}