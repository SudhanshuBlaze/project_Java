/*
In this approach length of each list does not matter, it will work for lists of any length
Time complexity: O(NlogK), O(N) for merging and O(logK) for divide and conquer
*/
class Merge_N_sorted{
	//O(N)
	static Node merge(Node a, Node b) { 
	    Node result = null; 
	    if (a == null) 
	        return (b); 
	    else if(b == null) 
	        return (a); 
	  
	    if(a.data <= b.data) { 
	        result = a; 
	        result.next = merge(a.next, b); 
	    } 
	    else{ 
	        result = b; 
	        result.next = merge(a, b.next); 
	    } 
	    return result; 
	} 
	  
	/* ->The main function that takes an array of lists arr[0..last]<-
	Merge a[0] and a[1] into a[0]; a[2] and a[3], etc. This will merge half of the elements. 
	Then start merging a[0] and a[2] into a[0], a[4] and a[6] into a[4], etc.
	It is the same as the recursion from complexity point of view, 
	but doesn't push so much stuff into the stack.
	mergeKLists()-> O(logk)
	*/

	static Node mergeKLists(Node arr[], int N) { 
		for (int delta = 1; delta < N; delta = delta * 2)
			for (int i = 0; i + delta < N; i += 2*delta)
				arr[i] = merge(arr[i], arr[i + delta]);
		
	    return arr[0];
	} 
	public static void main(String args[]){
        int N = 3; // Number of linked arr or k
        int listLen = 4; // Number of elements in each list
 
        // an array of pointers storing the head nodes of the linked arr
        Node arr[] = new Node[N];
 		LinkedList l1=new LinkedList();
 		l1.addLast(1);
 		l1.addLast(3);
 		l1.addLast(5);
 		l1.addLast(7);
        arr[0] = l1.head;
		
		LinkedList l2=new LinkedList();
 		l2.addLast(2);
 		l2.addLast(4);
 		l2.addLast(6);
 		l2.addLast(8);
        arr[1] = l2.head;
 
        LinkedList l3=new LinkedList();
 		l3.addLast(-5);
 		l3.addLast(0);
 		l3.addLast(2);
 		l3.addLast(5);
        arr[2] = l3.head;
 
        // Merge all arr
        Node head = mergeKLists(arr, N);
        l1.printList(head);
    }
}