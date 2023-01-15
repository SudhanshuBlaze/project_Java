//Moore's Voting Algorithm :-> when an element occurs MORE than N/2 times of array
class MajorityElements{
	public static void main(String args[]){
		int arr[] = {1,2,1,1,1,1,3,4,1,1,5,6,1,1,7};
		// int arr[] ={1,2,3};
		MooreAlgo(arr);
	}
	static void MooreAlgo(int arr[]){
		int count = 0;
		int candidate= 0;
		for(int e: arr){
			if(count==0) //then update the candidate
				candidate=e;
			// note: another if, because count would be '0', when updating candidate
			if(e==candidate)  // count of every element is 1
				count++;
			else 
				count--;
		}
	System.out.println(candidate);
	}
}

/* When the criteria for majority element is:
 A majority element in an array A of size N is an element that appears more than N/2 times
 in the array. Then add the below piece of code to above solution.

			count=0;
		    for(int e:arr){
		        if (e==key)
		            count++;
		    }
// we are checking that our majority element is present for more than N/2 times in the array
		    if(count>(N/2)) 
		        return key;
		    else
		        return -1;*/

/* Alt. solution

int count = 1;
		int candidate = arr[0];
		for(int i = 1; i < arr.length; i++){
			if(candidate==arr[i])
				count++;
			else{
				count--;
				if(count==0){
					count=1;
					candidate=arr[i];
				}
			}
		}
		System.out.println(candidate);

*/