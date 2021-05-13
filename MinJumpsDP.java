
import java.util.Arrays;

/**
 * Date 06/12/2014 
 * @author tusroy
 * 
 * Given an array of non negative integers where each element represents the max 
 * number of steps that can be made forward from that element. Write a function to 
 * return the minimum number of jumps to reach the end of the array from first element
 * 
 * Solution 
 * Have 2 for loop. j trails i. If arr[j] + j >= i then you calculate new jump
 * and result.
 * 
 * Space complexity O(n) to maintain result and min jumps
 * Time complexity O(n^2)
 * 
 * Reference
 * http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 */
public class MinJumpsDP {

     static int minJump(int arr[],int result[]){ //O(N^2) ,DP
        
        int []jump = new int[arr.length];
        jump[0] = 0;
        
        //the block below is to handle invalid cases
        for(int i=1; i < arr.length ; i++){   //this step is to handle cases where its not possible to reach end (due to zeroes)
            jump[i] = Integer.MIN_VALUE;
        }
        //alt .replace all zeroes with min value
        
        for(int i=1; i < arr.length; i++){
            for(int j=0; j < i; j++){

                if(arr[j] + j >= i){
                        jump[i] = jump[j] + 1;  
                        result[i] = j;
                    break;
                }
            }
        }
        
        return jump[jump.length-1];
    }

    
     static int jump(int[] nums) {  // O(N) solution 
        if (nums.length == 1) {
            return 0;
        }
        int count = 0;
        int i = 0;
        while (i + nums[i] < nums.length - 1) {
            int maxVal = 0;
            int maxValIndex = 0;
            for (int j = 1; j <= nums[i]; j++) {
                if (nums[j + i] + j > maxVal) {
                    maxVal = nums[j + i] + j;
                    maxValIndex = i + j;
                }
            }
            i = maxValIndex;
            count++;
        }
        return count + 1;
    }
    
    public static void main(String args[]){
        // MinJumpsDP mj = new MinJumpsDP();
        int arr[] = {0,0,1,3,5,3,2,2,6,1,6,8,9};
        int steps[] = new int[arr.length];

        int res = minJump(arr,steps);
        if(res<0)
            System.out.println("Not Possible  "+res);
        else
            System.out.println(res);
        // System.out.println(Arrays.toString(steps));


        // int arr1[] = {0,0,2,3,1,1,4};
        // System.out.print(jump(arr1));
    }
}
