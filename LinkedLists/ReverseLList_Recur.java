class ReverseLList_Recur{
	static Node head=null;  //global head
	public static void main(String args[]){
		// LinkedListG<String> ll=new LinkedListG<>();
		// ll.addLast("What");
		// ll.addLast("is");
		// ll.addLast("Up!");
		// ll.printList(reverse(ll.head,ll.head));

		LinkedList ll=new LinkedList();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		head=ll.head;  //head of newly created LinkedList
		reverse(head);
		ll.printList(head);
	}
	static void reverse(Node curr){
		if(curr.next==null){
			head=curr;
			return;
		}
		reverse(curr.next);
		Node next=curr.next;
		next.next=curr;
		curr.next=null;
	}

	// static Node<String> reverse(Node<String> head, Node<String> curr) {
	// 	if(head==null || head.next==null) return null;

	// 	if(curr.next==null){
	// 		head=curr;
	// 		return head;
	// 	}
	// 	head=reverse(head, curr.next);
	// 	Node<String> next=curr.next;
	// 	next.next=curr;
	// 	curr.next=null;
	// 	return head;
	// }
}