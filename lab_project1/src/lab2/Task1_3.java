package lab2;

//import java.util.Arrays;

public class Task1_3 {
	// generate the next row based on the previous row
	// Ex. prevRow = {1} ==> nextRow = {1, 1}
	// Ex. prevRow = {1, 1} ==> nextRow = {1, 2, 1}
	public static int[] generateNextRow(int[] prevRow) {
		int[] nextRow = new int[prevRow.length + 1];
		for (int i = 0; i < nextRow.length; i++) {
			if( i ==0 || i == nextRow.length-1) {
				nextRow[i] = 1;
			}else {
				nextRow[i] = prevRow[i] + prevRow[i-1];
			}
		}
		return nextRow;
	}

	// get the nth row.
	// For example: n=1 ==> {1}, n=2 ==> {1, 1}, ...
	public static int[] getPascalTriangle(int n) {
		if (n ==1) {
			return new int [] {1};
		}else {
			int []prev = getPascalTriangle(n-1);
			return generateNextRow(prev);
		}
	}

	// This method is used to display a Pascal triangle based
	// Where n represents the number of rows
	public static void printPascalTriangle(int row) {
		int [][] pascalTriagle = new int [row][];
		for (int i = 0; i < pascalTriagle.length; i++) {
			pascalTriagle[i] = getPascalTriangle(i+1);
		}
		for (int i = 0; i < pascalTriagle.length; i++) {
			for (int j = 0; j < pascalTriagle[i].length; j++) {
				System.out.print(pascalTriagle[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		printPascalTriangle(6);
	}
}
