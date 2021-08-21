/*
Approach: the head of the resultant list will always be the current max element or
it will always be the largest element in the resulting list at the moment
-> We have used this value to compare whether the new value occured is greater than
the result list head or not, if condition is false, then we return the result list head,
else we point the "next" of current element to the result list head and return the curr element

->Here, head represents the current element, the value of head is occured in reverse order,
this helps us determine the new max element by comparison.

SUMMARY: We are traversing the list in reverse order and if the new greatest element 
comes we add it to the result Head.*/
class DeleteGreatValue_II{
	public static void main(String args[]){
		LinkedList list = new LinkedList();
		list.addLast(6);
		list.addLast(5);	
		list.addLast(8);
		list.addLast(2);
		list.head=deleteRecur(list.head);
		list.printList(list.head);
	}
	static Node deleteRecur(Node head){
		if(head.next== null)
			return head;
		Node resHead=deleteRecur(head.next);

		//don't add current node in the list, as bigger element is present on its right
		if(resHead.data>head.data)
			return resHead;
		//new max found, add the new element to the result list
		else{
			head.next=resHead;
			return head;
		}
	}
}