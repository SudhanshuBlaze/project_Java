import java.util.Arrays;

public class Fibonacci_DP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]=new int[9];
		int i;
		a[0]=1;
		a[1]=1;
		
		
		for(i=2;i<a.length;i++) {
		a[i]=a[i-1]+a[i-2];
				}
		System.out.println(Arrays.toString(a));

		//System.out.println(b);

	}

}
