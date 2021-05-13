
 class CountSetBits
{
	public static void main(String[] args)
	{
		int n=22,ct_1=0,ct_0=0;

		while(n>0){
			if((n&1)==1)
				ct_1++;
			else 
				ct_0++;
			n=n>>1;
			
		}
		System.out.println("number of 1s  "+ct_1);
		System.out.println("number of 0s  "+ct_0);

	}
}