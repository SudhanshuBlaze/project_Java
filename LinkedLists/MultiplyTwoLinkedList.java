/*Pre-requisite: https://www.geeksforgeeks.org/modulo-1097-1000000007/
*/
class MultiplyTwoLinkedList{
	   public static void main(String args[]){
        // create first list 9->4->6
        LinkedList l1 = new LinkedList();
        l1.addLast(9);
        l1.addLast(4);
        l1.addLast(6);
        System.out.print("First list is: ");
        l1.printList(l1.head);
 
        // create second list 8->4
       LinkedList l2 = new LinkedList();
        l2.addLast(9);
        l2.addLast(4);
        l2.addLast(6);
        System.out.print("\nSecond list is: ");
        l2.printList(l2.head);
 
        // Multiply the two lists and see result
        System.out.print("\nResult is: ");
        System.out.println(multiply(l1.head, l2.head));
    }
    static long multiply(Node l1, Node l2) {
    	long p=10^9+7;  //big prime number
    	long n1=0,n2=0;
    	while(l1!=null || l2!=null){
    		if(l1!=null){
    			n1+= (n1*10)%p+l1.data;
    			l1=l1.next;
    		}
    		if(l2!=null){
    			n2+=(n2*10)%p+l2.data;
    			l2=l2.next;
    		}
    	}
    	return ((n1%p)*(n2%p))%p;
    }
}