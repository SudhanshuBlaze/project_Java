
public class Recursive_series4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			fun(4);
	}
		
		
		static void fun(int n) 
		{ 
			if(n <= 0) 
			return;
			
				fun(n - 1); 
				System.out.print(n+" "); 
				fun(n - 1); 
			}
		} 

