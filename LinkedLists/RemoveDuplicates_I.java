//Sorted Linked list
class RemoveDuplicates_I{
	public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.addLast(5);
        list.addLast(5);
        list.addLast(30);
        list.addLast(30);
        list.addLast(30);
        Node head=list.head;
        removeDuplicates(head);
        System.out.print("Linked List after removing Duplicates: ");
        list.printList(head);
    }
    static void removeDuplicates(Node head) {
    	if(head==null) return;
    	Node curr=head;
    	//note: condition, if curr.next is null then curr.next.data is not possible
    	while(curr.next!=null){
    		if(curr.data==curr.next.data){
    			removeNode(curr,curr.next);
    			System.out.println("hit! "+curr.data);
    		}
    		else
    			curr=curr.next;
    	}
    }
    static void removeNode(Node prev,Node curr){
    	prev.next=curr.next;
    	curr.next=null;
    }
}