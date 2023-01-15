// Time complexity: O(2^N)
import java.util.*;
class SubseqString {

	// Declare a global list
	static List<String> al = new ArrayList<>();

	// Creating a public static Arraylist such that
	// we can store values
	public static void main(String[] args){
		String s = "abcd";
		findsubsequences(s, "",0); // Calling a function
		System.out.println(al);
	}

	private static void findsubsequences(String s,String chosen, int i){
		if(i==s.length()) {
			al.add(chosen);
			return;
		}

		// Not adding first character of the string because the concept of 
		// subsequence either character will present or not
		findsubsequences(s, chosen + s.charAt(i),i+1);  //pick
		findsubsequences(s, chosen,i+1); //don't pick
	}
}

