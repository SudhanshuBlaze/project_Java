/*
When the current index is at i, then the sorted(or correct) element will be at 
(i-k,i+k) or k<=i<=k.

However in some questions of nearly sorted array, the range is k<i<k or (k,k)
*/
import java.util.*;
class K_sorted_pq{
	public static void main(String[] args){
        int k = 3;
        int arr[] = {6, 2, 3, 12, 56, 8};
        kSort(arr, k);
        System.out.println(Arrays.toString(arr));
    }
    static void kSort(int arr[],int k) {
    	if(arr.length<k+1) return;
    	
    	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    	//add first element and next k elements which are k+1 elements
    	for(int i=0;i<k+1;i++)
    		minHeap.add(arr[i]);
    	
    	int startIndex =0;
		for(int i=k+1;i<arr.length;i++){
			arr[startIndex++] = minHeap.poll();
			minHeap.add(arr[i]);
		}
		//whatever is remaining in the heap pop and put into result array
		while(!minHeap.isEmpty())
			arr[startIndex++] = minHeap.poll();
    }
}



	//input in online compiler
	// Scanner sc=new Scanner(System.in);
	// int t=sc.nextInt();
	// while(t-- >0){
	//     int N=sc.nextInt();
	//     int k=sc.nextInt();
	//     int arr[]=new int[N];
	    
	//     for(int i=0;i<N;i++){
	//         arr[i]=sc.nextInt();
	//     }