/*
Remove the size part: if you don't want to stop when the remaining size of the
list is smaller than 'k'
*/
class Reverse_K_group_recur{
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
		System.out.println("Modified list");
		list.printList(reverseGroup(list.head,3,8));
		
	}
	static Node reverseGroup(Node head, int k, int size){
		if(size<k)
			return head;

		Node newHead=null, curr=head, nex=null;
		int count=0;
		while(curr!=null && count<k){
			nex=curr.next;
			newHead=addFirst(newHead,curr);
			curr=nex;
			count++;
		}
		size-=count;
		if(nex!=null)
			head.next=reverseGroup(nex,k,size);
		
		return newHead;
	}
	static Node addFirst(Node head, Node toAdd){
		/*important step: new list fomred is like (newHead)3->2-1->
		So while printing 1.next will point to null*/
		toAdd.next=null;
		if(head==null){
			return head=toAdd;
		}
		toAdd.next=head;

		head=toAdd;
		return head;
	}
}