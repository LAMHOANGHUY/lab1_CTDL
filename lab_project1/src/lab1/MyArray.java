package lab1;

import java.util.Arrays;
import java.util.Iterator;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		super();
		this.array = array;
	}

	// Method 1 :
	// Method mirror that outputs the contents of an array in a
	// reverse order like a mirror
	// Example: input [1, 2, 3] ==> output: [1, 2, 3, 3, 2, 1]
	public int[] mirror() {
		int n = array.length;
		int[] newArray = new int[n * 2];
		// n*2 vì nếu đề bài là cho mảng lập ngược chiều
		// vd: array = {1,2,3} => method1 : newArray = {1,2,3,3,2,1}
		for (int i = 0; i < n; i++) {
			newArray[i] = array[i];
			// chạy từ vị trí thứ ba trở đi sau vị trí 0,1,2
			newArray[2 * n -i- 1] = array[i];
			// vd newArray đang có 3 pt thì nhân 2 ra 6 xong
		}
		return newArray;

	}

	// Method 2 :
	// removes all duplicate elements from an array and returns a
	// new array
	// Input: 1 3 5 1 3 7 9 8
	// Output: 1 3 5 7 9 8

	public int[] removeDuplicate() {
		// Xoá những số trùng trong mảng.
		int n = array.length;
		int value = 0;
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			boolean check = false;
			// mảng j = 0 chỉ so sánh phần tử vị trí mảng đầu tiên
			// vs giá trị ptu mảng banđầu
			for (int j = 0; j < value; j++) {
				if (array[i] == array[j]) {
					check = true;
					break;
				}
			}
			if (!check) {
				result[value] = array[i];
				value++;
			}
		}
		int[] endArray = Arrays.copyOf(result, value);
		return endArray;
	}
	// Method 3 :

	public int[] getMissingValues() {
		int n = array.length;
		int valueArray = 0;
		for (int i = 0; i < n - 1; i++) {
			if (array[i] + 1 != array[i + 1]) {
				valueArray += array[i + 1] - array[i] - 1;
			}
		}
		int[] ptuBiThieu = new int[valueArray];
		int index = 0;
		for (int i = 0; i < n - 1; i++) {
			if (array[i] + 1 != array[i + 1]) {
				int missingValue = array[i + 1] - array[i] - 1;

				for (int j = 1; j <= missingValue; j++) {
					ptuBiThieu[index] = array[i] + j;
					index++;
				}
			}
		}
		return ptuBiThieu;
	}

	// Method 4 :
	// Input: 10 11 12 -1 14 10 17 19 20
	// Output(k=3): 10 11 12 12 14 16 17 19 20
	public int[] fillMissingValues(int k) {
		int n = array.length;

		for (int i = 0; i < n - 1; i++) {
			// Đầu mảng
			if (array[0] == -1) {
				array[0] = (array[i + 1] + array[i + 2] + array[i + 3]) / k;
			}
			//Cuối mảng
			if (array[n - 1] == -1) {
				array[n - 1] = (array[n - 2] + array[n - 3] + array[n - 4]) / k;
			// Giữa mảng 
			} else if (array[i] == -1) {
				if (array[i - 1] + array[i - 2] + array[i + 1] > array[i + 1] + array[i + 2] + array[i - 1]) {
					array[i] = (array[i + 1] + array[i + 2] + array[i - 1]) / k;
				} else {
					array[i] = (array[i - 1] + array[i - 2] + array[i + 1]) / k;
				}

			}
		}

		return array;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3 };
		MyArray myArray1 = new MyArray(array);
		int[] newArray1 = myArray1.mirror();
		System.out.println("Dãy mới là : ");
		System.out.print(Arrays.toString(newArray1));
		System.out.println();

		int[] array2 = { 1, 3, 5, 1, 6, 7 };
		MyArray myArray2 = new MyArray(array2);
		int[] newArray2 = myArray2.removeDuplicate();
		System.out.println("Dãy mới sau khi xóa ptu là : ");
		System.out.println(Arrays.toString(newArray2));
		
		int[] array3 = { 1, 3, 4, 5, 7 };
		MyArray myArray3 = new MyArray(array3);
		int[] newArray3 = myArray3.getMissingValues();
		System.out.println("Những sô còn thiếu trong dãy là  : ");
		System.out.println(Arrays.toString(newArray3));
		
		int[] array4 = { 10 ,11, 12, -1, 14 ,10 ,17, 19, 20 };
		int k =3 ;
		MyArray myArray4 = new MyArray(array4);
		int[] newArray4 = myArray4.fillMissingValues(k);
		System.out.println("Những sô còn thiếu trong dãy là  : ");
		System.out.println(Arrays.toString(newArray4));
		
	}
}
