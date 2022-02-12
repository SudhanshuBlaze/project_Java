//Time Complexity: O(N^3)
import java.util.*;
class PermutationsString_II{
	static Set<String> set = new HashSet<>();

	public static void main(String args[]){
		StringBuilder available=new StringBuilder("IOG");
		StringBuilder chosen = new StringBuilder("");
		permute(available, chosen);
	}

	static void permute(StringBuilder available, StringBuilder chosen){
		indent(chosen);
		System.out.println("permute("+available+", "+ chosen+")");

		//no chars are left to choose and explore from
		if(available.length()==0){
			//we need to convert StringBuilder to String, to work with Set
			if(!set.contains(chosen.toString())){
				set.add(chosen.toString());
				System.out.println(chosen);
			}
			return;
		}

		for(int i=0; i<available.length();i++){
			//choose
			char choose=available.charAt(i);
			available.deleteCharAt(i);
			chosen.append(choose);

			//explore that path
			permute(available, chosen);

			//unchoose-> back track
			available.insert(i, choose);
			chosen.deleteCharAt(chosen.length()-1);
		}
	}

	static void indent(StringBuilder chosen){
		for(int i=0; i<chosen.length();i++)
			System.out.print("  ");
	}
}