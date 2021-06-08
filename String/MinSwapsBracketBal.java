import java.util.Vector;
class MinSwapsBracketBal{

	//Approach 2:	
	//Time complexity: O(N)
	//Space complexity: O(N)

	// public static long swapCount(String s){
		
	// 	// Keep track of '['
	// 	Vector<Integer> pos = new Vector<Integer>();
	// 	for(int i = 0; i < s.length(); ++i)
	// 		if (s.charAt(i) == '[')
	// 			pos.add(i);
				
	// 	// To count number of encountered '['
	// 	int count = 0;
		
	// 	// To track position of next '[' in pos
	// 	int p = 0;
		
	// 	// To store result
	// 	long sum = 0;
		
	// 	char[] S = s.toCharArray();
		
	// 	for(int i = 0; i < s.length(); ++i)
	// 	{
			
	// 		// Increment count and move p
	// 		// to next position
	// 		if (S[i] == '[')
	// 		{
	// 			++count;
	// 			++p;
	// 		}
	// 		else if (S[i] == ']')
	// 			--count;

	// 		// We have encountered an
	// 		// unbalanced part of string
	// 		if (count < 0)
	// 		{
				
	// 			// Increment sum by number of
	// 			// swaps required i.e. position
	// 			// of next '[' - current position
	// 			sum += pos.get(p) - i;
	// 			char temp = S[i];
	// 			S[i] = S[pos.get(p)];
	// 			S[pos.get(p)] = temp;
	// 			++p;

	// 			// Reset count to 1
	// 			count = 1;
	// 		}
	// 	}
	// 	return sum;
	// }

/*Approach 2: with NO REAL swapping
	Time complexity: O(N)
	Space complexity: O(N)*/

	public static int swapCount(String str){
		char s[]=str.toCharArray();

		int nswap=0, imbalance=0, leftCount=0,rightCount=0;

		for(int i=0; i<str.length();i++){

			if(s[i]=='['){
				leftCount++;

				if(imbalance>0){
					nswap+=imbalance;  //number of swaps
					imbalance--;   //after swap one ']' becomes balanced
				}
			}
			else{
				rightCount++;
				 imbalance=rightCount-leftCount;
			}
		}

		return nswap;
	}

	

	public static void main(String[] args){
		String s = "[]][][";
		// System.out.println(swapCount(s));

		 s = "]][][[";
		System.out.println(swapCount(s));


		// s = "[]]]][][[[";
		// System.out.println(swapCount(s));

		// s = "[[][]]";
		// System.out.println(swapCount(s));
	}
}