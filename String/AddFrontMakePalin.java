/*Approach we are reversing the string and appending it in the last because,
we want to see what 'pattern' remains the same even after reversing, 
this is computed with the help of lps, we have to find out
how much starting portion of string is already in palindrom, ex: BCBA, because, 
its useless if later part is palindrome, ex: ABCB, 

So we reverse the string and add it in the behind such that the starting palindrome part of 
first string will be equal to its last portion which is also palindromic, pattern is matched here,
and lps returns the number of char which is matched
*/

import java.util.*;
class AddFrontMakePalin{

	public static void main(String args[]){
		// String s="CBABC";
		String s="BCBA$ABCB";
		System.out.println(makePalin(s));
	}

	static int makePalin(String s){
		StringBuilder sb = new StringBuilder(s);

		String rev= sb.reverse().toString();
		sb.reverse().append("$").append(rev);
		System.out.println("Processed string: "+ sb.toString());
		return s.length()-lps(sb.toString().toCharArray());
	}


	static int lps(char[] pattern){

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
		System.out.println("LPS array: "+Arrays.toString(lps));
		return lps[N-1];
	}
	
}