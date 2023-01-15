import java.util.Arrays;
//	It divides the input array into two halves, calls itself and divides again, 
// Once the arrays are divided into smaller arrays such that (l=r), 
// then merge() function gets called which merges smaller arrays in sorted order.
class CountInversion{
	public static void main(String[] args){
		int arr[]={8,5,4};
		int aux[]=new int[arr.length];
		System.out.println("CountInversions: "+sort(arr,aux,0,arr.length-1));   
		System.out.println("Sorted Array: "+Arrays.toString(arr));
	}
	
	static int sort(int[] arr,int aux[], int l,int r){
		int countInversion=0; //total count
		int mid=(l+r)/2;
		if(l<r){		// when l==r, size of array is 1
			countInversion+=sort(arr,aux,l,mid);   
			countInversion+=sort(arr,aux,mid+1,r); 

			countInversion+=merge(arr,aux,l,r,mid+1); //note: mid+1-> this helps us 
			//to directly calculate count by using (mid-i), otherwise we have to do (mid-i)+1
		}
		return countInversion;
	}

	static int merge(int arr[],int aux[],int l,int r,int mid){
		int i,j,k=0,count=0; //count for this func call
		i=l; j=mid; 
		// 'i' will go upto one less than mid and j will start from mid
		while((i<=mid-1) && (j<=r)){
			if(arr[i]<=arr[j])
				aux[k++]=arr[i++];
			else{
				aux[k++]=arr[j++];
				count+=(mid-i);
				System.out.println(mid-i);
			}
		}
		while(i<=mid-1)
			aux[k++]=arr[i++];
	
		while(j<=r)
			aux[k++]=arr[j++];
		for(i=l; i<=r; i++)
			arr[i] =aux[i];
		return count;
	}
}





