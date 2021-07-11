import java.util.*;
class JobSequencingGreedy{

	static class JobData{
		char id;
		int deadline, profit;
		JobData(char id, int deadline, int profit){
			this.id = id;
			this.deadline = deadline;
			this.profit = profit;
		}
	}

	static int[] jobSequencing(ArrayList<JobData> arr){
		int maxDeadline=Integer.MIN_VALUE;
		for(int i=0; i<arr.size(); i++){
			if(arr.get(i).deadline > maxDeadline)
				maxDeadline=arr.get(i).deadline;
		}
		// we won't be accessing index: 0 -> for the simplicity of code
		char slot[]=new char[maxDeadline+1];// upper limit for number of jobs-> maxDeadline
		Arrays.fill(slot,'#');  // '#' represents unvisited
		//sort in descending order of profit
		Collections.sort(arr, (a,b) ->b.profit- a.profit);

		int countJobs=0,maxProfit=0, ans[]=new int[2];
		for(int i=0;i<arr.size();i++){
			//note: we are not using 0th index, because no job has its deadline as '0'
			for(int j=arr.get(i).deadline; j>0; j--){
//if unvisited, then fill, else do the job in before time/deadline -> decrement j
				if(slot[j]=='#'){
					slot[j]=arr.get(i).id;  //note this step
					countJobs++;
					maxProfit+= arr.get(i).profit;
					break;
				}
			}
			System.out.println(Arrays.toString(slot));
		}
		ans[0]=countJobs;
		ans[1]=maxProfit;
		return ans;
	}
	public static void main(String args[]){
		ArrayList<JobData> arr = new ArrayList<JobData>();
		// arr.add(new JobData('a', 2, 100));
		// arr.add(new JobData('b', 1, 19));
		// arr.add(new JobData('c', 2, 27));
		// arr.add(new JobData('d', 1, 25));
		// arr.add(new JobData('e', 1, 15));

		arr.add(new JobData('a', 2, 100));
		arr.add(new JobData('b', 1, 19));
		arr.add(new JobData('c', 2, 27));
		arr.add(new JobData('d', 1, 25));
		arr.add(new JobData('e', 3, 15));
		System.out.println("Order of Jobs");
		int ans[]=jobSequencing(arr);
		System.out.println("Number of Jobs: "+ans[0]+" Maximum profit: "+ ans[1]);
	}
}

