// Source: https://www.youtube.com/watch?v=XmSOWnL6T_I
import java.util.*;
class CountPalinSubstringsDP{
	public static void main(String[] args){
		String str="abccbc";
		System.out.println("Count of Palin SUBSTRINGS "+count(str));
	}
	static int count(String str){
		boolean dp[][]=new boolean[str.length()][str.length()];
		int count=0, maxLen=0, start=0,end=0;
		// we need to travel in diagnols
		for(int d=0; d<str.length(); d++){
			// each diagnol is starting from first row but different columns.
			for(int i=0,j=d;j<str.length();i++,j++){
				if(d==0)
					dp[i][j] = true;
				
				else if(d==1) 
					//at diagnol =1 only 2 chars in a string, so we check first and last char for palin
					dp[i][j] = str.charAt(i)==str.charAt(j);
				
				else
					// at diagnol>1, more than 2 chars in a string, so we if the first
					// and last char of string is same, then we check for the 
					// palin for the middle characters
					if(str.charAt(i)==str.charAt(j))
						dp[i][j] = dp[i+1][j-1]; 
				// at the end we count the number of 'true'

				if(dp[i][j]==true){
					count++;
					// calculate the Length of Longest Palin substring
					if(j-i+1>maxLen){
						 start=i;
						 end=j;
						maxLen=j-i+1;
					}
				}

			}
		}
		System.out.println(
			"Longest palin substring: '"+str.substring(start, end+1)+"' of length: "+maxLen);
		return count;
	}
}










// if(j==(k+i)){
// 					count++;
// 					dp[j][k]=true;
// 					continue;
// 				}
// 				// removes Index out of Bound cases
// 				if(j>=(k+i+1) || (k+i+1)>str.length())
// 					continue;
// 				String atCell=str.substring(j,k+i+1);
// 				if(str.charAt(j)==str.charAt(k+i) && j+1==k+i){
// 					count++;
// 					dp[j][k+i]=true;
// 				}
// 				else if(str.charAt(j)==str.charAt(k+i))
// 					if(dp[j+1][k+i-1]==true){
// 						dp[j][k+i]=true;
// 						count++;
// 					}
// 					else dp[j][k+i]=false;
// 				// System.out.println(str.substring(j,k+i+1));
// 				else
// 					dp[j][k+i]=false;