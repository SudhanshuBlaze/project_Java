// Stock_II: Maximum profit by buying and selling a share
import java.util.*;
import java.io.*;

class Stock_II {
	public static void main (String[] args) {
	// z-x=72 or (y-x) + (z-y) 
	int price[] = {2, 30, 15, 10, 8, 25, 80}; 
	// int price[] = {2, 1,1,1,15}; 
	// int price[] = {2, 30, 15, 10, 8, 25, 80,1,201};
	// int price[] = {12, 14, 17, 10, 14, 13, 12, 15}; 

	int profit =0; 	// Initializing variable
			//valley-peak approach
			/* 
						  	   80
							  /
				30			 /
				/ \			25
			   /  15	   /
			  /	    \     /
			 2	    10   /
					  \ /
					   8
				*/		
		for(int i=1;i<price.length;i++) {
			int sub=price[i]-price[i-1];
			if(sub>0)
				profit+=sub;
		}
	System.out.println("the profit is "+ profit);
	}
}

