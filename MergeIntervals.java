
import java.util.*;
 class MergeIntervals { 
	public static void mergeIntervals(Interval arr[]) { 
		// Empty array 
		if (arr.length == 0) 
			return; 
	
		// Create an empty stack of class Intervals(User-Defined data type) 
		Stack<Interval> stack=new Stack<>(); 
	
		// sort the intervals in increasing order of start time (Ascending order)
		// Arrays.sort(arr,new Comparator<Interval>(){ 
		// 	public int compare(Interval i1,Interval i2) 
		// 	{ 
		// 		return i1.start-i2.start; 
		// 	} 
		// }); 
		
		Arrays.sort(arr,(i1,i2) -> i1.start-i2.start);

		// push the first interval to stack 
		stack.push(arr[0]); 
	
		// Start from the next interval and merge if necessary 
		for (int i = 1 ; i < arr.length; i++){ 
			// get interval from stack top 
			Interval top = stack.peek(); 
	
			// if current interval is not overlapping with stack top, 
			// then push it to the stack 			
			if(top.end<arr[i].start) //if this condition is false then next condition is true(which means overlapping)
				stack.push(arr[i]);

			// Otherwise update the ending time of top if ending of current interval is more
			// if control reaches the below block then its a case of overlapping intervals.
			else if(top.end <arr[i].end){
				top.end = arr[i].end;
				stack.pop();   //pop old Interval
				stack.push(top);  //push updated Interval
			}
			
		} 
		// Prints stack linearly
		System.out.print("The Merged Intervals are: "); 
		for(Interval i : stack)  //uses iterator internally
			System.out.print("["+i.start+","+i.end+"] "); 

		// while (!stack.isEmpty()) { 
		// 	Interval obj = stack.pop(); 
		// 	System.out.print("["+obj.start+","+obj.end+"] "); 
		// } 
	} 

	public static void main(String args[]) { 
		Interval arr[]=new Interval[5];   	// array of Intervals
		arr[0]=new Interval(6,8); 	//interval object is stord in arr[0]
		arr[1]=new Interval(1,9); 
		arr[2]=new Interval(2,4); 
		arr[3]=new Interval(4,7); 
		arr[4]=new Interval(11,12);
		mergeIntervals(arr); 
	} 
} 

class Interval //User defined data-type
{ 
	int start,end; 
	Interval(int start, int end) 
	{ 
		this.start=start; 
		this.end=end; 
	} 
} 
