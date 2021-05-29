class LongestCommonPrefix{
	public static void main(String args[]){
		String strs[] = {"flower","flower","flower","flower"};
		System.out.println(lcp(strs));
	}

	static String lcp(String strs[]){

		int i = 0;
		String res="";
		String constant = strs[0];
		while(i<constant.length()){
			
			for(int j=1;j<strs.length;j++){
				if(i>=strs[j].length() || constant.charAt(i)!= strs[j].charAt(i))
					return res;
			}
			res+=constant.charAt(i);
			i++;
		}
		if(res.length()!=0)
			return res;
		return "";
	}
}