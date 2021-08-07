/* remove function takes O(N^2) time
Approach of remove(): run the meet pointer entirely in the loop an check whether start pointer 
has reached the loop head or not.
*/
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
        System.out.println("Loop found: "+detectAndRemoveLoop(head));
        
        System.out.print("Linked List after removing loop: ");
        list.printList(head);
    }
    static boolean detectAndRemoveLoop(Node head){
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet at same point then loop
            // is present
            if (slow == fast) {
                removeLoop(slow, head);
                return true;
            }
        }
        return false;
    }
 
    // Function to remove loop-> O(N^2)
    static void removeLoop(Node meetPoint, Node head){
        Node newEntry = head, inLoop = null;
         // Set a pointer to the beginning of the Linked List
         // and move it one by one to find the first node which is part of the Loop
        newEntry = head;
        while (true) {
            /* Now newEntry a pointer from meetPoint_node and check if it ever reaches inLoop */
            inLoop = meetPoint;  //re-initialize
            //note: here inLoop is running only upto the prev node of meetPoint
            while (inLoop.next != meetPoint && inLoop.next != newEntry) {
                inLoop = inLoop.next;
            }
            //check whether newEntry pointer is arrived upto the meetPoint or not
            if (inLoop.next == newEntry) {
                inLoop.next = null;   // terminate loop
                break;
            }
             // If inLoop did't reach newEntry then try the next node after newEntry 
            newEntry = newEntry.next;
        }
     }
}