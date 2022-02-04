/* To compare two elements, it asks “Which is greater?” Compare method returns -1, 0, or 1 to say if it is less than, equal, or greater to the other.
In the below code, if we do "val1-val2", if it's output is -1, then val1<val2
if its 0 then val1==val2 and if its then val1>val2

But if we are sorting in descending order then if 'val1<val2' then we consider val1 to be 
greater value as we will put val1 at end, so in comparator we return 'val2-val1',
so output will 1 or greater than, so although val1 is smaller than val2, the output will be 1,
in this way val1 will be considered greater and will put at the end.
*/
import java.util.*;
class FrequencySort{
    public static void main(String args[])  {
        Integer arr[]={2, 5, 2, 8, 5, 6, 8, 8};
        sort(arr);
    }
    static void sort(Integer[] arr){
        //frequency table
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int e: arr)
            freq.put(e, freq.getOrDefault(e,1)+1);

        Arrays.sort(arr, (val1,val2)->{
            int freq1=freq.get(val1);
            int freq2=freq.get(val2);
            // first sort by frequency in ascending order
            if(freq1!=freq2)
                return freq1-freq2;
            // if frequency is same then sort by value in ascending order
            return val1-val2;
        });

        System.out.println(Arrays.toString(arr));
    }
}