
public class Recursive_series3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(recurse(1,5,0));

	}
	static double recurse(double i,int n, double sum) {
		
		if(i>n)
			return sum;
		
		if(i%2==0)
			sum-=1/i;
			
		else sum+=1/i; 
		return recurse(i+1,n,sum);
	}
	

}
