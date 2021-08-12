class pairSum{
	public static void main(String[] args){
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.addLast(2);
		dll.addLast(4);
		dll.addLast(6);
		dll.addLast(8);
		twoPointer(dll.head,10);
	}
	static void twoPointer( Node head, int x){
	    Node first = head;
	    Node last = head;
	    //move it a the end
	    while (last.next != null)
	        last = last.next;
	 
	    boolean pairFound = false;
	 
	    // The loop terminates when they cross each other (last.next
	    // == first), or they become same (first == last)
	    while (first != last && first.prev != last){
	        // pair pairFound
	        if ((first.data + last.data) == x){
	            pairFound = true;
	            System.out.println( "(" + first.data +", "+ last.data + ")" );
	 
	            first = first.next;
	            last = last.prev;
	        }
	        else{
	            if ((first.data + last.data) < x)
	                first = first.next;
	            else
	                last = last.prev;
	        }
	    }
	    if (pairFound == false)
	        System.out.println("No pair pairFound");
		}
}