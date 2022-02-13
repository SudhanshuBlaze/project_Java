/*
Optimal
Time complexity: O(N)
*/
import java.util.*;
class SmallestDistinctWindow_II{
    public static void main (String[] args){
        String str = "aabcbcdbca";
        System.out.println("Smallest window containing all distinct"+
                " characters is: "+ findSubString(str)) ;
    }
    static String findSubString(String str){
        int dist_count = 0;
        int[] frequency = new int[256];
        Arrays.fill(frequency, 0);

        //count distinct characters
        for (int i = 0; i < str.length(); i++){
            if (frequency[str.charAt(i)] == 0) {
                frequency[str.charAt(i)] = 1;
                dist_count++;
            }
        }
        int count = 0,start =0, min_len=Integer.MAX_VALUE,res_idx=-1;
        Arrays.fill(frequency, 0);
        for(int i = 0; i<str.length();i++){

            if(frequency[str.charAt(i)]==0){
                frequency[str.charAt(i)]++;
                count++;
            }
            else
                frequency[str.charAt(i)]++;
            //If the frequency of character at start pointer is greater than 1 increment
            // the pointer as it is redundant.
            if(count==dist_count)  //window which has all characters
                while(frequency[str.charAt(start)]>1){
                    frequency[str.charAt(start)]--;
                    start++;

                    if((i-start+1) < min_len){ //update min_len
                        min_len = i-start+1;
                        res_idx=start;
                    }
                }

        }
        return str.substring(res_idx,res_idx+min_len);
    }
}


