/*
Time Complexity: O(N), 'i' is always decrement no matter the condition
Space complexity: O(1)
*/
import java.io.*;
import java.util.*;

public class TransformMinOps {
	
	// Function to find minimum number of
	// operations required to transform
	// A to B.
	public static int minOps(String A, String B){
		if(A.length() != B.length())
			return -1;
		
		int i, j, res = 0;
		int count [] = new int [256];  //works for upper and lower
		
		// count characters in A, subtract count for every character in B
		for(i = 0; i < A.length(); i++){
			count[A.charAt(i)]++;
			count[B.charAt(i)]--;
		}
		
		// Check if all counts become 0, if not it means that there frequencies are not equal
		for(i = 0; i < 256; i++)
			if(count[i] != 0)
				return -1;
		

		/* If there is a mismatch, then keep incrementing result 'res'
		 until B[j] is not found in A[0..i] */
		
		for(i=A.length()-1, j=B.length()-1; i>=0;i--,j--){

			while(i>=0 && A.charAt(i)!=B.charAt(j)){
				res++;
				i--;
				}
		}

//		while(i >= 0){
//         if(A.charAt(i) != B.charAt(j))
//             res++;
//         else
//             j--;
//         i--;        
//       }
		return res;	
	}
	public static void main(String[] args){
		String A = "EACBD";
		String B = "EABCD";

		// String A = "BAD";
		// String B = "ABD";
		
		System.out.println("Minimum number of "+ "operations required is "
								+ minOps(A, B));
	}
}
