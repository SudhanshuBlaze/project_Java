class MoveLastToFront{
	public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.addLast(21);
        list.addLast(5);
        list.addLast(30);
        list.addLast(7);
        list.addLast(9);
        Node head=list.head;
        list.printList(moveLast(head));
    }
    static Node moveLast(Node head){
    	if(head==null || head.next==null) return head;
    	Node curr=head;
        //moves to the last but 1 node or second last node
    	while(curr.next.next!=null) curr=curr.next;
    	Node next=curr.next;
    	curr.next=null;
    	next.next=head;
    	head=next;
    	return head; //Note:return new head; 
    	//This step is to performed when head is modified
    }
}