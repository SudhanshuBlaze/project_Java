/*At each intersection point, you have the choice of either continuing with the same sequence 
you’re currently on, or switching to the other sequence.

Find a path with max sum
Time complexity: O(m+n)
*/

class DoubleHelixSpoj{

	public static void main(String args[]){
		int a[]= {3, 5, 7, 9, 20, 25, 30, 40, 55, 56, 57, 60, 62};
		int b[]= {1, 6 ,7, 11, 14,25, 44, 47, 55 ,57, 100};

		// int a[]= {-5, 100, 1000, 1005};
		// int b[]= {-12, 1000, 1001};
		System.out.println("Max sum by changing paths: "+maxSum(a,b));
	}

	static long maxSum(int a[], int b[]){
		int i=0,j=0;
		long res=0,sum1=0,sum2=0;
		while(i<a.length && j<b.length){
			// here we are trying to get to the intersection point of the arrays, 
			// along with it we are also adding the elements which come in the path
			if(a[i]<b[j])
				sum1+=a[i++];
			
			else if(a[i]>b[j])
				sum2+=b[j++];
			
			else{
				res+=a[i]+ Math.max(sum1,sum2);
				sum1=sum2=0;
				i++;
				j++;
				System.out.println(res);
			}
		}
		// for last section
		while(i<a.length)
			sum1+=a[i++];
		
		while(j<b.length)
			sum2+=b[j++];
		
		res+=Math.max(sum1,sum2);
		return res;
	}
}



