
public class Recursive_series3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(recurse(4));
	}
	
	static double recurse(double n) {
		if(n==1)
			return 1;
		if(n%2==0)
			return recurse(n-1)-1/n;
		else return recurse(n-1)+1/n;
	}

}
