
import java.util.*;
public class ReverseQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q= new LinkedList<Integer>();

		for (int i=0; i < 10; i++)
			q.add(i);

	reverse(q);
	while(!q.isEmpty())
		System.out.println(q.remove());

	}
	static void reverse(Queue q){
		if(q.isEmpty())
			return ;
		int aux = (int) q.peek();
		q.remove();
		reverse(q);
		q.add(aux);
	}

}
