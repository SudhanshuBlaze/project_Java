// here 0 is considered as positive
import java.util.*;
class StableRearrangePosNeg{
	public static void main(String[] args)  
    { 
        //int arr[n] = {-5, 3, 4, 5, -6, -2, 8, 9, -1, -4}; 
        //int arr[] = {-5, -3, -4, -5, -6, 2 , 8, 9, 1 , 4}; 
        //int arr[] = {5, 3, 4, 2, 1, -2 , -8, -9, -1 , -4}; 
        //int arr[] = {-5, 3, -4, -7, -1, -2 , -8, -9, 1 , -4}; 
        int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};   
        rearrange(arr); 
  
        System.out.println("RearrangeD array is "+ Arrays.toString(arr)); 
    }

    static void rearrange(int arr[]){
    	int outOfPlace =-1,idx;
    	for(idx = 0; idx < arr.length;idx++){
    		if(outOfPlace>=0){

    			if((arr[outOfPlace]<0 && arr[idx]>=0) || (arr[outOfPlace]>=0 && arr[idx]<0)){
    				rotateRight(arr,idx,outOfPlace);

    				if(idx-outOfPlace>=3)
    					outOfPlace+=2;
    				else 
    					outOfPlace=-1;
    			}
    		}
    			if(outOfPlace<0){
    				if( ((arr[idx]>=0) && (idx & 0x01)==0) || ((arr[idx]<0) && (idx& 0x01)==1))
    					outOfPlace=idx;
    			}
    		}
    	}
    	
    static void rotateRight(int []arr,int curr,int out){
    	int tmp=arr[curr];
    	for(int i=curr;i>out;i--)
    		arr[i]=arr[i-1];
    	arr[out]=tmp;
    }
}