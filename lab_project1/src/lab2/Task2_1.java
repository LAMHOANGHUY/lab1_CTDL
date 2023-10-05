package lab2;

public class Task2_1 {
	// Ta áp dụng công thức : " công thức = i*2-1 "
	// i =1 => 1*2-1 => 1 dấu sao
	// i =2 => 2*2-1 => 3 dấu sao
	// i =3 => 3*2-1 => 5 dấu sao
	// i =4 => 4*2-1 => 7 dấu sao
	// Cân giữa tam giác => ta in những dấu cách (for từ cao xuống thấp vd từ 6 xuống 1)
	// ---*
	// --***
	// -*****
	// *******
	
	public static void drawPyramid(int n) {
		// In ra chiều cao tam giác  
		for (int i = 1; i <= n; i++) {
			// căn giữa tam giác 
			for (int k = n; k > i; k--) {
				System.out.print("-");
			}
			// in ra dấu * trên mồi dòng theo cthuc 2*i-1
			for (int j = 1; j <= i*2-1; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	public static void main(String[] args) {
		int n = 6;
		drawPyramid(n);
	}
}
