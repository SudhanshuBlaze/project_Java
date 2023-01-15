import java.util.Map;
import java.util.HashMap;

class RomanToInteger{

	static Map<Character, Integer> map = new HashMap<>()
	{{
	put('I', 1);
    put('V', 5);
    put('X', 10);
    put('L', 50);
    put('C', 100);
    put('D', 500);
    put('M', 1000);
}};
	public static void main(String args[]){
		String s = "MCMIV";
		convert(s);
	}

	static void convert(String s){
		int res= map.get(s.charAt(s.length()-1));

		for(int i = s.length()-2; i >=0; i--){
			if( map.get(s.charAt(i)) < map.get(s.charAt(i+1)))
				res-= map.get(s.charAt(i));
			else
				res+=map.get(s.charAt(i));
		}
		System.out.println(res);
	}
}