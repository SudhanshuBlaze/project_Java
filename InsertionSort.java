import java.util.*;

class InsertionSort{
	public static void main(String[] args){
		int arr[] = {12,1,3,2,2,4,24,242,2};
		int i,j,key;
		//Boolean flag=false;

		for(i = 1; i < arr.length; i++){
			key=arr[i];
			j=i-1;
			while( j>=0 && arr[j]>key){
				arr[j+1]=arr[j];
				j=j-1;
							//flag=true;
			}				//	if(flag)
			arr[j+1]=key;	// using as temp variable, used when while loop is executed,else no use
			//flag=false;
		}
	System.out.println(Arrays.toString(arr));

	}
}