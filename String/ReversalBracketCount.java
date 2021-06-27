import java.util.Stack;
class ReversalBracketCount{
	public static void main(String args[]){
		String s="}{{}}{{{";
		System.out.println(countReversals(s));
	}
	static int countReversals(String s){

		if(s.length()%2!=0)
			return -1;

		//Using stack to remove the balanced portion of the string
		Stack<Character> stack = new Stack<>();
		for(char bracket : s.toCharArray()){
			if(bracket=='}' && !stack.isEmpty() && stack.peek()=='{')
				stack.pop();
			else
				stack.push(bracket);
		}

/*for ex: redundant characters in stack= "}{{{", on solving this by reversal we get
the output 3, in which 2 '{' brackets are reversed and 1 '}' brackets are reversed*/

		double m = stack.size(),n=0;  //using double, else it won't work with Math.ceil()

		/*size of stack will always be even, and the count of { and } brackets,
		each will always be odd, we have to take care of only the even number of brackets, 
		ex: {{{{, output:2, On dividing by 2 all the brackets gets balanced except ONE
		{{{{{- {= {{{{, output:2, similar thing we will do for opposite bracket
		At the end remaining '{' combines with remaining '}' */
		while(!stack.isEmpty()){
			if(stack.peek()=='{')
				n++;
			stack.pop();
		}
		return (int) (Math.ceil(n/2) + Math.ceil((m-n)/2));
	}
}