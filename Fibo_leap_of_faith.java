
public class Fibo_leap_of_faith {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		for(i=0;i<10;i++)
		System.out.println(fib(i));
	}
	static int fib(int n) {
		if(n<=1)
			return 1; //for i=0,1 this line is directly executed
		
		return fib(n-1)+fib(n-2);
	}

	
}
