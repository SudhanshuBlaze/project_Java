class Node<T> {
	T data;
	Node<T> next;
	Node(T data){
		this.data = data;
		next=null;
	}
}
public class LinkedListG<T>{
	Node<T> head;
	boolean isEmpty() {return head==null;}

	void printList(Node <T> head){
		Node<T> temp=head;
		//terminate loop when temp becomes null
		while(temp!=null){
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
	}

	void addLast(T data){
		Node<T> temp= head;
		if(head==null){
			head=new Node<T>(data); 
			return;   //end 
		}
		//terminate loop when at last node
		while(temp.next!=null)
			temp= temp.next;
		temp.next=new Node<T>(data);
	}

	public static void main(String args[]){
		LinkedListG<Integer> ll = new LinkedListG<>();
		ll.addLast(10);
		ll.addLast(1);
		ll.addLast(3);
		ll.printList(ll.head);
	}
}



