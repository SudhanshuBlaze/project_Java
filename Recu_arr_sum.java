
class Recu_arr_sum {

public static void main(String[] args){
	int a[]={-1, 2, -2, 1,2,-1,-9,3,3,3};
	
	System.out.println(recur(a,0,0)-1); 
}	//a case exists in which nothing is added therefor sum remains 0

static int recur(int a[],int i,int sum){

	// if(sum==0){ 			//in the beginning sum is 0
	// 	// System.out.println(i);
	// 	return 1;
// 	// }
	if(i==a.length)
{
	if(sum==0)
		return 1;
	else return 0;
	}

	return recur(a,i+1,sum+a[i])+recur(a,i+1,sum); //all possible combinations
	}
}
