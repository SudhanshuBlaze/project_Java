// Java implementation to convert a
// sentence into its equivalent
// mobile numeric keypad sequence
import java.util.*;

class MobileKeyPad
{

	// Function which computes the sequence
	static String printSequence(String arr[],
							String str)
	{
		String output = "";
	
		// length of input string
		int n = str.length();
		for (int i = 0; i < n; i++)
		{
			// Checking for space
			if (str.charAt(i) == ' ')
				output = output + "0";
	
			else
			{
				// Calculating index for each
				// character
				int position = str.charAt(i) - 'A';  //mapping
				output = output + arr[position];
			}
		}
	
		// Output sequence
		return output;
	}
	
	// Driver Function
	public static void main(String[] args){
		// storing the sequence in array
		String str[] = {"2","22","222",
						"3","33","333",
						"4","44","444",
						"5","55","555",
						"6","66","666",
						"7","77","777","7777",
						"8","88","888",
						"9","99","999","9999"
					};

		String input = "GEEKSFORGEEKS";
		System.out.println(printSequence(str, input));
	}
}
