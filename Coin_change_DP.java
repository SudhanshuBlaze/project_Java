
public class Coin_change_DP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long coins[]= {1,5,10};
		System.out.println(func(coins,12));
	}
	
	static long func(long coins[],int tot) {

		long ways[]=new long[(tot+1)]; // if tot=12 then array must run upto 0-12;
		ways[0]=1;		//if tot=0;then returning 0 coins make 1 way
		
		for(long i : coins) {
			for(int j=0;j<ways.length;j++) {
				
				if(i<=j) {
					ways[j]+=ways[(int) (j-i)];  //index must be a int value
				}
				
			}
		}
		return ways[tot];
	}

}
