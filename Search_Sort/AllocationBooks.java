/*
Minimize the maximum number of pages allotted in an arrangement/distribution
Time complexity: O(N*log(sum(arr[])))

Rules:
Each student must have one book allocated,
NOTE: All the books must be allocated in CONTIGUOUS order
*/
import java.util.*;
class AllocationBooks{
	public static void main(String args[]){
		// int books[]={250, 74, 159, 181, 23, 45, 129, 174};
		// int students=6;
		int books[]={51,163,227,55,151};
		int students=5;
		// int books[]={12,34,67,90}; 
		// int students=2;
		System.out.println(allocate(books, students,books.length));
	}
	static long allocate(int books[], int students,int n){
		long res=-1;
/*Search Space: low-> when n number of students are present and n books are present, maximum will be ans
high-> when only 1 student is present all the books will be allotted to him,therefore sum*/
		long low=Arrays.stream(books).max().getAsInt(), high= Arrays.stream(books).sum();
		while(low<= high){
			long mid=(low + high)>>1;
			// System.out.println(low+" "+mid+" "+high);
			if(canAllocate(books, mid,students)){
				res=mid;
				high=mid-1;
			}
			else{
				low=mid+1;
			}
		}
		return res;
	}
	static boolean canAllocate(int[] books, long barrier, int reqStud){
		// first iteration is for student 1 -> currStud=1
		int currStud=1, pages=0;
		for(int i=0; i<books.length; i++){
			//**

			if(pages+books[i]<=barrier)
				pages+=books[i];
			
			else{
				pages=books[i];
				currStud++;
			}
		}
		if(currStud>reqStud)
			return false;
//if barrier is so high that students are getting less, then remove the right half-> decrement barrier
		return true;
	}	
}

//** if a single book's pages is greater than barrier then that book won't be allocated
// to anyone, However this condition won't be true because our "low" is starting from 
// max value, So the barrier value won't go below "max pages" value
 // however this condition would be used if we start from "low=0". 
			
			// if (books[i] > barrier)
   //              return false;


