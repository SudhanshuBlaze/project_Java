class SegregateOddEven{
	public static void main(String args[]){
		LinkedList list = new LinkedList();
		for(int i = 0; i <=10;i++){
			list.addLast(i);
		}
		// list.addLast(1);
		// list.addLast(2);
		list.printList(segregate(list.head));
	}
	static Node segregate(Node head){
		Node oddHead=new Node(-1), evenHead=new Node(-1);
		Node curr=head, even = evenHead, odd=oddHead;
		while(curr!=null){
			if(curr.data%2==0){
				even.next=curr;
				even=even.next;
			}
			else{
				odd.next=curr;
				odd=odd.next;
			}
			curr=curr.next;
		} 
		curr=head;
		even.next=oddHead.next;
		odd.next=null;  //imp step, while printing it will go into infinite loop
		return evenHead.next;
	}
}