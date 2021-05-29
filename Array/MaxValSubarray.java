/*Time complexity: O(N)
Space complexity: O(k), k-> elements in Window(Deque)

/*Approach: Create a Double Ended Queue, dq that will store indexes of array elements
		 The queue will store indexes of useful elements in every window and it will
		 maintain decreasing order of values from front to rear in dq, i.e.,
		 arr[dq.front()] to arr[dq.rear()] are sorted in decreasing order

Sample DQ: [90, 57, 89,.....] 
			^       ^
		  front  last
*/
		 

import java.util.Deque;
import java.util.LinkedList;

public class MaxValSubarray{
	static void printMax(int arr[], int n, int k){
		
		Deque<Integer> dq = new LinkedList<Integer>();

		/* Process first k (or first window)
		elements of array */
		int i;
		for (i = 0; i < k; ++i){

			//remove all the previous smaller element, as they are useless if newer element is greater
			while (!dq.isEmpty() && arr[i] >=
						arr[dq.peekLast()])
				dq.removeLast();

			dq.addLast(i);  //storing indices
		}

		// Process rest of the elements,
		// i.e., from arr[k] to arr[n-1]
		for (i=k; i < n; ++i){
		
			// The element at the front of the queue is the largest element of
			// previous window, so print it
			System.out.print(arr[dq.peek()] + " ");  //dq.peek() -> peeks first element

			// Remove the elements which are out of this window
			while ((!dq.isEmpty()) && dq.peek() <= i - k)
				dq.removeFirst();

			// Remove all elements smaller than the currently
			// being added element (remove useless elements)
			while ((!dq.isEmpty()) && arr[i] >= arr[dq.peekLast()])
				dq.removeLast();

			// Add current element at the rear of dq
			dq.addLast(i);
		}

		// Print the maximum element of last window
		System.out.print(arr[dq.peek()]);
	}

	public static void main(String[] args){
		int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
		int k = 3;
		printMax(arr, arr.length, k);
	}
}

//Our sample window is like [90,60,50], left most element cannot be small, 
//else it would be removed right away. That's why for every new element,
// we are checking first that right-most element is smaller or not.
