package lab4;

import java.util.Arrays;

public class Task2 {
	public static void mergeSort(int[] array) {
		if (array.length <= 1) {
			return;
		}
		int mid = array.length / 2;
		int[] left = new int[mid];
		int[] right = new int[array.length - mid];
		System.arraycopy(array, 0, left, 0, mid);
		System.arraycopy(array, mid, right, 0, array.length - mid);

		mergeSort(left);
		mergeSort(right);
		merge(left, right, array);
	}

	private static void merge(int[] left, int[] right, int[] array) {
		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				array[k] = left[i];
				i++;
			} else {
				array[k] = right[j];
				j++;
			}
			k++;
		}

		while (i < left.length) {
			array[k] = left[i];
			i++;
			k++;
		}

		while (j < right.length) {
			array[k] = right[j];
			j++;
			k++;
		}
	}

	// sort by ascending order
	public static void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int pivotIndex = partition(array, low, high);
			quickSort(array, low, pivotIndex - 1);
			quickSort(array, pivotIndex + 1, high);
		}
	}

	private static int partition(int[] array, int low, int high) {
		int pivot = array[high];
		int i = low - 1; // i la chỉ số của phần tử nhỏ nhất lớn hơn pivot.
		for (int j = low; j < high; j++) {
			//phần tử tại chỉ số j nhỏ hơn hoặc bằng pivot, 
			//hãy hoán đổi phần tử đó với phần tử tại chỉ số i và tăng i lên 1.
			if (array[j] <= pivot) {
				i++;
				swap(array, i, j);
			}
		}
		//hoán đổi phần tử tại chỉ số i + 1 với pivot.
		swap(array, i + 1, high);
		return i + 1;
	}

	private static void swap(int[] array, int i, int j) {
		// TODO Auto-generated method stub
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		
	}

	public static void main(String[] args) {
		int[] array1 = { 5, 2, 4, 1, 3, -2, 5, -7, 8 };
		mergeSort(array1);
		System.out.println("Mảng sau khi dùng Merge Sort:");
		System.out.println(Arrays.toString(array1));
		
		int[] array2 = {5, 3, 2, 1, 4 };
		Task2.quickSort(array2, 0, array2.length -1);
		System.out.println("Mảng sau khi dùng Quick Sort:");
		System.out.println(Arrays.toString(array2));
	}
}
