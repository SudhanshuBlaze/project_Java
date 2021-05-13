import java.util.*;

// 11001010
// 110

class CounterGame {
	public static void main(String[] args){
		int moves =0;
		long n= 2048s;
		while(n>0){
			if( (n&1) ==0){
				moves++;
			}
			else{
				break;
			} 
			n=n>>1;
		}
		// System.out.println(moves);

		while(n>0){
			n=n>>1;
			if( (n&1) ==1){
				moves++;
			}
	    }
	    System.out.println(moves);
		if(moves%2==0)
			System.out.println("Richard");
		else 
			System.out.println("Lousie");

	}
}