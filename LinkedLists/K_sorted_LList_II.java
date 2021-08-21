/*Time complexity: O(N*logK), insertion of total N elements: O(N)
insertion takes O(logK),

more accurate representation: 
O((N-K)*logK), because k element are already inserted in O(K*logK)
*/
import java.util.*;
class K_sorted_LList_II{
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

		Node newHead=new Node(-1), curr=newHead;
		while(!minHeap.isEmpty()) {
			Node top=minHeap.poll();
			
			curr.next=top;
			top.prev=curr;
			curr=curr.next;
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
		/*newHead.data= -1 which is dummy, so we are making such adjustments that 
		-1 can't be accessed by using prev or next pointer.*/
		newHead.next.prev=null;
		return newHead.next;
	}
}