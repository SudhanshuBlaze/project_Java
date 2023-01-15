
import java.util.*;

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

     static int minJump(int arr[],int steps[]){ //O(N^2) ,DP
        
        int []jump = new int[arr.length];
        jump[0] = 0;
        
        //the block below is to handle invalid cases
        for(int i=1; i < arr.length ; i++){   //this step is to handle cases where its not possible to reach end (due to zeroes)
            jump[i] = Integer.MIN_VALUE;
        }
        //alt .replace all zeroes with min value

        // [1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9]

        for(int i=1; i < arr.length; i++){
            for(int j=0; j < i; j++){

                if(arr[j] + j >= i){
                    // +1 signifies NUMBER of jumps required to reach the current position
                    // would be ONE more or +1 than the position from which its jumping
                        jump[i] = jump[j] + 1;  
                        steps[i] = j;  //stores the location from which we jump to reach the current position
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(jump));
        return jump[jump.length-1];
    }

    
     static int minJumpOptimal(int[] arr) {  // O(N) solution 
        int maxReach = arr[0]; 
        int steps = arr[0];  
        int jump=1; //result-> stores minJumps

        if(arr.length==1) return 0;
        else if(arr[0]==0) return -1;  //can't jump anywhere
        else{
            for(int i=1; i<arr.length; i++){
                maxReach = Math.max(maxReach,arr[i]+i); 
                steps--;
                if(steps==0){
                    jump++;
                    steps=maxReach-i;
                    // can't go any further
                    if(i>=maxReach)
                        return -1;
                }
            }
            return jump;
        }
    }
    
    public static void main(String args[]){
        // MinJumpsDP mj = new MinJumpsDP();
        // int arr[] = {1,0,0,1,3,5,3,2,2,6,1,6,8,9};
        int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int steps[] = new int[arr.length];

        // int res = minJump(arr,steps);
        // if(res<0)
        //     System.out.println("Not Possible  "+res);
        // else
        //     System.out.println(res);
        // System.out.println(Arrays.toString(steps));

        System.out.println(minJumpOptimal(arr));

        // int arr1[] = {0,0,2,3,1,1,4};
        // System.out.print(jump(arr1));
    }
}
