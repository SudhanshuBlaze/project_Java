/*In this approach length of each list does not matter, it will work for lists of any length
Time complexity: O(K*N*logN)
Total elemets: N*K, K elements in each list
*/
import java.util.*;
class Merge_N_sorted_II{
	public static void main(String args[]){
        int N = 3; // Number of linked arr or k
        int k = 4; // Number of elements in each list
 
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
    static Node mergeKLists(Node arr[], int N) {
    	//dummy node
    	Node head = new Node(-1), curr=head;
    	PriorityQueue<Node> minHeap= new PriorityQueue<>((a,b)-> a.data-b.data);
    	//push head of all the lists;
    	for (int i=0; i<N; i++)
    		minHeap.add(arr[i]);
    	while(!minHeap.isEmpty()){
    		Node top=minHeap.poll();
    		curr.next = top;
    		curr=top;

    		if(top.next!=null)
    			minHeap.add(top.next);
    	}
    	return head.next;
    }
}
