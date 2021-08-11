class SplitCircularLList{
	public static void main(String args[]) {
		LinkedList list = new LinkedList();
        // list.addLast(2);
        list.addLast(15);
        // list.addLast(20);
        // list.addLast(13);
        // list.addLast(1);

        	//making the loop circular, by pointing last node to head of list
	        Node curr=list.head;
	        while(curr.next !=null)
	        	curr=curr.next;
	        curr.next=list.head;
        System.out.println("Original List");
        printCircularList(list.head);
        System.out.println("Split Lists:");
        split(list.head);
 	}
 	static void printCircularList(Node head){
 		Node curr = head;
 		do{
 			System.out.print(curr.data+"->");
 			curr = curr.next;
 		} while(curr!=head);
 		System.out.println();
 	}
 	static void split(Node head){
        if(head.next==head){ //if only one element present in Circular list
            System.out.println(head.data+"->");
            return;
        }
 		Node slow = head,fast=head;
 		//find middle
 		while(fast.next!=head && fast.next.next!=head){
 			slow=slow.next;
 			fast=fast.next.next;
 		}
 		/*if odd num of elements then fast stops at last node, 
 		but in case of even number of elements then we manually need to increment by 1*/
 		if(fast.next!=head)
 			fast=fast.next;

 		Node head1=head;
 		Node head2=slow.next;
 		slow.next=head1;
 		fast.next=head2;

 		System.out.print("1st half: ");
 		printCircularList(head1);
 		System.out.print("2nd half: ");
 		printCircularList(head2);
 	}
}



