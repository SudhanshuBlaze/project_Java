//Reversing Stack using recursion
import java.util.*;

class Reversing_Stack{

	public static void main (String args[]){
		Stack<Integer> st= new Stack<Integer>();

		for (int i=0; i < 10; i++)
			st.push(i);

	reverse(st);
	while(!st.isEmpty())
		System.out.println(st.peek());
	}
	static void reverse(Stack st){
		if(st.isEmpty())
			return ;
		int aux = (int) st.peek();
		st.pop();
		reverse(st);
		st.push(aux);
	}
}