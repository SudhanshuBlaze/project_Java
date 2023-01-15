//unsorted linked_list
import java.util.*;
class RemoveDuplicates_II{
	public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.addLast(30);
        list.addLast(5);
        list.addLast(30);
        list.addLast(30);
        list.addLast(5);
        Node head=list.head;
        removeDuplicates(head);
        System.out.print("Linked List after removing Duplicates: ");
        list.printList(head);
    }
    static void removeDuplicates(Node head) {
    	if(head==null) return;
    	Node curr=head;
    	HashSet<Integer> set=new HashSet<Integer>();
    	set.add(curr.data);
    	//note: condition, if curr.next is null then curr.next.data is not possible
    	while(curr.next!=null){
    		if(set.contains(curr.next.data)){
    			removeNode(curr,curr.next);
    		}
    		else{
    			set.add(curr.next.data);
    			curr=curr.next;
    		}
    	}
    }
    //we make it static, because we cannot call this function from a static function 
    //if its non-static, and to call it from a non-static function(removeDuplicates), 
    //we must call it from main which is only possible by making an object
    static void removeNode(Node prev,Node curr){
    	prev.next=curr.next;
    	curr.next=null;
    }
}