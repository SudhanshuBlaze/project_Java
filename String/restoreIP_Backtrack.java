/* 2^32 ip addresses(IPv4 is 32bit), we have limited(constant) amount of IP addresses
Time complexity: O(1),
Space complexity: O(1)
*/

import java.util.*;

class restoreIP_Backtrack{

    public static void main(String args[]){
        String s="25525511135";
        System.out.println("The IP addresses are:\n"+restoreIpAddresses(s));
    }
        
    static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s.length() == 0){
            return res;
        }
        int[] path = new int[4];
        snapshotIP(res,s,0,path,0);
        return res;
    }
    
    static void snapshotIP(List<String> res, String s, int index, int[] path, int segment){
        if(segment == 4 && index == s.length()){
            res.add(path[0]+"."+path[1]+"."+path[2]+"."+path[3]);
            return;
        }
        else if(segment == 4 || index == s.length()){
            return;
        }
        for(int len = 1; len <= 3 && index + len <= s.length(); len++){
            String snap = s.substring(index,index+len);
            int val = Integer.parseInt(snap);
                if(val > 255 || len >= 2 && s.charAt(index) == '0'){
                break;
            }
            path[segment] = val;
            snapshotIP(res,s,index+len,path,segment+1);
            path[segment] = -1; //undo the choice

        }
    }
}