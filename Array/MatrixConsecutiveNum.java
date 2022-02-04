/* Desc: Check if do we get the same number consecutively at leat 4
times in any fashion(Vertically, horizontally, diagnoly).
if we get multiple values, then print minimum of them */
class MatrixConsecutiveNum{
	public static void main(String args[]) {
		int mat[][]= {
			{1,3,3,3,3,9},
			{1,6,9,2,3,9},
			{1,2,2,5,4,9},
			{2,2,4,5,7,9},
			{2,4,5,6,7,2},
			{1,2,3,4,5,6},
		};
		// ans: 3,2,9
		System.out.println(getMinConsecutive(mat));
	}

	static boolean areEqual(int a, int b, int c, int d) {
		if(a == b && b==c && c == d) return true;
		else return false;
	}

	static int getMinConsecutive(int mat[][]){
		int min=Integer.MAX_VALUE;
		int rows=mat.length, cols=mat[0].length;

		for(int i=0;i<rows;i++)
			for(int j=0;j<cols;j++){
				// horizontally
				if(j<cols-3 &&
					areEqual(mat[i][j],mat[i][j+1],mat[i][j+2],mat[i][j+3]))
					min= Math.min(min,mat[i][j]);
				// vertically
				if(i<rows-3 && 
					areEqual(mat[i][j],mat[i+1][j],mat[i+2][j],mat[i+3][j]))
					min= Math.min(min,mat[i][j]);
				// diagnoly-> bottom-to-top
				// Intuition: We are substracting upto -3 from 'i', so we need to start 'i'
				// from 3 or else index will be negative, and we are adding upto +3 in j
				// so we need to make sure 'j' does get equals to 'cols' as cols is the boundary
				if(i>=3 && j<cols-3 &&
					areEqual(mat[i][j],mat[i-1][j+1],mat[i-2][j+2], mat[i-3][j+3]))
					min= Math.min(min,mat[i][j]);
				// diagnoly top-to-bottom
				// intuition behind the condition: 'rows' and 'cols' are boundary
				// we are adding upto '+3' to 'i' and 'j' so we need to substract that
				// 'value' from the boundary to prevent overflow. 'i' cannot be equal to 'row'
				// so we are using '<' symbol
				if(i<rows-3 && j<cols-3 &&
					areEqual(mat[i][j],mat[i+1][j+1],mat[i+2][j+2],mat[i+3][j+3]))
					min= Math.min(min,mat[i][j]);
			}
			return min;
	}
}

// shielded-thicket-30585
