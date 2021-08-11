class DeletionCircularList{
	public static void main(String args[]){
		LinkedList list = new LinkedList();
        list.addLast(2);
        // list.addLast(15);
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
        printCircularList(deletion(list.head,2));
	}

	static Node deletion(Node head, int key){
        if (head == null) return null;
        ////if only one node is present and its the key
        if(head.next==head && head.data==key) return head=null;

        // Find the required node
        Node curr = head, prev =head;
        while (curr.data != key) {
            if (curr.next == head) {
                System.out.printf("\nGiven node is not found"+ " in the list!!!");
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        //CASE:1 if it is First node
        if (curr == head) {
        	//move prev to last node or previous to head/curr
            while (prev.next != head) prev = prev.next;
            head = curr.next;
            prev.next = head;
        }
 
        //CASE:2 if it is Last node
        else if (curr.next == head)
            prev.next = head;
        //CASE:3 if it is in the middle    
        else
            prev.next = curr.next;

        return head;
    }
    static void printCircularList(Node head){
    	if(head==null) return;
 		Node curr = head;
 		do{
 			System.out.print(curr.data+"->");
 			curr = curr.next;
 		} while(curr!=head);
 		System.out.println();
 	}
}