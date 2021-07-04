/*
Time complexity: O( N.log(num*eps) )

N-> nth root, (multiply function)
num-> number,  (search space->  [1,num]
eps-> number of decimal places-> if eps= 1e-2, for search space [1,2], there are 10 numbers,
i.e. [1.0,1.1,.....1.9]
*/

class NthRootOfNumber {
    private static double multiply(double number, int root) {
        double ans = 1.0;
        for(int i = 1;i<=root;i++) {
            ans = ans * number;
        }
        return ans; 
    }
    private static void getNthRoot(int root, int num) {
        double low = 1;
        double high = num;
        double eps = 1e-6; 
        //loop will run until the high-low== 1e-6,
        //which means on substracting high-low will give 0.0000001
        
        while((high - low) > eps) {
            double mid = (low + high) / 2.0; 
            if(multiply(mid, root) < num) {
                low = mid; 
            }
            else {
                high = mid; 
            }
        }
        //**Result is same for both upto 5 decimal places
        System.out.println("using Bsearch: "+low + " " + high);  
        System.out.println("using Math.pow: "+Math.pow(num ,(double) 1/root )); //verifcation
    }
	public static void main (String[] args) {
		int root = 17, num = 89; 
		getNthRoot(root, num); 
	}
}
