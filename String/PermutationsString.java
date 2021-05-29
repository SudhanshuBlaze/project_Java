class PermutationsString{
	public static void main(String args[]){
		String s="ABC";
		getPermutations(s,0,s.length()-1);
	}

	static void getPermutations(String s,int l,int r){
		if(l==r){
			System.out.print(s+" ");
			return;
		}
		for(int i=l;i<=r;i++){
			s=swap(s,l,i);
			getPermutations(s,l+1,r);
			s=swap(s,l,i);  //backtracking
		}
	}
	static String swap(String str,int a, int b){
		StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(a, str.charAt(b));
        sb.setCharAt(b, str.charAt(a));
        return sb.toString();
	}
}