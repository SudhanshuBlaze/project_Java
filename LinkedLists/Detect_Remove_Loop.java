 class Detect_Remove_Loop{
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
 
        // Creating a loop for testing
        head.next.next.next.next.next = head.next.next;
        detectAndRemoveLoop(head);
        
        System.out.println("Linked List after removing loop : ");
        list.printList(head);
    }
    static int detectAndRemoveLoop(Node node){
        Node slow = node, fast = node;
        while (slow != null && fast != null
               && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet at same point then loop
            // is present
            if (slow == fast) {
                removeLoop(slow, node);
                return 1;
            }
        }
        return 0;
    }
 
    // Function to remove loop
    static void removeLoop(Node loop, Node curr){
        Node ptr1 = null, ptr2 = null;
 
        /* Set a pointer to the beginning of the Linked List
         and move it one by one to find the first node which
         is part of the Linked List */
        ptr1 = curr;
        while (1 == 1) {
 
            /* Now start a pointer from loop_node and check
             if it ever reaches ptr2 */
            ptr2 = loop;
            while (ptr2.next != loop && ptr2.next != ptr1) {
                ptr2 = ptr2.next;
            }
 
            /* If ptr2 reahced ptr1 then there is a loop. So
             break the loop */
            if (ptr2.next == ptr1) {
                break;
            }
 
            /* If ptr2 did't reach ptr1 then try the next
             * node after ptr1 */
            ptr1 = ptr1.next;
        }
 
        /* After the end of loop ptr2 is the last node of
         the loop. So make next of ptr2 as NULL */
        ptr2.next = null;
    }
}