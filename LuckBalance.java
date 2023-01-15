// Create an array "imp" which only contains t[i]==1 :important contests
        // win=length of imp-k= number of contest to win
        // sort the array imp -> add first  win number of elements
        // subtract it from total sum of luck contests[i][0] , return it
import java.util.*;
class LuckBalance{

    public static void main(String[] args){
    int k=3;
    int contests[][]={  {5 ,1},
                        {2, 1},
                        {1 ,1},
                        {8 ,1},
                        {10 ,0},
                        {5 ,0}};

        int i,tot_sum=0,len=contests.length,ct=0,win;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); 
        for(i=0;i<len;i++){
            if(contests[i][1]==1){
                ct++;
                pq.add(contests[i][0]);
            }
            tot_sum+=contests[i][0];
        }
        // int imp[]=new int[ct];
        for(i=0;i<len;i++){
            if(contests[i][1]==1)
                imp[i]=contests[i][0];
        }
        win=ct-k;
        // Arrays.sort(imp,0,ct);
        for(i=0;i<win;i++) {
            // tot_sum=tot_sum-(2*imp[i]);
            tot_sum=tot_sum-(2*pq.poll());
        }
        System.out.println(tot_sum);
    }
}
