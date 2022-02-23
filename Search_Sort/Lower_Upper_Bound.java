// lower_bound returns '-1' when lower_bound is not found. Ex: arr[]={20,21}, key=22
// upper_bound returns '-1' when upper_bound is not found. Ex: arr[]={20,21}, key=21,22

class Lower_Upper_Bound{
	public static void main(String args[]){
		int arr[] = {4,6,6, 10, 12, 18, 20 ,20};
		int len = arr.length;

		// Element whose lower bound and upper bound to be found
		// int key =22;
		// int key =3;
		int key =6;

		System.out.println("lb: "+lower_bound(arr, len, key)); 
		System.out.println("ub: "+upper_bound(arr, len, key));
	}

	static int lower_bound(int[] arr, int len, int key){
		int lo=0, hi=len-1,res=-1;
		while(lo<=hi){
			int mid=lo+(hi-lo)/2;
			// result will be stored when "key" is found OR a 'num' greater than key is found
			if(arr[mid]>=key){
				res=mid;
				hi=mid-1;
			} 
			else if(arr[mid]<key){
				lo=mid+1;
			}
		}
		return res;
	}

	static int upper_bound(int []arr, int len, int key){
		int lo=0, hi=len-1, res=-1;
		while(lo<=hi){
			int mid=lo+(hi-lo)/2;
			if(arr[mid]>key){
				res=mid;
				hi=mid-1;
			}
			else if(arr[mid]<=key){
				lo=mid+1;
			}
		}
		return res;
	}
}