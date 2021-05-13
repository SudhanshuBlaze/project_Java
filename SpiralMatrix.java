// Java program to print a given matrix in spiral form
import java.io.*;

class SpiralMatrix {

	// Function print matrix in spiral form
	static void spiralPrint(int row, int col, int a[][])
	{
		int top=0,bottom=row-1,left=0,right=col-1,dir=0,i;

		while(top<=bottom && left<=right){
			if(dir==0){
				for(i=left;i<=right;i++)
					System.out.print(a[top][i]+" ");
				top++;
				dir=1;
			}
			else if(dir==1){
				for(i=top;i<=bottom;i++)
					System.out.print(a[i][right]+" ");
				right--;
				dir=2;
			}
			else if(dir==2){
				for(i=right;i>=left;i--)
					System.out.print(a[bottom][i]+" ");
				dir=3;
				bottom--;
			}
			else if(dir==3){
				for(i=bottom;i>=top;i--)
					System.out.print(a[i][left]+" ");
				dir=0;
				left++;
			}
		
		}
	}

	// Driver Code
	public static void main(String[] args)
	{
		int a[][] = { { 1, 2, 3, 4, 5, 6 },
					{ 7, 8, 9, 10, 11, 12 },
					{ 13, 14, 15, 16, 17, 18 } };
		int R=a.length;
		int C=a[0].length;
		spiralPrint(R, C, a);
	}
}
