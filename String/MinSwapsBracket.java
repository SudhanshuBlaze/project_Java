import java.util.ArrayList;
class MinSwapsBracket{	
	public static long swapCount(String s){
		
		// Keep track of '['
		ArrayList<Integer> pos = new ArrayList<Integer>();
		for(int i = 0; i < s.length(); ++i)
			if (s.charAt(i) == '[')
				pos.add(i);
				
		// To count number of encountered '['
		int count = 0;
		
		// To track position of next '[' in pos
		int p = 0;
		
		// To store result
		long sum = 0;
		
		char[] S = s.toCharArray();
		
		for(int i = 0; i < s.length(); ++i){
			
			// Increment count and move p to next position
			if (S[i] == '['){
				++count;
				++p;
			}
			else if (S[i] == ']')
				--count;

			// We have encountered an unbalanced part of string
			if (count < 0){
				
				// Increment sum by number of swaps required i.e. position
				// of next '[' - current position
				sum += pos.get(p) - i;
				char temp = S[i];
				S[i] = S[pos.get(p)];
				S[pos.get(p)] = temp;
				++p;

				// Reset count to 0
				count = 0;
				i++;  //increment extra '1' because it's balanced until next element,
				// as after swapping at 'i' there is '[' and at i+1 there is ']'
			}
		}
		return sum;
	}

	public static void main(String[] args){
		String s = "[]][][";
		System.out.println(swapCount(s));

		s = "[]]]][][[[";
		System.out.println(swapCount(s));

		s = "[[][]]";
		System.out.println(swapCount(s));
	}
}