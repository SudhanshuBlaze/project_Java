import java.util.*;

class CircularTour{
	public static void main(String[] args){
		int petrol[]={4,6,7,4};
		int distance[]={6,5,3,5};
		System.out.println(gas_fill(petrol,distance));
	}

	static int gas_fill(int petrol[], int distance[]){
		int sum =0,diff=0, pos=0;

		for(int i=0;i<petrol.length;i++){
			sum+=-distance[i]+petrol[i];

			if(sum<0){
				diff+=sum;
				sum=0;
				pos=i+1;
			}
		}

		return sum+diff>=0?pos:-1;

	}
}
