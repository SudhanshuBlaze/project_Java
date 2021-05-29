// Following program is a Java implementation
// of Rabin Karp Algorithm given in the CLRS book

public class Rabin_Karp{
	// d is the number of characters in the input alphabet
	public final static int d = 256;
	
	/* pat -> pattern
		txt -> text
		q -> A prime number,
		we are taking q as a prime number so that we can minimize large hash value. 
		why we are minimizing? we may get a larger hash value than the the data type that we are using,
		so to resolve this we are taking q.
	*/
	static void search(String pat, String txt, int q){
		int M = pat.length();
		int N = txt.length();
		int i, j;
		int patHash = 0; // hash value for pattern
		int txtHash = 0; // hash value for txt
		int h = 1;
	
		// The value of h would be "pow(d, M-1)%q"
		for (i = 0; i < M-1; i++)
			h = (h*d)%q;
	
		// Calculate the hash value of pattern and first
		// window of text
		for (i = 0; i < M; i++){
			patHash = (d*patHash + pat.charAt(i))%q;
			txtHash = (d*txtHash + txt.charAt(i))%q;
		}
	
		// Slide the pattern over text one by one
		for (i = 0; i <= N - M; i++){
	
			// Check the hash values of current window of text
			// and pattern. If the hash values match then only
			// check for characters on by one
			if ( patHash == txtHash ){
				/* Check for characters one by one */
				for (j = 0; j < M; j++){
					if (txt.charAt(i+j) != pat.charAt(j))
						break;
				}
	
				// if patHash == txtHash and pat[0...M-1] = txt[i, i+1, ...i+M-1]
				if (j == M)  //if the loop runs completely, then M becomes equal to "j"
					System.out.println("Pattern found at index " + i);
			}
	
			// Calculate hash value for next window of text: Remove
			// leading digit, add trailing digit
			if ( i < N-M ){
				txtHash = (d*(txtHash - txt.charAt(i)*h) + txt.charAt(i+M))%q;
	
				//since we are using: mod q, value of "txtHash" lies in (-q,q)
				if (txtHash < 0)
				txtHash = (txtHash + q); // We might get negative value of txtHash, converting
				//it to positive
			}
		}
	}
	
	/* Driver Code */
	public static void main(String[] args)
	{
		String txt = "GEEKS FOR GEEKS hha GEEKS";
		String pat = "GEEK";
			
		// A prime number
		int q = 101;
		
		// Function Call
		search(pat, txt, q);
	}
}
