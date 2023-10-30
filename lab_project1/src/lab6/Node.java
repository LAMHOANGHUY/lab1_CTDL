package lab6;

public class Node<E> {
	private E data;
	public Node<E> next;
	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "[data : " + data + ", next :" + next + "]";
	}

	public Node(E data) {
		this.data = data;
	}

	public Node(E data, Node<E> next) {
		this.data = data;
		this.next = next;
	}


}
