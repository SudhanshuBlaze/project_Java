class Nth_Node_fromLast{
	public static void main(String args[]){
		LinkedList list = new LinkedList();
		// for(int i = 1; i <=10; i++)
		// 	list.addLast(i);
		list.addLast(1);
		list.addLast(2);

		System.out.println("nth element: "+find(list.head,2));
	}
	//1,2,3,4,5,6,7,8,9,10
	static int find(Node head, int nth) {
		int size=0;
		Node curr=head;
		while(curr!=null){
            size++;
            curr=curr.next;
        }
        System.out.println("Size: " + size);
        if(nth>size)
            return -1;

		int nIter=size-nth;
		curr=head;
		for(int i=1; i<=nIter; i++){
			curr = curr.next;
		}
		return curr.data;
	}
}