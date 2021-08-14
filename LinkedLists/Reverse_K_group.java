/*
Reverse group of size 'k' in a LinkedList

Approach of nested for-loop: we need to reverse k-1 links. So, we start from k=1 
Ex.when k=3, list=1->2->3, there are 2 links to be reversed
*/

class Reverse_K_group{
	public static void main(String args[]){
		LinkedList list = new LinkedList();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		list.addLast(6);
		list.addLast(7);
		list.addLast(8);
		list.printList(reverseGroup(list.head,3));
		
	}
	static Node reverseGroup(Node head, int k){
		if(head==null || k==1) return null;  //corner case
		Node dummy=new Node(0);
		dummy.next = head;
		//Initially prev is at dummy node, so in the first iteration whenever the value of
		// prev.next changed dummy's value is also changed
		// after the first iteration prev=curr and curr moves one step forward.
		Node curr=head, prev=dummy, nex=dummy;
		int count=0;
		for(curr=head; curr!= null; curr=curr.next) count++; //size of linked list

		while(count>=k){
			//curr points to first element of the group for entire iteration of that grp
			curr = prev.next; //don't do curr=curr.next because
			// initially it's pointing to null, due to previous size count for-loop

			//nex pointer moves in between iterations
			nex=curr.next;
			for(int i=1;i<k;i++){
				/*Note: in this loop, curr and prev pointers are not moving
				just there .next pointer is moving by 1 step at each iteration
				curr.next and prev.next is used for preserving the location*/

				curr.next =nex.next;  //storing the nex.next pointer which will be 
				//assigned to nex at the end, this step also helps in reversing the group
				nex.next=prev.next;  // Main-reversal process
				prev.next = nex;	
				nex=curr.next;     //moves forward using curr.next pointer
			}
			prev=curr;
			count-=k;
			/*on reversing curr becomes the last element of the grp, so we 
			point prev to last element of the grp(which is curr) and move curr to next
			Ex. (curr)1->2->3->4 on reversal 3->2->1(curr)->4 
			on next step 3->2->1(prev)->(curr)4 */
		}
		return dummy.next;
	}
}