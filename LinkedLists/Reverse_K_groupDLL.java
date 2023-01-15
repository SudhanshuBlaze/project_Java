/*
Reverse group of size 'k' in a LinkedList

Approach of nested for-loop: we need to reverse k-1 links. So, we start from k=1 
Ex.when k=3, list=1->2->3, there are 2 links to be reversed

<-3<-2<-1
*/

class Reverse_K_groupDLL{
	public static void main(String args[]){
		DoublyLinkedList list = new DoublyLinkedList();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		list.addLast(6);
		list.addLast(7);
		list.addL`ast(8);
		System.out.println("Modified list");
		Node res=reverseGroup(list.head,3);
		list.printList(res);
		
		System.out.println("\nReversed Modified list");
		while(res.next!=null) res=res.next;
		while(res!=null){
			System.out.print(res.data+"<->");
			res=res.prev;
		}
	}
	// 3->->2->1
	static Node reverseGroup(Node head, int k){
		Node newHead=null, curr=head, nex=null;
		int count=0;
		while(curr!=null && count<k){
			nex=curr.next;
			newHead=addFirst(newHead,curr);
			curr=nex;
			count++;
		}
		if(nex!=null){
			head.next=reverseGroup(nex,k);
			System.out.println("head: "+head.data);
			head.next.prev=head;  //remember: nex!=null
		}
		return newHead;
	}
	static Node addFirst(Node head, Node toAdd){
		toAdd.next=null;
		toAdd.prev=null;
		if(head==null){
			return head=toAdd;
		}
		toAdd.next=head;
		head.prev=toAdd;

		head=toAdd;
		return head;
	}
}


