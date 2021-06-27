class IsomorphicStrings{
	public static void main(String args[]){
		// String s1="aaba";
		// String s2 = "mmnb";

		// String s1 = "lpijthbsfy";
		// String s2=  "afvladzpbf";
		//l is already mapped to 'a', so j is mapped to 0(since its unvisited),
		// which is not equal to l

		String s1 = "pijthbsfy";
		String s2=  "fvladzpbf";
		//Explanation if 'p' is mapped to 'f', then 'f' should also be mapped to 'p'

		System.out.println(validate(s1, s2));
	}

	static boolean validate(String s1, String s2){
		char map1[] = new char[26];
		char map2[] = new char[26];

		for(int i=0; i<s1.length(); i++){
			if(s1.length()!=s2.length())
				return false;

			if( map1[s1.charAt(i)-'a']==0 &&  map2[s2.charAt(i)-'a']==0){
				
			//placing the char of 2nd string into one in the position of first char and vice versa
				map1[s1.charAt(i)-'a']=s2.charAt(i);
				map2[s2.charAt(i)-'a']= s1.charAt(i);
			}
			else if(map1[s1.charAt(i)-'a']!= s2.charAt(i)) {
				System.out.println(i);
				return false;
			}
		}
		return true;
	}
}
