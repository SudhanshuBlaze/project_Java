class QuickSort_Llist{
	public static void main(String args[]){
		LinkedList list = new LinkedList();
		list.addLast(10);
		list.addLast(1);
		list.addLast(5);
		list.addLast(0);
		Node tail=list.head;
    	while(tail.next!=null)
    		tail=tail.next;
    	quickSortRec(list.head,tail);
    	list.printList(list.head);
	}
	static void quickSortRec(Node head,Node tail){      
		if(head==null || tail==null || head==tail) return;
		    Node pivot=partition(head,tail);
		    quickSortRec(head,pivot);
		    quickSortRec(pivot.next,tail);
  		
    }
	static Node partition(Node head,Node tail){

      Node prev=head,curr=head.next;
      //node pivot is head, so we start curr from head.next
      Node pivot=head;

      while(curr!=tail.next){

          if(curr.data<pivot.data){
          	swap(prev.next,curr);
            prev=prev.next;
          }
          curr=curr.next; 
      }
    	swap(pivot,prev);
        return prev;
    }
    static void swap(Node a, Node b){
    	int swapVar=a.data;
    	a.data=b.data;
    	b.data=swapVar;
    }
}