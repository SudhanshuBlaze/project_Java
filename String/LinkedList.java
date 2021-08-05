public class LinkedList{
	static Node head;
	static class Node{
		int data;
		Node next;
		public Node(int data){
			this.data = data;
			next=null;
		}
	}
	void addLast(int data){
		Node temp= head;
		if(head==null)
			head=new Node(data);
		while(temp.next!=null){
			temp= temp.next;
		}
		temp.next=new Node(data);
	}

}  



