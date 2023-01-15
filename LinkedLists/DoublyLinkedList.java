class Node {
	int data;
	Node next,prev;
	Node(int data){
		this.data = data;
		next=null;
		prev=null;
	}
}
public class DoublyLinkedList{
	//Don't make it static, we want different for different LinkedList instances
	Node head=null;
	boolean isEmpty() {return head==null;}

	void printList(Node head){
		Node temp=head;
		//terminate loop when temp becomes null
		while(temp!=null){
			System.out.print(temp.data+"<->");
			temp=temp.next;
		}
	}
	void addLast(int data){
		Node temp= head;
		if(head==null){
			head=new Node(data); 
			return;   //end 
		}
		//terminate loop when at last node
		while(temp.next!=null)
			temp= temp.next;
		Node toAdd=new Node(data);
		temp.next=toAdd;
		toAdd.prev=temp;
	}

	void addFirst(int data){
		if(head==null){
			head=new Node(data); 
			return;   //end 
		}
		//terminate loop when at last node
		Node toAdd=new Node(data);
		toAdd.next =head;
		head.prev=toAdd;
		head=toAdd;
	}
	
	public static void main(String args[]){
		DoublyLinkedList ll = new DoublyLinkedList();
		ll.addLast(10);
		ll.addLast(1);
		ll.addLast(3);
		ll.addFirst(9);
		ll.printList(ll.head);
	}
}



