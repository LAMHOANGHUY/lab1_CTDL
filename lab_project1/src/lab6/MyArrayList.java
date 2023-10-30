package lab6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	// creates an array of double-size if the array of elements is full
	public void growSize() {
		if (size == elements.length) {
			E[] newElements = (E[]) new Object[elements.length * 2];
			// Copy the elements from the old array to the new array
			System.arraycopy(elements, 0, newElements, 0, elements.length);
			// Set the elements field to the new array
			elements = newElements;
		}
	}

	// Returns the number of elements in this list.
	public int size() {
		return size;
	}

	// Returns whether the list is empty.
	public boolean isEmpty() {
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] != null) {
				return true;
			}
		}
		return false;
	}

	// Returns (but does not remove) the element at index i.
	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size()) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size());
		}
		return elements[i];

	}

	// Replaces the element at index i with e, and returns the replaced element. ∗/
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size " + size);
		}
		E oldValue = elements[i];
		elements[i] = e;
		return oldValue;
	}

	// It is used to append the specified element at the end of a list.
	public boolean add(E e) {
		if (size == elements.length) {
			growSize();
		}
		elements[size++] = e;
		return true;
	}

	// Inserts element e to be at index i, shifting all subsequent elements later.
	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size " + size);
		}
		if (size == elements.length) {
			growSize();
		}
		for (int j = size - 1; j >= i; j--) {
			elements[j + 1] = elements[j];
		}
		elements[i] = e;
		size++;
	}

	// Removes and returns the element at index i, shifting subsequent elements
	// earlier.
	public E remove(int i) throws IndexOutOfBoundsException {
		// Check if the index is within bounds.
//		i: chỉ số của phần tử cần xóa.
		if (i < 0 || i >= elements.length) {
			throw new IndexOutOfBoundsException();
		}
		// Get the element to be removed.
		E element = elements[i];
		// Dịch chuyển các ptu còn lại trong mảng về phía bên trái,
		// và trừ size đi sẽ mất giá trị cuối cùng
		for (int j = i; j < elements.length - 1; j++) {
			elements[j] = elements[j + 1];
		}
		size--; // chỉ chạy một lần
		return element;
	}

	// It is used to clear all elements in the list.
	public void clear() {
		// Set the size of the ArrayList to 0.
		this.size = 0;
	}

	// It is used to return the index in this list of the last occurrence of the
	// specified element, or -1 if the list does not contain this element.
	public int lastIndexOf(Object o) {
		// phương thức trong Java để trả về chỉ số của lần xuất hiện cuối cùng của một
		// phần tử cụ thể trong một danh sách.
		// cho ds lặp từ cuối về đầu .
		for (int i = this.size - 1; i >= 0; i--) {
			if (this.elements[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}

	// It is used to return an array containing all of the elements in this list in
	// the correct order.
	public E[] toArray() {
		return Arrays.copyOf(elements, size);
	}

	// It is used to return a shallow copy of an ArrayList.
	public MyArrayList<E> clone() {
		MyArrayList<E> clonedList = new MyArrayList<>(size);
		System.arraycopy(this.elements, 0, clonedList, 0, size);
		clonedList.size = size;
		return clonedList;
	}
	// It returns true if the list contains the specified element

	public boolean contains(E o) {
		for (int i = 0; i < size; i++) {
			if (elements[i] == null) {
				if (o == null) {
					return true;
				} else {
					// chạy xuống cuối for return false
				}
			} else if (elements[i].equals(o)) {
				return true;
			}
		}
		return false;
	}

	// It is used to return the index in this list of thefirst occurrenceof the
	// specified element, or-1 ifthe List
	// does not contain this element.

	public int indexOf(E o) {
		for (int i = 0; i < size; i++) {
			if (elements[i] == null) {
				if (o == null) {
					return i;
				} else {
					return -1;
				}
			} else if (elements[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}

	// It is used to remove the first occurrence of the specified element.

	public boolean remove(E e) {
		int index = indexOf(e);
		if (index != -1) {
			remove(index); // phương thức ở trên chứ ko phải cái này
			return true;
		}
		return false;
	}

	// It is used to sort the elements of the list on the basis of specified
	// comparator.

	public void sort(Comparator<E> c) {
		Object[] newElements = Arrays.copyOf(elements, size);
		Arrays.sort(newElements, (Comparator) c);
		System.arraycopy(newElements, 0, elements, 0, size);

//		Object[] newElements = Arrays.copyOf(elements, size);
//		Arrays.sort(newElements, (Comparator) c);
//
//		for (int i = 0; i < size; i++) {
//			elements[i] = (E) newElements[i];
//		}
	}

	public static void main(String[] args) {
		MyArrayList<Integer> list = new MyArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println("size = " + list.size());

		list.set(3, 5);
		for (int i = 0; i < list.size; i++) {
			System.out.print(list.get(i) + ", ");
		}

//		1/ test add(E e)
		list.add(6);
		list.add(2);
		list.add(9);
		list.add(2);
		System.out.println();
		for (int i = 0; i < list.size; i++) {
			System.out.print(list.get(i) + ", ");
		}

//		2/ test add(int i, E e)
		System.out.println();
		list.add(3, 7);
		for (int i = 0; i < list.size; i++) {
			System.out.print(list.get(i) + ", ");
		}

//		3/ test remove(int i)
		list.remove(3);
		System.out.print("\nremove: ");
		for (int i = 0; i < list.size; i++) {
			System.out.print(list.get(i) + ", ");
		}

//		4/ test lastIndexOf(Object o)
		System.out.println();
		System.out.println("lastIndexOf: " + list.lastIndexOf(3));

//		5/ test toArray()
		System.out.println(Arrays.toString(list.toArray()));

//		6/ test contains
		System.out.println(list.contains(3));
		System.out.println(list.contains(10));

//		7/ test indexOf(int i)
		System.out.println(list.indexOf(3));

//		8/ test remove(E e)
		System.out.println("remove: " + list.remove(1));
		for (int i = 0; i < list.size; i++) {
			System.out.print(list.get(i) + ", ");
		}

//		9/ test sort
		System.out.println("\nsort: ");
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer s1, Integer s2) {
				return s1.compareTo(s2); // sắp xếp tăng dần
			}
		});
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + ", ");
		}
	}
}
