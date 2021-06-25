import java.util.*;
class References_Mutable_Obj{
	public static void main(String[] args){
		//CASE:1
		List<Integer> sub1=new ArrayList<Integer>();
		sub1.add(99);
		sub1.add(199);
		List<Integer> sub2=sub1; //this happens because i haven't used new keyword to create sub2
		sub2.add(11);  //it gets added even in first arrayList
		sub2.addAll(sub1);  //everything gets added to even sub1
		System.out.println("Print second arrayList: "+sub2);
		System.out.println("Print first arrayList: "+sub1 +"\n");

		//CASE:2
		List<Integer> sub3=new ArrayList<Integer>();
		sub3.add(99);
		sub3.add(199);
		// List<Integer> sub4=new ArrayList<Integer>(sub3);
		List<Integer> sub4=new ArrayList<Integer>(); // "new" keyword creates a new reference
		sub4.add(11);
		sub4.addAll(sub3); 
		System.out.println("Print second arrayList: "+sub3);
		System.out.println("Print first arrayList: "+sub4);


	}
}