// Time complexity-> O(N^2)
// Space complexity->O(1)

class LongPalinSubstring_2pointer{

	static String find(String str){

		int start=0, maxLength=1;  //for single character, ex. "abc", res->1;
		int low, high;
		int count = 0;  //for counting all Palindromic subsequences
		int len=str.length();

		for(int i=1; i<len;i++){
			low=i-1;
			high=i;
			// for substring of even length 
			while(low>=0 && high<len && str.charAt(low)==str.charAt(high)){
				if(high-low+1 > maxLength){
					start=low;
					maxLength=high-low+1;
				}
				low--;
				high++;
				count++;
			}

			low=i-1;
			high=i+1; 
			while(low>=0 && high<len && str.charAt(low)==str.charAt(high)){
				if(high-low+1 > maxLength){
					start=low;
					maxLength=high-low+1;
				}
				low--;
				high++;
				count++;
			}
		}
		System.out.println("count: "+ (count+str.length())); //Counts Palindromic Subsequences 
		return str.substring(start,start+maxLength); 

	}

	public static void main(String[] args){
		// String str = "aab";
		String str = "aabcbcdbca";
		System.out.println("Length is: " + find(str));
	}
}
