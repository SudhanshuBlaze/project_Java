class IntersectionOfSortedLList{
	public static void main(String[] args){
		LinkedList l1 = new LinkedList();
        l1.addLast(1);
        l1.addLast(2);
        l1.addLast(3);
        l1.addLast(4);
        l1.addLast(6);
        Node h1=l1.head;

        LinkedList l2 =new LinkedList();
        l2.addLast(2);
        l2.addLast(4);
        l2.addLast(6);
        l2.addLast(8);
        Node h2=l2.head;

        System.out.println("Intersection of sorted List: ");
        l1.printList(findInterSection(h1,h2));
	}
	static Node findInterSection(Node l1, Node l2){
		Node resHead=new Node(0);  //dummy value in first node-> 0
		Node curr=resHead;  //this node will be used for iteration
		while(l1!=null && l2!=null){
			if(l1.data>l2.data)
				l2=l2.next;
			else if(l1.data<l2.data)
				l1=l1.next;
			else{
				curr.next=new Node(l1.data);
				curr=curr.next;
				l1=l1.next;
				l2=l2.next;
			}
		}
		return resHead.next;
	}
}