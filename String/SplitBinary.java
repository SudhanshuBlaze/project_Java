class SplitBinary{
	static int maxSubStr(String str, int n){
		// To store the count of 0s and 1s
		int count0 = 0, count1 = 0;

		// To store the count of maximum
		// substrings str can be divided into
		int res = 0;
		for (int i = 0; i < n; i++){
			if (str.charAt(i) == '0')
				count0++;
			else
				count1++; 

			if (count0 == count1)
				res++;
		}

		return res;
	}

	public static void main(String []args){
		String str = "0100110101";
		int n = str.length();

		System.out.println(maxSubStr(str, n));
	}
}

/* Approach: Initialize count = 0 and traverse the string character by
character and  keep track of the number of 0s and 1s so far,  whenever  the
count of 0s and 1s become equal increment the count.  If the count of 0s and
1s in the original string is not equal then print -1, else print the value of
count after the traversal of the complete string.  */
