package lab2;

public class Task1_4 {
	public static void solveTowerOfHanoi(int disk, char source, char auxiliary, char target) {
		if (disk == 1) {
			System.out.println("Di chuyển đĩa 1 từ " + source + " đến " + target);
			return;
		}

		// Di chuyển n-1 đĩa từ cột nguồn sang cột trung gian sử dụng cột đích
		solveTowerOfHanoi(disk - 1, source, target, auxiliary);

		// Di chuyển đĩa còn lại từ cột nguồn sang cột đích
		System.out.println("Di chuyển đĩa " + disk + " từ " + source + " đến " + target);

		// Di chuyển n-1 đĩa từ cột trung gian sang cột đích sử dụng cột nguồn
		solveTowerOfHanoi(disk - 1, auxiliary, source, target);
	}

	public static void main(String[] args) {
		int disk = 3; // Số lượng đĩa
		char source = 'A'; // Cột nguồn
		char auxiliary = 'B'; // Cột trung gian
		char target = 'C'; // Cột đích
		// Gọi hàm giải bài toán Tháp Hà Nội
		solveTowerOfHanoi(disk, source, auxiliary, target);
	}
}
