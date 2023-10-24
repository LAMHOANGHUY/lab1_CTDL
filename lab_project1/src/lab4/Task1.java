package lab4;

public class Task1 {
	// sort by descending order : thứ tự giảm dần
	public static void selectionSort(int[] array) {
		int n = array.length - 1;
		for (int i = 0; i < n; i++) {
			int max = i; // xếp giảm dần
			for (int j = i + 1; j < array.length; j++) {
				if (array[max] < array[j]) {
					max = j;
				}
			}
			// swap
			int temp = array[max];
			array[max] = array[i];
			array[i] = temp;
		}
	}

	// sort by descending order
	public static void bubbleSort(int[] array) {
		int n = array.length - 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (array[j] < array[j + 1]) {
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	// sort by descending order : thứ tự giảm dần
	public static void insertionSort(int[] array) {
//		Thuật toán sắp xếp chèn hoạt động bằng cách duyệt qua mảng, bắt đầu từ phần tử thứ hai. 
//		Phần tử thứ nhất được coi là đã được sắp xếp. 
		for (int i = 1; i < array.length; i++) {
			int key = i;
			while (key > 0 && array[key] > array[key - 1]) {
				// swap
				int temp = array[key];
				array[key] = array[key - 1];
				array[key - 1] = temp;
				key--;
			}
		}
	}

	public static void main(String[] args) {
		int[] array1 = { 1, 3, 9, 5, 6, 7 };
		selectionSort(array1);
		System.out.println("Code sau khi selectionSort :");
		for (int i = 0; i < array1.length; i++) {
			System.out.print(array1[i] + " ");
		}
		System.out.println();

		int[] array2 = { 5, 1, 4, 2, 8 };
		bubbleSort(array2);
		System.out.println("Code sau khi bubbleSort :");
		for (int i = 0; i < array2.length; i++) {
			System.out.print(array2[i] + " ");
		}
		System.out.println();
		int[] array3 = { 4, 3, 2, 10, 12, 1, 5, 6 };
		insertionSort(array3);
		System.out.println("Code sau khi insertionSort :");
		for (int i = 0; i < array3.length; i++) {
			System.out.print(array3[i] + " ");
		}
	}
}
