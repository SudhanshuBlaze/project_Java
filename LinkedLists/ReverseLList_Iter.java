class ReverseLList_Iter{
	public static void main(String args[]){
		// LinkedList<Integer> ll=new LinkedList<>();
		// ll.addLast(10);
		// ll.addLast(20);
		// ll.addLast(30);
		LinkedListG<String> ll=new LinkedListG<String>();
		ll.addLast("What");
		ll.addLast("is");
		ll.addLast("Up!");
		ll.printList(reverse(ll.head));
	}
	static Node<String> reverse(Node<String> head) {
		if(head==null || head.next==null) return null;
		//atleast 2 elements in LinkedList
		Node<String> prev = null,curr = head, next = null;
		while(curr!=null){
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		head=prev;
		return head;
	}
}