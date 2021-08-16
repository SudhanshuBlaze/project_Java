/*Sliding window technique

Normal sort-> O(NlogN)
this algorithm-> O(NlogK),

insertion and deletion in minHeap takes O(logK) because heap is of k size and
we iterate over the entire array -> O(N), 
we do these 2 tasks simultaneously so O(NlogK)
*/
import java.util.*;
class K_sorted_LList{
	public static void main(String[] args){
	    DoublyLinkedList list = new DoublyLinkedList();
	    list.addLast(6);
	    list.addLast(2);
	    list.addLast(3);
	    list.addLast(12);
	    list.addLast(56);
	    list.addLast(8);
	 
	    System.out.println("Original Doubly linked list:");
	    list.printList(list.head);
	    System.out.println();
	    list.printList(sortK(list.head,3));
	}
	static Node sortK(Node head, int k) {
		PriorityQueue<Node> minHeap= new PriorityQueue<>((a,b)->a.data-b.data);
		for(int i=0;i<k+1;i++,head=head.next)
			minHeap.add(head);
		Node newHead=null, curr=null;
		while(!minHeap.isEmpty()) {
			Node top=minHeap.poll();
			// for first iteration
			if(newHead==null){
				newHead=top; 
				newHead.prev=null; //not necessary but a good practice
				curr=newHead;
			}
			else{
				curr.next=top;
				top.prev=curr;
				curr=curr.next;
			}
			//add new element-> slides window
			if(head!=null){
				minHeap.add(head);
				head=head.next;
			}
		}
		/*imp step, else it will go into infinity loop, because the node which we add
		onto our new list they are already pointing somewhere else 
		so we should point it to null*/
		curr.next=null;
		return newHead;
	}
}