class PalindromeLList_II{
	public static void main(String[] args){
		LinkedList ll=new LinkedList();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.addLast(20);
		ll.addLast(11);
		Node head=ll.head; 
		System.out.println("Is Palin: "+checkPalin(head));
		ll.printList(head);
	}
	static boolean checkPalin(Node head) {
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
		boolean flag=true;
		while(slow!=null){
			if(slow.data!=newEntry.data){
				flag=false;
			}
			slow=slow.next;
			newEntry=newEntry.next;
		}

		//restoring the state of Linked list(Optional)
		slow=head;
		fast=head;
		//find the middle of linked list in O(N/2)
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		// reverse the 2nd half
		slow.next=reverse(slow.next);
		return flag;
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