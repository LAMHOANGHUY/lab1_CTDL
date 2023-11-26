package jh;

import java.util.LinkedList;
import java.util.Queue;

public class kk {
	public static <E> void mirror(Queue<E> input) {
		Queue<E> temp = new LinkedList<>();
		// Sao chép các phần tử từ hàng đợi gốc sang hàng đợi tạm thời
		for (E element : input) {
			temp.add(element);
		}
		// Sao chép lại các phần tử từ hàng đợi tạm thời sang hàng đợi gốc
		while (!temp.isEmpty()) {
			input.add(temp.poll());
		}
	}
	public static void main(String[] args) {
		Queue<String> queue2 = new LinkedList<>();
		queue2.add("a");
		queue2.add("b");
		queue2.add("c");
		System.out.println("Before mirroring :" + queue2);
		mirror(queue2);
		System.out.println("After mirroring  :" + queue2);
	}
}
