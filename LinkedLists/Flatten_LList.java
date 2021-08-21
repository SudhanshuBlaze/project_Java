class Flatten_LList{
	Node head;
	class Node
	{
		int data;
		Node next, bottom;
		Node(int data)
		{
			this.data = data;
			next = null;
			bottom = null;
		}}

	Node merge(Node a, Node b){
		// if first linked list is empty then second is the answer
		if (a == null)	 return b;

		// if second linked list is empty then first is the result
		if (b == null)	 return a;

		// compare the data members of the two linked lists
		// and put the larger one in the result
		Node result;

		if (a.data < b.data){
			result = a;
			result.bottom = merge(a.bottom, b);
		}

		else{ //b.data<=a.data
			result = b;
			result.bottom = merge(a, b.bottom);
		}
		/*NOTE: this step is to de-link the next of head of LinkedList Node of each column
		However its an optional step as online compiler won't be checking this step*/
		result.next = null;
		return result;
	}

	Node flatten(Node root){
		if(root==null || root.next==null)
			return root;
		
		root.next=flatten(root.next);		 
		return merge(root, root.next);
	}

	Node push(Node head_ref, int data){
		/* 1 & 2: Allocate the Node &
				Put in the data*/
		Node new_node = new Node(data);

		/* 3. Make next of new Node as head */
		new_node.bottom = head_ref;

		/* 4. Move the head to point to new Node */
		head_ref = new_node;

		/*5. return to link it back */
		return head_ref;}

	void printList()
	{
		Node temp = head;
		while (temp != null)
		{
			System.out.print(temp.data + " ");
			temp = temp.bottom;
		}
		System.out.println();}

	public static void main(String args[]){
		Flatten_LList L = new Flatten_LList();

		/* Let us create the following linked list
			5 -> 10 -> 19 -> 28
			| |	 |	 |
			V V	 V	 V
			7 20 22 35
			|		 |	 |
			V		 V	 V
			8		 50 40
			|			 |
			V			 V
			30			 45
		*/

		L.head = L.push(L.head, 30);
		L.head = L.push(L.head, 8);
		L.head = L.push(L.head, 7);
		L.head = L.push(L.head, 5);

		L.head.next = L.push(L.head.next, 20);
		L.head.next = L.push(L.head.next, 10);

		L.head.next.next = L.push(L.head.next.next, 50);
		L.head.next.next = L.push(L.head.next.next, 22);
		L.head.next.next = L.push(L.head.next.next, 19);

		L.head.next.next.next = L.push(L.head.next.next.next, 45);
		L.head.next.next.next = L.push(L.head.next.next.next, 40);
		L.head.next.next.next = L.push(L.head.next.next.next, 35);
		L.head.next.next.next = L.push(L.head.next.next.next, 20);

		// flatten the list
		L.head = L.flatten(L.head);

		L.printList();
	}
}