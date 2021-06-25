import java.util.*;

public class SmallestSubstringWindow {
	public static void main(String[] args) {
		// String s1 = "is this a test string";
		// String s2 = "ist";

		String s1 ="timetopractice";
		String s2 ="toc";
		System.out.println(solution(s1,s2));
	}

	public static String solution(String s1, String s2){
        int arrMap[] = new int[256];
        int arrMap2[] = new int[256];   //{t:1, o:1, c:1 }

        int ansCount = Integer.MAX_VALUE;
        String ans="";
        for(char c : s2.toCharArray())
        	arrMap2[c]++;   //freq table for string 2(pattern)

        int matchCount=0;
        //collection
        for(int i = 0, start = 0; i < s1.length(); i++){
	        char c = s1.charAt(i);
	        // if the char is present in string 2
	        if(arrMap2[c]!=0){
	            arrMap[c]++;
	            if(arrMap[c] <= arrMap2[c])
	            	matchCount++;
	            }
	        //reduction
	        while(matchCount==s2.length()){

	        	char chstart=s1.charAt(start);
	        	//freq should not go below 0
	        	if(arrMap[chstart]!=0)
	        		arrMap[chstart]--;
	        	//kaam ka banda gawaya hai, decrement matchCount
	        	if(arrMap[chstart]< arrMap2[chstart])
	        		matchCount--;
	        	//update minimum substring
	        	if(ans.length()==0 || (i+1-start)<ans.length())
                    ans=s1.substring(start,i+1);   // we are using i+1 because we also want to include last char, 
                    //because in substring() the last char is ignored by default

	        	start++;
	        }
		}
		return ans;
	}
}


	

// 	    int ans = Integer.MAX_VALUE;
// 	    int matchcount = 0;
// 	    int[] fans = new int[2];
// 	    for(int i = 0, j = 0; i < s1.length(); i++){
// 	        char c = s1.charAt(i);
// 	        if(map2.containsKey(c)){
// 	            map1.put(c,map1.getOrDefault(c,0) + 1);
// 	            if(map1.get(c) <= map2.get(c)){
// 	                matchcount++;
// 	            }
// 	            while(matchcount == s2.length()){
// 	                char chj = s1.charAt(j);
// 	                if(!map1.containsKey(chj)){
// 	                    //nothing
// 	                }else if(map1.get(chj) > map2.getOrDefault(chj,0)){
// 	                    map1.put(chj,map1.get(chj) - 1);
// 	                }else{
// 	                    if(i - j + 1 < ans){
// 	                        ans = i - j + 1;
// 	                        fans[0] = i;
// 	                        fans[1] = j;
// 	                    }
// 	                    map1.put(chj,map1.get(chj) - 1);
// 	                    if(map1.get(chj) < 0){
// 	                        map1.remove(chj);
// 	                    }
// 	                    matchcount--;
// 	                }
// 	                j++;
// 	            }
	           
// 	        }    
	        
// 	    }
// 	    if(fans[0] == fans[1] && s2.length() != 1){
// 	        return "";
// 	    }else
// 	    return (s1.substring(fans[1],fans[0] + 1));