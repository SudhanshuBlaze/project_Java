import java.util.Arrays;
//	It divides the input array into two halves, calls itself and divides again, 
// Once the arrays are divided into smaller arrays such that (l=r), 
// then merge() function gets called which merges smaller arrays in sorted order.
class MergeSort{

	public static void main(String[] args){
		int arr[]={8,5,2,9,0,0,12,7};
		sort(arr,0,arr.length-1);   //pointers never point to arrays.length, it'll give array index of out of bounds
		System.out.println(Arrays.toString(arr));
	}
	
	static void sort(int[] arr,int l,int r){
		
			int mid=(l+r)/2;
			if(l<r){		// when l==r, size of array is 1

			sort(arr,l,mid);   // left part of array
			sort(arr,mid+1,r); // right part of array

			merge(arr,l,r,mid);		// merge the subarrays
		}
		

	}
	static void merge(int arr[],int l,int r,int mid){

		int l_size= mid-l+1;  // size of left array
		int r_size= r-mid;		// size of right array

		int l_arr[] = new int[l_size];
		int r_arr[] = new int[r_size];

		int i,j,k;				//Copying of element starts from l
		for(i=0;i<l_size;i++)	//copying the elements of main array to subarray
			l_arr[i]=arr[l+i];
		for(j=0;j<r_size;j++)
			r_arr[j]=arr[j+mid+1];

		i=0;j=0;	
		//pasting of elements starts from from l k=l
		k=l; 					// l is initial index of merged array
		while(i<l_size && j<r_size){

			if(l_arr[i]<= r_arr[j]){
				arr[k]=l_arr[i];
				i++;
			}
			else {
				arr[k]=r_arr[j];
				j++;
			}
			k++;
		}
		while(i<l_size){
			arr[k]=l_arr[i];
			i++;
			k++;
		}
		while(j<r_size){
			arr[k]=r_arr[j];
			j++;
			k++;
		}


	}
}