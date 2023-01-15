import java.util.* ;
class TheGreatXor{
	public static void main(String args[]){
		int x=5,i,ct=0,pos=0;

		while(x>0){
			if((x&1)==0)
				ct=ct+(int)Math.pow(2,pos);
			pos+=1;
			x=x>>1;
		}
		System.out.println(ct);

	}
}