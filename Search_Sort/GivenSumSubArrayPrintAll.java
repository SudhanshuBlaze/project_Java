
import java.util.*;
class GivenSumSubArrayPrintAll{
	static class Pairs{
		int start, end;
		Pairs(int start, int end){
			this.start = start;
			this.end = end;
		}
	}
	static void printOut(ArrayList<Pairs> output){
		System.out.println("Printing out pairs");
		for(Pairs pair : output)
			System.out.println(pair.start+ " " +pair.end);
	}

	public static void main(String [] args) {
		// int arr []= {6, 3, -1, -3, 4, -2, 2,4, 6, -12, -7};
		// int arr[] = {0,0};
		int arr[] = {6, 3, -1, -3, 4,7,8, -2, 2,4, 6, -12, -7};
		int k=0;
		// int[] arr = {10, 2, -2, -20, 10};
		// int k=-10;
		printOut(printAllSubArray(arr,k));
	}
	static ArrayList<Pairs> printAllSubArray(int arr[],int k){
		
		ArrayList<Pairs> output = new ArrayList<>();
		Map<Integer,ArrayList<Integer>> map=new HashMap<>();
		int totalSum=0;
		for (int i=0; i<arr.length; i++){
			totalSum+=arr[i];
		/* it means the sum till the curent idx is 0 then [0,i], since we are not inserting 0 in map, 
		so we are using a condition */
			if(totalSum==k)
				output.add(new Pairs(0,i));

			ArrayList<Integer> idxList=new ArrayList<>();
			
			if(map.containsKey(totalSum-k)){
			//existing list is stored in it, which is updated outside the loop
				idxList=map.get(totalSum-k); 
				for(int j=0;j<idxList.size();j++){
					output.add(new Pairs(idxList.get(j)+1, i));	
				}
			}
			idxList.add(i);
			// System.out.println(idxList);
			map.put(totalSum, idxList);
		}
		return output;
	}
}