/*Create a HashMap for each string(Unique ID) and then search for other 

Time complexity: O(N*M),
Space complexity: O(N*M)-> (if all elements are distinct)

Alt.: Sort each string -> if anagram then they'll be same
*/

import java.util.ArrayList;
import java.util.HashMap;

public class AnagramsPrintAll {

	static ArrayList<ArrayList<String> >solver(ArrayList<String> list){
		HashMap<HashMap<Character, Integer>, ArrayList<String>>
			map = new HashMap<HashMap<Character, Integer>,ArrayList<String> >();
		
		for (String str : list) {
			HashMap<Character, Integer>freqTable = new HashMap<Character, Integer>();
			/* Counting the frequency of the characters present in a string
			-> Creating Unique HashMap for each string*/
			for (char c: str.toCharArray())
				freqTable.put(c, freqTable.getOrDefault(c,0)+1);

		/*Approach: If the same frequency of characters are already present then add that
		string into that arraylist otherwise created a new arraylist and add that string*/
			if (map.containsKey(freqTable))
				map.get(freqTable).add(str);
			else {
				ArrayList<String>anagramsList = new ArrayList<String>();
				anagramsList.add(str);  
				map.put(freqTable, anagramsList);
			}
		}

		// Stores the result in a arraylist -> NESTED LIST
		ArrayList<ArrayList<String> >result = new ArrayList<>();
		for (HashMap<Character, Integer> key : map.keySet())
			result.add(map.get(key));
		return result;
	}

	public static void main(String[] args){
		ArrayList<String> list = new ArrayList<>();
		list.add("cat");
		list.add("dog");
		list.add("ogd");
		list.add("god");
		list.add("atc");

		System.out.println(solver(list));
	}
}

