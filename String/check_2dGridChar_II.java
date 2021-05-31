class check_2dGridChar_II{
/* Approach: We are marking visited and then again we are putting the real value in
  it because if we do not put the real value then for different cases
  the '#' will be there */
	static boolean findmatch(char mat[][], String pat, int x, int y,
							int nrow, int ncol, int level){
		int l = pat.length();

		// Pattern matched
		if (level == l)
			return true;

		// Out of Boundary || not a match
		if (x < 0 || y < 0 || x >= nrow || y >= ncol || mat[x][y] != pat.charAt(level))
			return false;

			// If grid matches with a letter while recursion
			// Marking this cell as visited
		char temp = mat[x][y];
		mat[x][y] = '#';

		// finding subpattern in 4 directions
		boolean res = findmatch(mat, pat, x - 1, y, nrow, ncol, level + 1) |
					  findmatch(mat, pat, x + 1, y, nrow, ncol, level + 1) |
					  findmatch(mat, pat, x, y - 1, nrow, ncol, level + 1) |
					  findmatch(mat, pat, x, y + 1, nrow, ncol, level + 1);
 
		// marking this cell
		// as unvisited again
		mat[x][y] = temp;
		return res;
	}

	// Function to check if the word exists in the grid or not
	static int checkMatch(char mat[][], String pat, int nrow, int ncol){
		int count = 0;
		int l = pat.length();

		// if total characters in matrix is
		// less then pattern lenghth
		if (l > nrow * ncol)
			return 0;

		// Traverse in the grid
		for (int i = 0; i < nrow; i++){
			for (int j = 0; j < ncol; j++){
				// If first letter matches, then recur and check
				if (mat[i][j] == pat.charAt(0))
					if (findmatch(mat, pat, i, j, nrow, ncol, 0)){
						count++;
					}
			}
		}
		return count;
}

	public static void main(String[] args){
		// char grid[][] = {   "axmy".toCharArray(),
		// 					"bgdf".toCharArray(),
		// 					"xeet".toCharArray(),
		// 					"raks".toCharArray() };

		char grid[][] = {   "axmy".toCharArray(),
							"bagf".toCharArray(),
							"geet".toCharArray(),
							"raks".toCharArray() };

		// Function to check if word exists or not
		int r=grid.length;
		int c=grid[0].length;
		System.out.println(checkMatch(grid, "geeks", r, c));
		// if (checkMatch(grid, "geeks", r, c))
		// 	System.out.println("Yes");
		// else
		// 	System.out.println("No");
	}
}
