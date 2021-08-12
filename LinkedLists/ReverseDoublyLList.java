class ReverseDoublyLList{
	public static void main(String args[]){
		DoublyLinkedList ll = new DoublyLinkedList();
		ll.addLast(10);
		// ll.addLast(1);
		// ll.addLast(3);
		ll.printList(ll.head);
		System.out.println("\nreversed list");
		ll.head=reverse(ll.head);
		ll.printList(ll.head);
	}
	static Node reverse(Node head) {
		if(head==null || head.next==null) return head;
		Node curr = head,temp=null;		
		while(curr!=null){
			//basic swapping logic
			temp=curr.prev;
			curr.prev=curr.next;
			curr.next=temp;
			//moving the pointer to next node
			curr=curr.prev;
		}
		//temp is always the second last element 
		head=temp.prev;
		return head;
	}
}