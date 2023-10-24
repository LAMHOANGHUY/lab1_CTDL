package lab5;

public class Task1 {
	// add 2 matrices
	public static int[][] addMatrix(int[][] a, int[][] b) {
		// Kiểm tra kích thước của hai ma trận
		if (a.length != b.length || a[0].length != b[0].length) {
			System.out.println("Hai ma trận không có cùng kích thước.");
			return null;
		}

		// Cộng từng phần tử của hai ma trận
		int[][] c = new int[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		}

		return c;
	}

	// subtract 2 matrices
	public static int[][] subtractMatrix(int[][] a, int[][] b) {
		// Kiểm tra kích thước của hai ma trận
		if (a.length != b.length || a[0].length != b[0].length) {
			System.out.println("Hai ma trận không có cùng kích thước.");
			return null;
		}
		// Trừ từng phần tử của hai ma trận
		int[][] d = new int[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				d[i][j] = a[i][j] - b[i][j];
			}
		}
		return d;

	}

	// multiply 2 matrices
	public static double[][] multiplyMatix(double[][] a, double[][] b) {
		if (a[0].length != b.length) {
			throw new IllegalArgumentException("Matrices must have compatible dimensions.");
		}

		int n = a.length;
		int m = b[0].length;
		int p = b.length;

		double[][] result = new double[n][m];

		for (int i = 0; i < n; i++) {
			double[] ai = a[i];
			for (int j = 0; j < m; j++) {
				double[] bj = b[j];
				double sum = 0;
				for (int k = 0; k < p; k++) {
					sum += ai[k] * bj[k];
				}
				result[i][j] = sum;
			}
		}

		return result;
	}

	// tranpose a matrix
	public static int[][] transposeMatrix(int[][] a) {
		// Lấy kích thước của ma trận đầu vào.
		int row = a.length;
		int colum = a[0].length;

		// Create a new matrix to store the transpose of the input matrix.
		int[][] transpose = new int[colum][row];

		// Iterate over the input matrix and transpose it.
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < colum; j++) {
				transpose[j][i] = a[i][j];
			}
		}
		// Return the transposed matrix.
		return transpose;
	}

	public static void main(String[] args) {
		int[][] a = { { 7, 2 }, { 5, 3 } };
		int[][] b = { { 2, 1 }, { 3, 1 } };
		int[][] c = addMatrix(a, b);

		// In ra ma trận kết quả
		System.out.println("Phép Cộng 2 matrix: ");
		for (int[] i : c) {
			for (int element : i) {
				System.out.print(element + " ");
			}
			System.out.println("");
		}
		System.out.println("----");

		int[][] d = subtractMatrix(a, b);
		System.out.println("Phép Trừ 2 matrix: ");
		// In ra ma trận kết quả
		for (int[] i : d) {
			for (int element : i) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
		System.out.println();
		// Matrices to be multiplied
		double[][] e = new double[][] { { 1.0, 2.0, 3.0 }, { 4.0, 6.0, 6.0 }, { 7.0, 8.0, 9.0 } };
		double[][] f = new double[][] { { 9.0, 13.0, 12.0 }, { 11.0, 14.0, 12.0 }, { 19.0, 17.0, 11.0 } };

		// Multiply the matrices
		double[][] result = multiplyMatix(e, f);
		System.out.println("------");
		System.out.println("Phép nhân 2 matrix: ");
		// Print the result
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("------");
		System.out.println("Matrix sau khi hoán vị:");
		int[][] g = { { 1, 3, 5 }, { 7, 8, 9 } };
		// int[][] h = {{1,2},{3,4},{5,6}};
		// Get the transpose of the matrix.
		int[][] transpose = transposeMatrix(g);
		// 2TH : g or h .
		// Print the transpose of the matrix.
		for (int i = 0; i < transpose.length; i++) {
			for (int j = 0; j < transpose[0].length; j++) {
				System.out.print(transpose[i][j] + " ");
			}
			System.out.println();
		}

	}
}
