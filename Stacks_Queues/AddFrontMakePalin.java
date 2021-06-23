import java.util.*;
class AddFrontMakePalin{

//returns vector lps for given string str
	static int[] computeLPSArray(char[] pattern){
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
		return lps;
	}
	static int getMinCharToAddedToMakeStringPalin(String str){
		
		StringBuilder sb = new StringBuilder(str);
		String rev= sb.reverse().toString();
		sb.reverse(); //reverse back to original
		sb.append("$").append(rev);
		System.out.println(sb.toString());
		
		int lps[]=computeLPSArray(sb.toString().toCharArray());
		System.out.println(Arrays.toString(lps));

		return str.length() - lps[lps.length-1];
	}
	public static void main(String args[]){
		String str = "AACECAAAA";
		System.out.println(getMinCharToAddedToMakeStringPalin(str));
	}
}

