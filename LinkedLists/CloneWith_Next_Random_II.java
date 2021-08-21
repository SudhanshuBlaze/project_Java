class CloneWith_Next_Random_II{
	// Structure of linked list Node
	static class Node {
		int data;
		Node next, random;
		Node(int x){
			data = x;
			next = random = null;
		}
	}
	static void print(Node head){
		Node ptr = head;
		while (ptr != null) {
			System.out.println("Data = " + ptr.data+ ", Random = "+ ptr.random.data);
			ptr = ptr.next;
		}
	}

	static Node clone(Node head){
		Node curr = head, front = null;

		/*insert additional node after every node of original list,
		Result:
		sets up next pointer such that next of each element of original list will be 
		pointing to clone nodes and next of clone nodes will pointing to next
		node of original list*/
		while (curr != null) {
			front = curr.next;

			Node copy=new Node(curr.data);
			curr.next=copy;
			copy.next= front;
			curr = front;
		}

		curr = head;
		// set-up the Random pointers of the newly added nodes
		while (curr != null) {
				if(curr.random!= null)
				curr.next.random = curr.random.next;

			/*move to the next to next element of original list
			by skipping an node of clone list*/
			curr = curr.next.next;				
		}

		Node original = head, copyHead = head.next; //save the head of clone list

		Node copy=copyHead;

		/*now separate the original list and copied list,
		set-up next of original and clone list to their respective position*/
		while (original != null) {
			original.next =original.next.next;

			if(copy.next != null)
				copy.next=copy.next.next;
			original = original.next;
			copy = copy.next;
		}
		return copyHead;
	}

	public static void main(String[] args){
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);

		// 1's random points to 3
		head.random = head.next.next;

		// 2's random points to 1
		head.next.random = head;

		// 3's and 4's random points to 5
		head.next.next.random = head.next.next.next.next;
		head.next.next.next.random
			= head.next.next.next.next;

		// 5's random points to 2
		head.next.next.next.next.random = head.next;

		System.out.println("Original list : ");
		print(head);

		System.out.println("Cloned list : ");
		Node cloned_list = clone(head);
		print(cloned_list);
	}
}