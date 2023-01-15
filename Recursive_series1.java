
public class Recursive_series1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println();
		System.out.println(recurse(5));

	}
	 static long recurse(int n) {
		 if(n==1)
			 return 1;
		 
		 return (long)Math.pow(n, n)+recurse(n-1);
//		 System.out.println(Math.pow(n, n));

		
	}

}
