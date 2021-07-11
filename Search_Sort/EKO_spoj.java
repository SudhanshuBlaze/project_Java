import java.util.*;
class EKO_spoj{
	public static void main(String args[]){
		int trees[]={20, 15, 10, 17};
		int wood= 7; //wood reqd.
		System.out.println(heightOfBlade(trees,wood, trees.length));   
	}

	static int heightOfBlade(int[] trees, int woodReqd, int n){
		/*define the search space
		if all the wood reqd. then blade height should be 0, if not wood reqd. 
		then blade height max of tree.
		*/
		int low=0, high=Arrays.stream(trees).max().getAsInt();
		while(low<= high){
			int mid=(low+high)>>1;
			int woodCut=woodCut(trees,mid);
			if(woodCut==woodReqd)
				return mid;
			else if(woodCut>woodReqd)
				low=mid+1;
			else
				high=mid-1;
		}
		return -1;
	}
	static int woodCut(int[] trees, int bladeHeight){
		int res=0;
		for(int i=0;i<trees.length;i++){
			if(trees[i]>bladeHeight)
				res+=trees[i]-bladeHeight;
		}
		return res;
	}
}


