class FactorialOfLargeNum{
	public static void main(String args[]){
		getFactorialOf(5);
	}

	static void getFactorialOf(int num){
		int res[]=new int[100];  //actual size
		res[0]=1;
		int size=1; //logical size

		for(int factor=2;factor<=num;factor++){
			size=multiplyFactor(res,factor,size);  
			//this function multiplies current factor with current number in the array
		}
		//prints result
		System.out.print("Factorial of a given number is: ");
		for(int i=size-1;i>=0;i--){
			System.out.print(res[i]);
		}
	}
	// Ex:Multiple 15 with 10 // 5,1  -> 0,5,1
	static int multiplyFactor(int res[], int factor, int size){
		int carry=0;
		for(int i=0;i<size;i++){

			int prod=res[i]*factor+carry;

			res[i]=prod%10;  //last digit
			carry=prod/10;  //all digits except last digit
		}
		while(carry>0){
			res[size]=carry%10;  //last digit of carry
			carry=carry/10;
			size++;
		}
		return size;
	}
}