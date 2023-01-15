class matrixMedian{
        
    public static void main(String[] args){
    int m[][]= { {1,3,5}, {2,6,9}, {3,6,9} };
    int r = m.length, c = m[0].length;
    System.out.println("Median is " + findMedian(m));
    }

    static int countSmallerThanMid(int row[], int mid) {
        int l = 0, h = row.length - 1; 
        while(l <= h) {
            int md = (l + h) >> 1; 
            if(row[md] <= mid) {
                l = md + 1;   //returns the index of next element of mid.
            }
            else {
                h = md - 1;
            }
        }
        return l; 
    }
    static int findMedian(int A[][]) {

        /*We can even set the low = min value in matrix, high = max value in matrix, 
        this is gonna waste time*/
        int low = Integer.MIN_VALUE;
        int high = Integer.MAX_VALUE; 

        int n = A.length;
        int m = A[0].length; 
        while(low <= high) {
            int mid = (low + high) >> 1; 
            int cnt = 0;
            for(int i = 0;i<n;i++) {
                cnt += countSmallerThanMid(A[i], mid); 
            }
            /* including mid the total number on left, should be greater than (n*m)/2, 
            if its less than equal to (m*m)/2, then its not possible(that is median), 
            it should be greater than (n*m)/2 */
            if(cnt <= (n * m) / 2) {
                low = mid + 1; 
            }
            else high = mid - 1; 
        }
        return low; 
    }
}
