class AddOneLList{
	public static void main(String args[]){
		LinkedList ll=new LinkedList();
		ll.addLast(1);
		ll.addLast(9);
		ll.addLast(3);
		ll.addLast(3);
		ll.addLast(8);
		ll.addLast(9);
		ll.addLast(9);
		Node head=ll.head; 
		addOne(head);
		ll.printList(head);
	}
	static void addOne(Node head) {
		Node curr=head, last9=head;
		if(head.next == null){
			head.data+=1; 
			return;
		}
		/*This loop is used to move last9: pointer will go upto the second last node 
		from the last 9, and if there is no 9 then it will go to the end and add 1;*/
		while(curr!=null){
			if(curr.data!=9){
				last9=curr;
			}
			curr=curr.next;
		}
		last9.data+=1;
		last9=last9.next;
		//make all the nine 0, after adding 1 to the second last element from last 9
		while(last9!=null){
			last9.data=0;
			last9=last9.next;
		}
	}
}