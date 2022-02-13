import java.io.*;
import java.util.*;

class search2dGridChar{

	// Rows and columns in the given grid
	static int R, C;
	// For searching in all 8 direction
	static int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };

	// This function searches in all 8-direction from point (row, col) in grid[][]
	static boolean search2D(char[][] grid, int row, int col, String word){
		int dir,i,rd, cd;
		for( dir=0;dir<8;dir++) {
			rd=row+x[dir];
			cd=col+y[dir];

			//start from '1' because first char is already found
			for(i=1;i<word.length();i++){
				//check for bounds
				if(rd>=R || cd>=C || rd<0 || cd<0) //must not exceed limits
					break; 
				else if(grid[rd][cd] != word.charAt(i))
					break;

				//proceed in same direction
				rd+=x[dir];
				cd+=y[dir];
			}
			if (i==word.length())
				return true;
		}
		return false;
	}

	// Searches given word in a given
	// matrix in all 8 directions
	static void patternSearch(char[][] grid, String word){
		// Consider every point as starting
		// point and search given word
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				if ( grid[row][col] == word.charAt(0) && search2D(grid, row, col, word))
					System.out.println(word+" pattern found at " + row + ", " + col);
			}
		}
	}
	public static void main(String args[]){
		char[][] grid = {
			{ 'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S' },
			{ 'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K' },
			{ 'I', 'D', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E' }};

		R=grid.length;
		C=grid[0].length;
		patternSearch(grid, "GEEKS");
		System.out.println();
		// patternSearch(grid, "EE");
	}
}
