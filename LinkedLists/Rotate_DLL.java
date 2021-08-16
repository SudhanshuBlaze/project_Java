class Rotate_DLL{
	public static void main(String[] args){
	    DoublyLinkedList list = new DoublyLinkedList();
	    list.addLast(1);
	    list.addLast(2);
	    list.addLast(3);
	    list.addLast(4);
	    list.addLast(5);
	 	list.addLast(6);
	 
	    System.out.println("Given linked list ");
	    list.printList(list.head);
	    System.out.println();
	    System.out.println("Rotated Linked list ");
	    list.printList(rotate(list.head,7));
	}
	static Node rotate(Node head, int r){
		Node curr =head, nth=null;
		int n=0;
		//curr stops at tail
		while(curr.next!=null){
			if(n==r-1)
				nth=curr;
			curr = curr.next;
			n++;
		}
		//corner case when number of rotations is 0 or >= length of list
		if(r==0 || nth==null)
			return null;
		//connect tail with head
		curr.next=head;
		head.prev=curr;

		head=nth.next; //point head to new head location
		
		//de-link nth node
		nth.next=null;
		head.prev=null;
		return head;
	}
}