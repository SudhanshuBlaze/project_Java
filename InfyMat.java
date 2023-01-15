import java.util.*;
class InfyMat{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String in=sc.nextLine();
		String arr[]= in.split(",");


		int r=sc.nextInt();
		sc.nextLine();  //skipping next line

		int mat[][]=new int[r][2];
		
		for(int i=0; i<r; i++){
            String inNum=sc.nextLine();
            String[] numStr= inNum.split("\\s+");

            mat[i][0]= Integer.parseInt(numStr[0]);
            mat[i][1]= Integer.parseInt(numStr[1]);
		}
		solve(mat,arr);
	}

	static void solve(int mat[][], String arr[]){
		String outStr="";
		int minCons= Integer.MAX_VALUE;

		Map<Integer, Character> map=new HashMap<>();
		int k=0;
		for (char ch = 'a'; ch <= 'z'; ++ch) 
  			map.put(k++, ch);

		for(int i=0;i<arr.length;i++){
			arr[i]=arr[i].replace(
							arr[i].charAt(mat[i][0]), 
							map.get(mat[i][1]));
		}

		for(String e: arr) {
			int consonants=getConsonants(e);
			if(consonants<minCons){
				minCons = consonants;
				outStr=e;
			}
		}
		System.out.println(outStr);
	}

	static int getConsonants(String str){
		int count = 0;
		for (int i=0 ; i<str.length(); i++){
         char ch = str.charAt(i);
         if(ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u' ){
            count++;
         }
      }
      return count;
	}
}











