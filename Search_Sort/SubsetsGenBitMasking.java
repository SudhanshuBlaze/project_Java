/*
A Bitmask is a representation of subset of an array. 
Ex: {2,4,5}, Bitmask=101 represents -> {2,5}; Bitmask=000 represents -> {};

If an array is of size 'n', then number of subsets would be "2^ⁿ"
So, to generate all the subsets we need to generate all the "Bitmasks".
So, the number of the BitMasks would be (1<<n) which is 2^ⁿ or (0 to 2^ⁿ-1)


Since, bitmask is representing subset of array, so in a bitmask the bits 
which are set, index of those set bits will be used for selecting the elements
which will be included in the array

mask -> index of set bits represents index to be included in the subset
000  -> {}
001  -> {2}
010  -> {4}
011  -> {2,4}
100  -> {5}
101  -> {2,5}
110  -> {4,5}
111  -> {2,4,5}
*/

import java.util.*;
class SubsetsGenBitMasking{
	public static void main(String args[]){
		int arr[] = {2,4,5};
		System.out.println("Printing indexes of elements to be included in subset");
		System.out.println("\n\n"+"Subsets:\n"+genSubsets(arr, arr.length));
	}
	static ArrayList<ArrayList<Integer>> genSubsets(int[] arr, int N){
		ArrayList<ArrayList<Integer>> res= new ArrayList<>();

		// (1<<N) : left shift 1 by "N" times, this gives us 2^ⁿ
		// mask= 0 to 2^ⁿ -1
		for(int mask=0; mask< 1<<N; mask++){
			ArrayList<Integer> subset= new ArrayList<>();

			// we're iteraring over each bit of bitmask and checking, which bits are set,
			// if a bit is set, then we put value at that index of array in the subset.

			for(int i=0; i< N;i++){
				// Ex: i=0: 1<<0=1, i=1: 1<<1=10, i=2: 1<<2=100,.... 1<<3=1000 etc.
				if((mask & (1<<i)) != 0){// checking i'th bit is set or not
					System.out.print(i+" ");
					subset.add(arr[i]);
				}
			}
			System.out.print(",");

			res.add(subset);
		}
		return res;

	}
}