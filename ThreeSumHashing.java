// Java program to find a triplet using Hashing 
import java.util.*; 

class ThreeSumHashing { 
	// returns true if there is triplet 
	// with sum equal to 'sum' present 
	// in A[]. Also, prints the triplet 
	static boolean find3Numbers(int A[], int arr_size, int sum) {
		// Fix the first element as A[i] 
		for (int i = 0; i < arr_size - 2; i++){//first element must not be added to HashSet

			/*Find pair in subarray A[i+1..n-1] with sum equal to sum - A[i] 
			Every time a new HashSet is created,
			Cause we dont want it to consider or count previous values */
			HashSet<Integer> s = new HashSet<Integer>(); 
			int curr_sum = sum - A[i]; 
			for (int j = i + 1; j < arr_size; j++) { 
				
				if (s.contains(curr_sum - A[j])) { 
					System.out.printf("Triplet is %d, %d, %d ", A[i],curr_sum - A[j], A[j]); 
					return true; 
				} 
				s.add(A[j]); // Mark it Do not add all elements in the HashSet using a loop.
				/*we do it because we don't want to count the same element twice
				ex. {1,6,0} , target=13, In thise case '6' will be counted twice if
				we add all the elements in the HashSet beforeHand, due to this reason
				we create a new fresh HashSet for each iteration */
			} 
		} 
		// If we reach here, then no triplet was found 
		return false; 
	} 

	public static void main(String[] args){ 
		int A[] = { 2,1,4,3 }; 
		int sum = 6; 
		int arr_size = A.length; 
		find3Numbers(A, arr_size, sum); 
	} 
} 
