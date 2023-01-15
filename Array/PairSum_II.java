//No repetitition
import java.util.*;

class PairSum_II {
	public static int CountPair(int target, int[] arr){
		HashSet<Integer> set = new HashSet<Integer>();
		int count = 0;
		for(int i=0; i<arr.length; i++){			
			if(set.contains(target-arr[i])){
				System.out.println("Pairs "+arr[i]+", " +(target-arr[i]));
				count++;
			}
			else
				set.add(arr[i]);
		}
		return count;
	}

	public static void main(String args[]){
		int[] arr = { 1, 5, 7, -1, 5 };

		int target = 6;
		System.out.println("Count: " +CountPair(target, arr));
	}
}


