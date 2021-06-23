//Better

import java.util.*;

class SmallestDistinctWindow{
	public static String findSubString(String str){
		
		boolean visited[]=new boolean[26];
		int dist_count=0;
		Arrays.fill(visited,false);

		//calculate length of distinct elements
		for(int i=0; i<str.length();i++){
			if(!visited[str.charAt(i)-'a']){
				dist_count++;
				visited[str.charAt(i)-'a']=true;
			}
		}

		int count = 0;
		int small_sub=Integer.MAX_VALUE;
		String sub ="",res="";


		//check in each iteration, when we found required substring-> update
		for(int i=0;i<str.length();i++){
			Arrays.fill(visited,false);
			sub="";  //new substring for each iter.
			count=0;

			for(int j=i;j<str.length();j++){

				if(!visited[str.charAt(j)-'a']){ //if unvisited => distinct element found
					count++;
					visited[str.charAt(j)-'a']=true;  //mark visited
				}
				sub+=str.charAt(j);
				
				if(count==dist_count)  //breaking if all distinct elements found
					break;
			}
			//update the result, if length of new sub is smaller
			if(sub.length()<small_sub && count==dist_count){
					res=sub;
					small_sub=sub.length();
				}
		}
		return res;
	}

	public static void main (String[] args){
		String str = "aabcbcdbca";
		System.out.println("Smallest window containing all distinct"+
				" characters is: "+ findSubString(str)) ;
	}
}