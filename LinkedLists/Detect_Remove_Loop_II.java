/*Approach: 
    dist by fast= 2(dist by slow)
    => L1+L2+nC=2(L1+L2)       
    => nC=L1+L2 
    => L1=nC-L2
    Where,L1 is length from Head to cycleHead,
    L2 is length from cycleHead to meetPoint, 'nC' is number of rotations or circles,
    C= length of cycle

Approach of remove(): 
    We have 2 pointers: meetPoint and newEntry(=head)
    from the meetpoint increment the meetpoint pointer and newEntry pointer one by one

Working: 
    In the beginning the slow and fast pointer start from same position, 
    dist between them is 0, on first iteration dist becomes 1, second iteration dist becomes 2,
    with every iteration distance between slow and fast pointers increase by 1,

    So when the distance between them becomes equal to the lenght of the Cycle or Loop,
    they meet.
    NOTE: In case of Circular LinkedList where tail points to head, slow and fast pointer always
    meets where they start from, if they start from HEAD they meet at HEAD*/
class Detect_Remove_Loop_II{
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
        
        Node tempHead=head;  //lets see how our loop looks
        for(int i=0;i<7;i++) {
            System.out.print(tempHead.data+"->");
            tempHead=tempHead.next;
        }
        System.out.println("\nLoop found: "+detectAndRemoveLoop(head));
        
        System.out.print("Linked List after removing loop: ");
        list.printList(head);
    }
    static boolean detectAndRemoveLoop(Node head){
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet at same point then loop is present
            if (slow == fast) { 
                removeLoop(slow, head);
                return true;
            }
        }
        return false;
    }

    // Function to remove loop-> O(N^2)
    static void removeLoop(Node meetPoint, Node head){
        Node newEntry=head;
        if(newEntry!=meetPoint){
            while(meetPoint.next!=newEntry.next){
                meetPoint=meetPoint.next;
                newEntry=newEntry.next;
            }
            meetPoint.next=null;  //terminate loop
        }
        /* Corner case: if fast and slow pointer meet at first position of cycle*/
        else{
            while(meetPoint.next!=newEntry){
                meetPoint=meetPoint.next;  //finding the tail
            }
            //this will lead to Tail or element previous of Head
            meetPoint.next=null;  //terminate loop
        }
     }
}


