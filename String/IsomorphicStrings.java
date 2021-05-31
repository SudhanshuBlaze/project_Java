class IsomorphicStrings{
	public static void main(String args[]){
		String s1="aaba";
		String s2 = "mmnb";

		System.out.println(validate(s1, s2));
	}

	static boolean validate(String s1, String s2){

		if(s1.length()!=s2.length())
			return false;
		char hash1[] = new char[26];
		char hash2[] = new char[26];

		for(int i=0; i<s1.length(); i++){

			if( hash1[s1.charAt(i)-'a']==0 &&  hash2[s2.charAt(i)-'a']==0){
				
			//placing the char of 2nd string into one in the position of first char and vice versa
				hash1[s1.charAt(i)-'a']=s2.charAt(i);
				hash2[s2.charAt(i)-'a']= s1.charAt(i);
			}
			//it will work even if we chose any one condition
			else if( hash1[s1.charAt(i)-'a']!= s2.charAt(i) || 
				hash2[s2.charAt(i)-'a']!= s1.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}