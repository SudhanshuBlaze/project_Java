/*Delete the current value if the value adjacent(next node) to it is greater,*/
class DeleteGreatValue_I{
	public static void main(String args[]){
		LinkedList list = new LinkedList();
		list.addLast(6);
		list.addLast(5);	
		list.addLast(8);
		list.addLast(2);

		list.printList(delete(list.head));
	}
	static Node delete(Node head){
		if(head==null || head.next==null) return head;
		Node headD= new Node(Integer.MAX_VALUE),dummy=headD, curr=head;
		
		while(curr!=null){
			/*extra condition is added because we want our loop to continue 
			for the last node as well whose next element is null, last element is always
			added so this block is executed where we add the element to the dummy list*/
			if(curr.next==null || curr.data>=curr.next.data){
				dummy.next=curr;
				dummy=dummy.next;
				curr=curr.next;
			}
			else curr=curr.next;
		}

		dummy.next=null;
		return headD.next;
	}
}