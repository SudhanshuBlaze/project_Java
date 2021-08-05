import java.util.*;
class WordBreak{
	public static void main(String args[]){	
		String temp_dictionary[] = {"mobile","samsung","sam","sung",
                            "man","mango","icecream","and", "go","i","like","ice","cream"};
                             
        Set<String> dictionary = new HashSet<String>();
        dictionary.addAll(Arrays.asList(temp_dictionary));
        System.out.println(wordBreak(dictionary,"ilikesamsung"));
	}
	static int wordBreak(Set<String> dictionary, String sentence) {
		int dp[]=new int[sentence.length()];
		for (int i=0; i<dp.length;i++){
			for (int j=0; j<=i;j++){
				String word = sentence.substring(j,i+1);
				if(dictionary.contains(word)){
					if(j>0)
						dp[i]+=dp[j-1];
					else
						dp[i]+=1;
				}
			}
		}
		return dp[dp.length-1];
	}
}