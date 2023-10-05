package lab2;

public class Task1_2 {
	// get the nth value of the Fibonacci series.
	public static int getFibonacci(int n) {
		if (n == 1 ) {
			return 1;
		}if(n == 0) {
			return 0;
		}
		else {
			return  getFibonacci(n-1) + getFibonacci(n-2);
		}
	}

	// This method is used to display a Fibonaccci series based on
	// the parameter n. Ex. n=10 ==> 0 1 1 2 3 5 8 13 21 34
	public static void printFibonacci(int n) {
		System.out.println("printFibonacci is :");
		for (int i = 0; i < n; i++) {
			System.out.print(getFibonacci(i)+ " ");
		}
	}
	public static void main(String[] args) {
		int n = 10 ;
		printFibonacci(n);
	}
}