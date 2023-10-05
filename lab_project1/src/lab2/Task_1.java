package lab2;

public class Task_1 {
	// S(n)=1-2+3-4+…+ ((-1)^(n+1) ).n , n>0
	public static int getSn1(int n) {
		if (n == 1) {
			return 1;
		} else {
			return (int) (Math.pow(-1, (n + 1))) * n + getSn1(n - 1);
		}
	}

	// S(n)=1+1.2+1.2.3+…+1.2.3…n, n>0
	public static int getSn2(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 0) {
			return 0;
		}
		if (n > 0) {
			return getSn2Add(n) * getSn2(n - 1);
		}
		return 0;
	}

	public static int getSn2Add(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		} if(n > 0) {
			return n * getSn2Add(n- 1);
		}
		return 0;
	}

	// S(n)=1^2+2^2+3^2+....+n^2 , n>0
	public static int getSn3(int n) {
		if (n == 1) {
			return 1;
		} else {
			return (int) Math.pow(n, 2) + getSn3(n - 1);
		}
	}

	public static double masou(int n) {
		if (n <= 0) {
			return 1;
		} else {
			return (double) n * 2 * masou(n - 1);
		}
	}

	// S(n)=1+1/2+1/(2.4)+1/(2.4.6)+…+1/(2.4.6.2n), n>=0
	public static double getSn4(int n) {
		if (n == 0) {
			return 1;
		} else {
			return (double) 1 / masou(n) + getSn4(n - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println("getSn1 is :" + getSn1(3));
		System.out.println("getSn2 is :" + getSn2(4));
		System.out.println("getSn3 is :" + getSn3(6));
		System.out.println("getSn4 is :" + getSn4(4));

	}
}

