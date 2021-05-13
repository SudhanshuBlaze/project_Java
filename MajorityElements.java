//Moore's Voting Algorithm :-> when an element occurs MORE than N/2 times of array
class MajorityElements{
	public static void main(String args[]){
		int arr[] = {1,2,1,1,1,1,3,4,1,1,5,6,1,1,7};
		MooreAlgo(arr);
	}
	static void MooreAlgo(int arr[]){
		int count = 0;
		int candidate= 0;
		for(int e: arr){
			if(count==0)
				candidate=e;
			if(e==candidate)  // count of every element is 1
				count++;
			else 
				count--;
		}
	System.out.println(candidate);

	}
}