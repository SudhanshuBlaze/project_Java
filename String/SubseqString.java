// Java program for the above approach
// Time complexity: O(2^N)
import java.util.*;
class SubseqString {

	// Declare a global list
	static List<String> al = new ArrayList<>();

	// Creating a public static Arraylist such that
	// we can store values
	public static void main(String[] args)
	{
		String s = "abcd";
		findsubsequences(s, ""); // Calling a function
		System.out.println(al);
	}

	private static void findsubsequences(String s,
										String ans)
	{
		// if (i==s.length()) {
		if(s.length()==0) {
			al.add(ans);
			return;
		}

		// s.substring(1) -> s[1:]
		// We add adding 1st character in string
		findsubsequences(s.substring(1),ans+s.charAt(0)); //left subtree
		// Not adding first character of the string
		// because the concept of subsequence either
		// character will present or not
		findsubsequences(s.substring(1),ans);  //right subtree


		// findsubsequences(s, ans + s.charAt(i),i+1); 
		// findsubsequences(s, ans,i+1);
	}
}

