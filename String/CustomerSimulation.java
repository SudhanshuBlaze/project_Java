// Time complexity: O(N)
// Space complexity: O(1) or constant space

class CustomerSimulation{
	public static void main(String args[]){
	System.out.println(runSimulation(2, "ABBAJJKZKZ".toCharArray())); 
    System.out.println(runSimulation(3, "GACCBDDBAGEE".toCharArray())); 
    System.out.println(runSimulation(3, "GACCBGDDBAEE".toCharArray())); 
    System.out.println(runSimulation(1, "ABCBCA".toCharArray())); 
    System.out.println(runSimulation(1, "ABCBCADEED".toCharArray())); 

	}

	static int runSimulation(int comp, char seq[]){
		boolean flag[]=new boolean[26];  //constant space
		int res=0;

		//loop over each char
		//update its flag, decrement comp, if count is already updated,
		// then change the flag and increment comp
		//at each iteration check if comp==0, 
		for(int i=0; i<seq.length; i++){
			//Un-occupied
			if(flag[seq[i]-'A']==false && comp!=0){
				flag[seq[i]-'A']=true;
				comp--;
			}
			//occupied
			else if(flag[seq[i]-'A']==false && comp==0){
				res++;
			}
			//leaving
			else{
				flag[seq[i]-'A']=false;
				comp++;
			}
		}
		return res/2;
	}
}