/*
Reverse group of size 'k' in a LinkedList
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

		Node curr=head, prev=dummy, nex=dummy;
		int count=0;
		for(curr=head; curr!= null; curr=curr.next) count++;

		while(count>=k){
			curr = prev.next;   //first element of the group
			nex=curr.next;		//second element of the group
			/*we need to reverse k-1 links. So, we start from k=1
			Ex. when k=3, list=1->2->3, there are 2 links to be reversed*/
			for(int i=1;i<k;i++){
				
			}
		}
		return dummy.next;
	}
}