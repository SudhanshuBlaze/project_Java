class replacePI_recur{
	public static void main(String[] args){
        String s = "pipiipipp";
        System.out.println(replacePi(s));
    }
    static String replacePi(String s){
    	if(s.length()<=1)
    		return s;
    	
    	else if(s.substring(0,2).equals("pi"))
			return "3.14"+replacePi(s.substring(2));
		// basic increment in recursion
		else 
			return s.charAt(0)+replacePi(s.substring(1));
    }
}