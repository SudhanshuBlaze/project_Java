class ConsecutiveCharRemove {

	static StringBuilder recursiveSolver(StringBuilder str, int i){
		
		if(i<str.length()-1){
			if(str.charAt(i)==str.charAt(i+1))
				str.deleteCharAt(i+1);
			else 
				i++;
			recursiveSolver(str,i);
		}
		return str;
	}

	public static void main(String[] args){
		StringBuilder s= new StringBuilder("aabcbcdbca");
		System.out.println(recursiveSolver(s,0));
	}
}