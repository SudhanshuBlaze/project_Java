// Java program for the above approach
import java.util.*;

public class firstMissingPos{

// Function for finding the first
// missing positive number
static int finding(int arr[], int n)
{

	// Loop to traverse the whole array
    for (int i = 0; i < n; i++) {
       
        // Loop to check boundary
        // condition and for swapping
        while (arr[i] >= 1 && arr[i] <= n
               && arr[i] != arr[arr[i] - 1]) {

            swap(arr,i, arr[i] - 1);
        }
    }
   
    // Checking any element which
    // is not equal to i+1
    for (int i = 0; i < n; i++) {
        if (arr[i] != i + 1) {
            return i + 1;
        }
    }
   
    // Nothing is present return last index
    return n + 1;
}

static void swap(int arr[],int a,int b){
	int temp = arr[a];
	arr[a]=arr[b];
	arr[b]=temp;
}

	// Driver Code
	public static void main(String[] args){
		int arr[] = {4, 2, 3, -7, 6, 8, 1, -10, 15 };
		int n = arr.length;
		int ans = finding(arr, n);
		
		System.out.println(ans);
	}
}
