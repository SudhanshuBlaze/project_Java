import java.util.*;

class BsearchCircularArr{

	public static void main(String[] args){
		int arr[] = {5,6,7,8,9,9,1,2,3,4};
		System.out.println((search(arr,9)));
	}
	static int search(int[] arr,int x){
		int mid, low=0, high=arr.length-1;

		while(low<=high){
			
			 mid=low +(high-low)/2;
			 if(arr[mid]==x)
			 	return mid;

			 //we are using "<=" because we want to deal with repetition
			 if(arr[mid]<=arr[high]){   //checking if right part is sorted
			 	if(x>arr[mid] && x<=arr[high])  //if x is in sorted segement,then remove the other segment and search in this segment
			 		low=mid+1;
			 	else              //else if x is in this segement then remove the other segment,and continue search in this segment 
			 		high=mid-1;   
			 }

			 //only else statement will work 
			 else if(arr[low]<=arr[mid]){	//checking if left part is sorted
			 	if(x <arr[mid] && x>=arr[low]) 
			 		high=mid-1;
			 	else
			 		low=mid+1;
			 }
		}	
		return -1;
	}
}

