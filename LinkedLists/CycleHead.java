/*
Approach: 
dist by fast= 2(dist by slow)
2(L1+L2)= L1+L2+nC
            
        L1+L2= nC 
        => L1=nC-L2
        Where,L1 is length from Head to cycleHead,
        L2 is length from cycleHead to meetPoint 

NOTE: In case of Circular LinkedList where tail points to head, slow and fast pointer always
meets where they start from, if they start from HEAD they meet at HEAD
*/
class CycleHead{
   public static void main(String[] args){
        LinkedList list = new LinkedList();
        // list.head = new Node(50);
        // list.head.next = new Node(20);
        // list.head.next.next = new Node(15);
        // list.head.next.next.next = new Node(4);
        // list.head.next.next.next.next = new Node(10);
        list.addLast(50);
        list.addLast(20);
        list.addLast(15);
        list.addLast(4);
        list.addLast(10);
        Node head=list.head;
        // Creating a loops for testing
        head.next.next.next.next.next = head.next.next;
        // head.next.next.next.next.next=head;  //triggers corner case
        //lets see how our loop looks
        Node tempHead=head;
        for(int i=0;i<7;i++) {
            System.out.print(tempHead.data+"->");
            tempHead=tempHead.next;
        }
        System.out.println("\nCycle Head: "+detectLoop(head).data);
    }
    static Node detectLoop(Node head){
        Node slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return loopHead(slow,head);
            }
        }
        return null;
    }

    // Function to remove loop-> O(N^2)
    static Node loopHead(Node meetPoint, Node head){
        Node newEntry=head;
        while(newEntry!=meetPoint){
            newEntry=newEntry.next;
            meetPoint=meetPoint.next;
        }
        return meetPoint;
    }
}


