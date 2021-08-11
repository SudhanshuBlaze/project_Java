class Node {
	int data;
	Node next;
	Node(int data){
		this.data = data;
		next=null;
	}
}
public class LinkedList{
	//Don't make it static, we` want different for different LinkedList instances
	Node head=null;
	boolean isEmpty() {return head==null;}

	void printList(Node head){
		Node temp=head;
		//terminate loop when temp becomes null
		while(temp!=null){
			System.out.print(temp.data+"->");
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
		temp.next=new Node(data);
	}

	public static void main(String args[]){
		LinkedList ll = new LinkedList();
		ll.addLast(10);
		ll.addLast(1);
		ll.addLast(3);
		ll.printList(ll.head);
	}
}



