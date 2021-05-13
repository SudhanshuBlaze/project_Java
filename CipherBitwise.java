import java.util.*;
class CipherBitwise{

	public static void main(String args[]){
		int shift=2 ,i,temp;
		String s="1110001",fin="" ;

		int res[]=new int[s.length()-shift+1];
		char str[]= s.toCharArray();
		for(i=0;i<res.length;i++){
			
			if(i==0)
				res[0]= str[0]-'0';
			else if(i<shift){
				res[i]=str[i]^str[i-1] ;
			}
			else{		
				res[i]=str[i]^res[i-shift]^str[i-1];
			}
			System.out.print(res[i]);
			

		// for(int e :res){
		// 	 fin += Integer.toString(e);
		}
		// char a ='1'^'2';
		// System.out.println(a);
		// System.out.println(('1'^'2').getType());
}

		// System.out.println(Arrays.toString(res));
	}