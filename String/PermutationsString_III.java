//Time Complexity: O(N^3)
import java.util.*;
class PermutationsString_III{

	public static void main(String args[]){
		String s="IOG";
		permute(s, "");
	}

	static void permute(String ques, String ans){
		indent(ans);
		System.out.println("permute("+ques+", "+ ans+")");

		//no chars are left to choose and explore from
		if(ques.length()==0){
			System.out.println(ans);
			return;
		}

		for(int i=0; i<ques.length();i++){

			String lpart=ques.substring(0,i);
			String rpart=ques.substring(i+1);
			String combine=lpart+rpart;

			permute(combine,ans+ques.charAt(i));
			// in this case we are never altering the real string which is 'ques'
			// at each iteration we are creating a new string by taking the left part of
			// the chosen char and right part of chosen char.
		}
	}

	static void indent(String chosen){
		for(int i=0; i<chosen.length();i++)
			System.out.print("  ");
	}
}