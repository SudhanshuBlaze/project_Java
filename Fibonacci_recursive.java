
public class Fibonacci_recursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(recurse(4,1,1,2));
		recurse(10,0,1,1);
	}
	static void recurse(int n,int a,int b,int c){
		if(n==0)
			return;
		System.out.println(b);
		recurse(n-1,b,c,b+c);   //switching of var is happening in single step therefore c=b+c
		//System.out.println(b);

		
	}

}
