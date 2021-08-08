class PalindromeLList{
	public static void main(String[] args){
		LinkedList ll=new LinkedList();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.addLast(30);
		ll.addLast(20);
		ll.addLast(10);
		Node head=ll.head; 
		System.out.println("Is Palin: "+checkPalin(head));
		ll.printList(head);
	}
	static boolean checkPalin(Node head) {
		//special case for 2 elements linked list
		if(head.next!=null && head.next.next== null && head.data!=head.next.data)
			return false;

		Node slow=head,fast=head;
		//find the middle of linked list in O(N/2)
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		// reverse the 2nd half
		slow.next=reverse(slow.next);
		slow=slow.next;  //NOTE: move slow pointer to starting of 2nd half
		Node newEntry=head;
		while(slow!=null){
			if(slow.data!=newEntry.data){
				return false;
			}
			slow=slow.next;
			newEntry=newEntry.next;
		}
		return true;
	}
	static Node reverse(Node curr) {
		Node prev=null,next=null;
		while(curr!=null){
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		return prev;
	}
}