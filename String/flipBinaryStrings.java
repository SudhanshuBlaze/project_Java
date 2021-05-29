/*
Approach: We can solve this problem by considering all possible results,
As we are supposed to get alternate string, there are only 2
possibilities, alternate string starting with 0 and alternate string
starting with 1

Value of "cnt" if string starts from 0, will be inverse of value of
"cnt" if strings starts with 1

We are comparing our input string with "0101010...", whatever value will be inverse of value 
we get on comparing input tring to this "10101010..."
*/

class flipBinaryStrings{
	static int minReplacement(String s, int len){
		int cnt = 0;
		for (int i = 0; i < len; i++) {

			// If there is 1 at even index positions
			if (i % 2 == 0 && s.charAt(i) == '1')
				cnt++;
			else if (i % 2 == 1 && s.charAt(i) == '0')
				cnt++;
		}
		return Math.min(cnt, len - cnt);
	}
	public static void main(String args[]){
		String s = "0001010111";
		int len = s.length();
		System.out.print(minReplacement(s, len));
	}
}

