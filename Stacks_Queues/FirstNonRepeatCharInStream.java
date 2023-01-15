/*We have to maintain the queue such that the size of queue will not exceed 26,
we can do this by only pushing NON-REPEATING characters inside queue,
due to this reason time complexity will be O(26)*/
import java.util.*;
class FirstNonRepeatCharInStream{
	public static void main(String args[]) {
		String str = "hrqcvsvszpsjammdrw";
        System.out.println(firstNonRepeating(str));
	}
	static String firstNonRepeating(String str){
		Queue<Character> q= new LinkedList<Character>();
		int repeated[]=new int[256];
		StringBuilder res=new StringBuilder();
		for(int i=0; i<str.length(); i++){
			char currChar=str.charAt(i);
			repeated[currChar]++;
			if(repeated[currChar]<=1){
				q.add(currChar);
			}
			while(!q.isEmpty()){
				if(repeated[q.peek()]>1){
					q.remove();
				}
				else{
					res.append(q.peek());
					break;
				}
			}
			if(q.isEmpty()){
				res.append("#");
			}
		}
		return res.toString();
	}
}