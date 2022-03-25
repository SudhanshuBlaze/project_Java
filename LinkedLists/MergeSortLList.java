class MergeSortLList{
	public static void main(String[] args){
		LinkedList list = new LinkedList();
		list.addLast(10);
		list.addLast(4);
		list.addLast(-1);
		list.addLast(8);
		Node tail=list.head;
		while(tail.next!=null)
			tail=tail.next;
		list.printList(sort(list.head));
	}
	static Node merge(Node a, Node b){ 
	    Node result = null; 
	    if (a == null) 
	        return b; 
	    else if(b == null) 
	        return a; 
	    if(a.data < b.data) { 
	        result = a; 
	        result.next = merge(a.next, b); 
	    } 
	    else{ 
	        result = b; 
	        result.next = merge(a, b.next); 
	    } 
	    return result; 
	}
	/*NOTE: if there are 4 nodes we need to stop at 2nd node, which is not the 
	case in usual getMiddle()
	Reason: if there are 2 nodes we need to return 1st node as middle,
	due to this firstHalf will contain one node and second half will contain another
	*/
	static Node getMiddle(Node head){
		Node fast = head,slow=head;
		while(fast.next!=null && fast.next.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	static Node sort(Node head){
		//Only 1 element is left
		if(head==null || head.next==null)
			return head;
		Node mid=getMiddle(head);

		//de-link the firstHalf else it will not hit null instead 
		//it will continue to the secondHalf
		Node nextMid=mid.next;
		mid.next=null;

		Node firstHalf=sort(head);
		Node secondHalf=sort(nextMid);
		return merge(firstHalf,secondHalf);
	}
}


/*
Alt method
static Node getMiddle(Node head,Node tail){
		Node fast = head,slow=head;
		while(fast!=tail && fast.next!=tail){
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	static Node sort(Node head, Node tail){
		if(head==null || head.next==null)
			return head;
		Node mid=getMiddle(head,tail);
		Node nextMid=mid.next;
		mid.next=null;

		Node firstHalf=sort(head,mid);
		Node secondHalf=sort(nextMid,tail);
		return merge(firstHalf,secondHalf);
	}*/