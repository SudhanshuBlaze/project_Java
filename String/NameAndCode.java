import java.util.*;
class NameAndCode{
	public static void main(String args[]){
		String s="Anchal:23581,Aman:57568,Sonakshi:34848,Ria:14585";
		System.out.println(getPassword(s));	
	}
	static String getPassword(String s){
		String res="";
		String dict[]= s.split(",");
		for(String e:dict){
			String sep[]= e.split(":");
			int nameLen= sep[0].length();
			int max=-1;
			for(int i=0;i<sep[1].length();i++){
				int digit= Character.getNumericValue(sep[1].charAt(i));

				if(digit>max && digit<=nameLen ){
					max=digit;
				}
			}
			if(max!=-1)
				// System.out.println(sep[0]+max);
				res+=sep[0].charAt(max-1);
			else
				res+="X";
		}
		return res;
	}
}