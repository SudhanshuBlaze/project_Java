/*
Time complexity: O(log(min(M,N)))
*/
import java.util.*;
class Kth_2SortedArrays {
    
    public static void main(String args[]){
        int a[] = {2,4,6,10};
        int b[] = {1,3,7};
        int k=7;
        System.out.println(kthElement(a,b,k));
    }

    static double kthElement(int[] nums1, int[] nums2,int k) {
        int n1=nums1.length, n2=nums2.length;

        if(n1>n2)//assumption: nums1 is always smaller than nums2
            return kthElement(nums2, nums1,k);
        if(k>n1+n2 || k==0)
            return -1;

        int low= Math.max(0,k-n2);
        int high= Math.min(n1, k);
        //cuts are similar to mid elements
        while(low<= high){
            int cut1 = (low + high) >> 1;
            int cut2 = k-cut1;

            int left1 = cut1==0 ? Integer.MIN_VALUE :nums1[cut1-1];
            int left2 = cut2==0 ? Integer.MIN_VALUE :nums2[cut2-1];

            int right1 = cut1==n1 ? Integer.MAX_VALUE :nums1[cut1];
            int right2 = cut2==n2 ? Integer.MAX_VALUE :nums2[cut2];

            if(left1<=right2 && left2<=right1)
                return Math.max(left1,left2);
            else if(left1>right2)
                high=cut1-1;
            else
                low=cut1+1;
        }
        System.out.println(low+" "+high);
        return -1;
    }
}