class AddTwoLList{
	public static void main(String args[]){
        // Node h1=new Node(2);
        // h1.next=new Node(4);
        // h1.next.next=new Node(3);

        // Node h2=new Node(5);
        // h2.next=new Node(6);
        // h2.next.next=new Node(7);
        // h2.next.next.next=new Node(9);

        LinkedList l1 = new LinkedList();
        l1.addLast(2);
        l1.addLast(4);
        l1.addLast(3);
        //342
        Node h1=l1.head;

        LinkedList l2 =new LinkedList();
        l2.addLast(5);
        l2.addLast(6);
        l2.addLast(7);
        l2.addLast(9);
        //9765
        Node h2=l2.head;

        l1.printList(h1);
        System.out.println();
        l1.printList(h2);
        System.out.println("\nResultant sum: ");  //sum of 342+9756 = 10107
        l1.printList(addBoth(h1,h2));
	}
	static Node addBoth(Node l1, Node l2){
		Node resHead = new Node(-1);
		Node curr=resHead;
		int sum,carry=0;
		while(l1!=null || l2!=null || carry==1){
			sum=0;
			if(l1!=null){
				sum+=l1.data;
				l1=l1.next;
			}
			if(l2!=null){
				sum+=l2.data;
				l2=l2.next;
			}
			sum+=carry;
			//carry would be there if number is >=10 so we divide by 10, 
			//if it gives then carry of 1
			carry=sum/10;  
			curr.next=new Node(sum%10);			
			curr=curr.next;
		}
		return resHead.next;
	}
}