// Time complexity: O(N+M)
class IntersectionOfLList{
	public static void main(String[] args){
        // list 1
        LinkedList obj= new LinkedList();
        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(3);
        l1.next.next.next = new Node(4);
        l1.next.next.next.next = new Node(5);
        l1.next.next.next.next.next = new Node(6);
        l1.next.next.next.next.next.next = new Node(7);

        // list 2
        Node l2 = new Node(10);
        l2.next = new Node(9);
        l2.next.next = new Node(8);
        //creating Intersection point 
        l2.next.next.next = l1.next.next.next;
        obj.printList(l1);
        System.out.println();
        obj.printList(l2);
        System.out.println("\nPoint of Intersection: "+findInterSection(l1, l2));
    }
    static int findInterSection(Node l1, Node l2){
    	if(l1==null || l2==null)
    		return -1;
    	Node a=l1;
    	Node b=l2;
    	/*NOTE: if there is no intersection point the a,b will become null at the same time,
         and then they will be equal, this will terminate the loop*/
    	while(a!=b){
    		a= a==null ? l2:a.next;
    		b= b==null ? l1:b.next;
    	}
    	if(a==null)
    		return -1;
    	return a.data;
    }
}