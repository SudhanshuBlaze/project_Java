class DeleteGreatValue_II{
	public static void main(String args[]){
		LinkedList list = new LinkedList();
		list.addLast(6);
		list.addLast(5);	
		list.addLast(8);
		list.addLast(2);
		list.printList(deleteRecur(list.head));
	}
	static Node deleteRecur(Node head){
		if(head.next== null)
			return head;
		Node curr=deleteRecur(head.next);

		if(curr.data>head.data)
			return curr;
		else{
			head.next=curr;
			return head;
		}
	}
}