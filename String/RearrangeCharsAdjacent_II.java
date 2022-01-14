// Optimal
import java.util.*;

class RearrangeCharsAdjacent_II {

	static String rearrangeString(String s){

		 Map<Character,Integer> freq= new HashMap<>();
        //frequency table
        for(char c: s.toCharArray())
            freq.put(c, freq.getOrDefault(c,0)+1 );
        
        PriorityQueue<Character> maxHeap=new PriorityQueue<>((a,b)->
                                                freq.get(b)-freq.get(a));
        maxHeap.addAll(freq.keySet()); //puts all the keys in maxHeap in form of a HashSet
        StringBuilder res=new StringBuilder();
        
        while(maxHeap.size()>1){
            
            char curr=maxHeap.remove();
            char next=maxHeap.remove();
            
            res.append(curr);
            res.append(next);
            
            freq.put(curr,freq.get(curr)-1);
            freq.put(next,freq.get(next)-1);
            
            if(freq.get(curr)>0)
                maxHeap.add(curr);
            if(freq.get(next)>0)
                maxHeap.add(next);
        }
        // here the size of the maxHeap is 1
        if(!maxHeap.isEmpty()){
            if(freq.get(maxHeap.peek())>1)
                return "";  //when freq of a element is really high such that 
            // it cannot be rearranged properly. Ex: 'bbba'
            else
                res.append(maxHeap.poll()); //when freq of remaining elements is 1. Ex. bba
        }
        return res.toString();
	}
	public static void main(String args[]){
		// String str = "bbababb";
        String str = "bbaba";
		System.out.println(rearrangeString(str));
	}
}
