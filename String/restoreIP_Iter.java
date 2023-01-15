import java.util.*;

class restoreIP_Iter {
	public static void main(String args[]){
        String s="25525511135";
        System.out.println("The IP addresses are:\n"+restoreIpAddresses(s));
    }

    public static List<String> restoreIpAddresses(String ip) {
        List<String> res = new ArrayList<>();
        String subIp="";

        int len = ip.length();
        for(int i=1;i<4 && i<len-2; i++){

            for(int j=i+1;j<i+4 && j<len-1; j++){
                for(int k=j+1;k<j+4 && k<len; k++){
                    String part1=ip.substring(0,i);
                    String part2=ip.substring(i,j);
                    String part3=ip.substring(j,k);
                    String part4=ip.substring(k,len);

                    if(isValid(part1)&&isValid(part2)&&isValid(part3)&&isValid(part4))
                        res.add(part1+"."+ part2+"."+ part3+"."+ part4);
                    }
                 }
            }

        return res;

    }

    //check for each substring of IP address, ex: 255 in 255.255.11.135
    private static boolean isValid(String s) {
        if (s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255) {
            return false;
        }

        return true;
    }
}