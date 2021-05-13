
public class Recursive_series2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(recurse(5));
	}
	
	static double recurse(int n) {
		
		if(n==0)
			return 1.0;
		
		return 1/Math.pow(3, n)+ recurse(n-1);
		
	}

}
