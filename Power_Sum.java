
public class Power_Sum {


		// TODO Auto-generated method stub
		

	
		// Driver code 
			public static void main(String args[]) 
			{ 
				int x = 100, n = 2; 
				System.out.println(countWays(x, n)); 
			} 
				
			static int countWays(int x, int n, int num) 
			{ 
				// Base cases 
				int val = (int) (Math.pow(num, n)); 
				if (val == x) 
					return 1; 
				if (val > x) 
					return 0; 
			
				// Consider two possibilities, num is 
				// included and num is not included. 
				return countWays(x, n, num + 1) + 
					countWays(x-val, n, num + 1); 
			} 
			
			// Returns number of ways to express 
			// x as sum of n-th power of two. 
			static int countWays(int x, int n) 
			{ 
				return countWays(x, n, 1); 
			} 
			
			
		} 
