/*Space complexity: O(1)
There's no way to acess the unsorted list after UPDATING head at the end*/
class Sort012 {
	public static Node sortList(Node head){
		if(head==null || head.next==null)
			return null;
		
		/* Create three dummy nodes to point to beginning of three linked lists. These
		dummy nodes are created to avoid many null checks.*/
		Node zeroD = new Node(-1);
		Node oneD = new Node(-1);
		Node twoD = new Node(-1);

		Node zero = zeroD, one = oneD, two = twoD;
		Node curr = head;
		while (curr!=null){
			if (curr.data == 0){
				zero.next = curr;
				zero = zero.next;
				curr = curr.next;
			}
			else if (curr.data == 1){
				one.next = curr;
				one = one.next;
				curr = curr.next;
			}
			else{
				two.next = curr;
				two = two.next;
				curr = curr.next;
			}
		}
		// MOST IMPORTANT PART: Linking three lists
		//if one.next== null then directly link zero->two
		zero.next = (oneD.next!=null) ?(oneD.next) : (twoD.next);
		one.next = twoD.next;
		two.next = null;
		// Note: Update head
		head = zeroD.next;  //O(1) space
		return head;
	}

	public static void main(String args[]) {
		LinkedList list = new LinkedList();
		list.addLast(2);
		list.addLast(1);
		list.addLast(2);
		list.addLast(2);
		System.out.println("Linked List Before Sorting");
		list.printList(list.head);
		list.head=sortList(list.head);
		System.out.println("\nLinked List After Sorting");
		list.printList(list.head);
	}
}
