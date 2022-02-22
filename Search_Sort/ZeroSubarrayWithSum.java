// * Given an array, find if there exists a subarray with sum equals to zero.
// * n < 10^5
 
//Not ideal process to Count the number of sub arrays
import java.util.*;
public class ZeroSubarrayWithSum{

	public static void main(String[] args) {

		// int[] a = {2,1, 3, -4, -2 };
		// int k = -3;
		// int k=-10;
		// int a[] = { 10, 2, -2, -20, 10 };
		int a[] = {6,-1,-3,4,-2,2,4,6,-12,-7};
		int k=0;

		boolean found = false;
		Set<Integer> set = new HashSet<>();
		int sum = 0;
		int count=0;
		for (int element : a) {
			set.add(sum);  // we are adding 0 in case if totalSum becomes 0, 
			//then we have a 0 in the HashSet to check with
			sum += element;
      		//Zero sum will only exist if the cumulative sum of the elements excluding 
			// the current element and after including the current element are equal
			if (set.contains(sum - k)) {
				count++;
				found = true;
			}
		}

		System.out.println("found " + count);

	}

}
