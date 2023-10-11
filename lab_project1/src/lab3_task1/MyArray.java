package lab3_task1;

// linear search
public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	// To find the index of the target in the array. If the target
	// is not found in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 45
	// Output: 3
	// Task 1_1
	public int iterativeLinearSearch(int target) {
		int n = array.length - 1;
		for (int i = 0; i <= n; i++) {
			if (target == array[i]) {
				return i;
			}
		}
		return -1;
	}

	// To find the index of the target in the array. If the target
	// is not found in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 15
	// Output: -1
	public int recursiveLinearSearch(int target) {
		int n = array.length - 1;
		if (array[n] != target) {
			return -1;
		}
		if (array[n] == target) {
			return n;
		} else {
			return recursiveLinearSearch(n - 1);
		}
	}

	// Task 1_2
	// To find the index of the target in the sorted array. If the
	// target is not found in the array, then the method returns -1.
	public int iterativeBinarySearch(int target) {
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
//			int mid = (right + left) / 2;
			if(array[mid] == target) {
				return mid ;
			}
			if(array[mid] > target) {
				return mid -1;
			}else {
				return mid +1 ;
			}
		}

		return -1;
	}

	// To find the index of the target in the sorted array. If the
	// target is not found in the array, then the method returns -1.
	public int recursiveBinarySearch(int target) {
		return recursiveBinarySearchHelp(target, 0);
	}

	public int recursiveBinarySearchHelp(int target, int index) {
		if (array[index] != target) {
			return -1;
		} else if (array[index] == target) {
			return index;
		}
		return recursiveBinarySearchHelp(target, index + 1);
	}

	public static void main(String[] args) {
		// Task1_1
		int[] array = { 12, 10, 9, 45, 2, 10, 10, 45 };
		MyArray myArray = new MyArray(array);
		int value = myArray.iterativeLinearSearch(45);
		System.out.println("Output is :" + value);

		// Task1_2
		int value2 = myArray.iterativeBinarySearch(12);
		System.out.println( "Index of the target is : "+ value2);


	}

}
