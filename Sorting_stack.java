import java.util.*;
class Sorting_stack{
	public static void main(String[] args){
		Stack<Integer> input =new Stack<Integer>();
		input.push(4);
		input.push(1);
		input.push(6);
		input.push(0);

		Stack<Integer> res =sort(input);
		for(int e: res)
			System.out.print(e);
		System.out.println();
		while(!res.isEmpty())
			System.out.print(+res.pop());
	}
	static Stack sort(Stack<Integer> input){
		Stack<Integer> temp = new Stack<Integer>(); //Make temp the sorted satck
		int key;

		while(!input.isEmpty()){
			key=input.pop();

			// while temporary stack is not empty and 
            // rear of temp is greater than key 
			while(!temp.isEmpty() && key<temp.peek()){   
				// pop from temporary stack and  
                // push it to the input stack 
				input.push(temp.pop());
			}
			// push temp in tempory of stack 
	temp.push(key);
		}
		return temp;  
	}
}