// A Simple Merge based O(n+m) solution
// to find median of two sorted arrays
class MedianDiffSize{
	
// Function to calculate median
static int getMedian(int ar1[], int ar2[],
					int n, int m){
	int i=0,j=0;  
	int m1=-1,m2=-1;
	int count = 0;
	if((n+m)%2==1){  //Odd number of elements in total

		while(count<=(n+m)/2){   
			if(i<n && j<m){
				m1= (ar1[i]>ar2[j])? ar2[j++]:ar1[i++]; 
			}
			else if(j<m)
				m1=ar2[j++];
			else
				m1=ar1[i++];
			count++;
		}
		return m1;
	} 

	else{
		while(count<= (n+m)/2){
			m1=m2;    //stores previous element
			if(i<n && j<m){
				m2= (ar1[i]>ar2[j])? ar2[j++]: ar1[i++];
			}
			else if(j<m)
				m2=ar2[j++];
			else
				m2=ar1[i++];
			count++;
		}
		return (m1+m2)/2;
	}
}

public static void main(String[] args)
{
	int ar1[] = {2, 3, 5, 8};
    int ar2[] = {10, 12, 14, 16, 18, 20};

	int n1 = ar1.length;
	int n2 = ar2.length;

	System.out.println(getMedian(ar1, ar2, n1, n2));
}
}
