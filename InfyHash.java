import java.util.*;
class InfyHash{
	public static void main( String[] args ){

	Scanner s=new Scanner(System.in);
	// String in=s.nextLine();
	String in="God sees the sees people,god is great great,people sees the god";
	solve(in);
	}

	static void solve(String in){
		String[] lines= in.split(",");
		String []words= in.split("[\\s,]+");

		Map<String,Integer> map= new HashMap<String,Integer>();


		int count=0;

		for(String word: words){
			map.put(word,map.getOrDefault(word,0)+1);
		}
		if(map.size()==words.length){
			System.out.println("-1");
			return;
		}

		for(int i=0;i<lines.length;i++){
			String []eachWord=lines[i].split(" ");  //God sees the sees people
			String unique="";

			for(int j=0;j<eachWord.length;j++){
				if(map.get(eachWord[j])>=1){
					map.put(eachWord[j],0);
					unique+=eachWord[j]+" ";
				}
			}
			if(unique.equals(""))
				lines[i]="X";
			else {
				unique=unique.substring(0,unique.length()-1);
				lines[i]=unique;
			}
			
		}

		for(String e: lines)
			System.out.println(e);

		
	}
}
