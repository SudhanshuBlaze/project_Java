/*
Time complexity: O(N^2)
Space complexity: O(N)
*/
import java.util.*;
class JobSchedulingDP{

	static class JobData{
		int start, end, profit;
		JobData(int start, int end, int profit){
			this.start = start;
			this.end = end;
			this.profit = profit;
		}
	}

	static int jobSchedule(ArrayList<JobData> arr){
		int dp[] = new int[arr.size()];
		//sorting in the ascending order of start time
		Collections.sort(arr, (a,b)-> a.start-b.start);
		for(int i=0; i<arr.size();i++){
			dp[i]=arr.get(i).profit;
		}

		for(int i=1; i<arr.size();i++){
//check if current time can be merged with previous time or there is a overlapping
			for(int j=0;j<i;j++){
				if(arr.get(j).end <= arr.get(i).start){ //not overlapping, can be merged
					dp[i]= Math.max(dp[i], dp[j]+arr.get(i).profit);
				}
			}
		}

		int maxProfit= Arrays.stream(dp).max().getAsInt();
		System.out.println(Arrays.toString(dp));
		return maxProfit;
	}
	public static void main(String args[]){
		ArrayList<JobData> arr = new ArrayList<JobData>();

		arr.add(new JobData(1,3, 5));
		arr.add(new JobData(2,5,6));
		arr.add(new JobData(4,6,5));
		arr.add(new JobData(6,7, 4));
		arr.add(new JobData(5,7, 11));
		arr.add(new JobData(5,8, 11));
		arr.add(new JobData(7,9, 2));

		// arr.add(new JobData(1, 2, 50));
		// arr.add(new JobData(3, 5, 20));
		// arr.add(new JobData(6, 19, 100));
		// arr.add(new JobData(2, 100, 200));
		System.out.println("Maximum profit: "+jobSchedule(arr));
	}
}

