// series-> 1,11, 21, 1211, 111221
class CountAndSay{

	public static void main(String args[]){
		System.out.println(count(5));
	}

	static String count(int n){
		if(n==1)
			return "1";
		if(n==2)
			return "11";

		String str ="11";
		String next ="";

		int count =1;
		while(n>=3){
			next="";
			str+="$";
			for(int i=1;i<str.length();i++){
				if(str.charAt(i)==str.charAt(i-1))
					count++;
				else{
					next+=Integer.toString(count)+str.charAt(i-1);
					count = 1;
				}
			}
			str=next;
			n--;
		}
		return str;
	}
}








// next="";
// 			str+="$";
// 			for(int i=1;i<str.length();i++){
// 				if(str.charAt(i)==str.charAt(i-1))
// 					count++;
// 				else{
// 					next+=Integer.toString(count)+str.charAt(i-1);
// 					count=1; //reset 
// 				}
// 			}
// 			str=next;
// 			n--;