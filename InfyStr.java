import java.util.*;
class InfyStr{
	public static void main(String[] args){
		Scanner s= new Scanner(System.in);
		// String in=s.nextLine();
		String in="99 aa";
		System.out.print(solve(in));
	}
	static String solve(String in){
		int spcl;
		int maxChar=getMaxFreq(in, "s");
		int maxDigit=getMaxFreq(in,"d");
		spcl=Math.abs(maxChar-maxDigit);

		if(!(in.charAt(spcl)==' ')){
			String rchar=in.substring(spcl,spcl+1);
			in=in.replace(rchar, "");
		}
		in=in.replace(' ', '$');
		return in;
	}

	static int getMaxFreq(String s, String exception){
		int maxFreq = -1;
        int count[] = new int[256];
      
        for (int i=0; i<s.length(); i++){
        	char curr=s.charAt(i);
        	if(exception.equals("s")){
        		if(Character.isLetter(curr))
        			count[curr]++;
        		
        	}
        	else if(exception.equals("d")){
        		if(Character.isDigit(curr)){
        			count[curr]++;
        		}
        		
        	}
        }

        for (int i = 0; i < s.length(); i++) {
            if (maxFreq < count[s.charAt(i)]) {
                maxFreq = count[s.charAt(i)];
            }
        }
      
        return maxFreq;
    }

  
}

