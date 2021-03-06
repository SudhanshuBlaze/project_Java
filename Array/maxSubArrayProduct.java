import java.util.*;
class maxSubArrayProduct {
    static int maxProduct(int[] nums) {
    	// if initialized to 1, then the program will fail for the test case where ans is 0.
        int res=nums[0],curr_max=nums[0],curr_min=nums[0],prev_max;
        System.out.println("curr_max"+"  "+"curr_min");

        for(int i=1;i<nums.length;i++){

            prev_max=curr_max;
            //in the below line the max gets updated so we need to store
            //the prev_max as it will be used for 'min'
            curr_max=Math.max(Math.max(nums[i]*curr_max,nums[i]*curr_min),nums[i]);
            curr_min=Math.min(Math.min(nums[i]*prev_max,nums[i]*curr_min),nums[i]);
            res=Math.max(curr_max,res);
            System.out.println(curr_max+" \t\t "+curr_min);

        }
        return res;
    }

    public static void main(String[] args){ 
        int arr[] = { 1, -2, -3, 0, 7, -8, -2 };
        System.out.println("\nMaximum Sub array product is "+ maxProduct(arr));
    }
}