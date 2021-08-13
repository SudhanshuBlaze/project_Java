class replacePI_recur{
	public static void main(String[] args){
        String s = "pipppiiipi";

        System.out.println(replacePi(s));
    }
    static String replacePi(String s){
    	if(s.length()<=1)
    		return s;
    	
    	if(s.substring(0,2).equals("pi"))
			return "3.14"+replacePi(s.substring(2));

		return s.charAt(0)+replacePi(s.substring(1));
    }
}