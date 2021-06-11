import java.util.*;

class restoreIP_Iter {

	public static void main(String args[]){
        String s="25525511135";
        System.out.println("The IP addresses are:\n"+restoreIpAddresses(s));
    }

    public static List<String> restoreIpAddresses(String ip) {
        List<String> res = new ArrayList<>();
        int length = ip.length();

        for (int i = 1; i < 4 && i < length - 2; i++)
            for (int j = i + 1; j < i + 4 && j < length - 1; j++)
                for (int k = j + 1; k < j + 4 && k < length; k++) {
                    final String part1 = ip.substring(0, i);
                    final String part2 = ip.substring(i, j);
                    final String part3 = ip.substring(j, k);
                    final String part4 = ip.substring(k, length);

                    if (isValid(part1) && isValid(part2) && isValid(part3) && isValid(part4)) {
                        res.add(part1 + "." + part2 + "." + part3 + "." + part4);
                    }
                }

        return res;

    }

    private static boolean isValid(String s) {
        if (s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255) {
            return false;
        }

        return true;
    }
}