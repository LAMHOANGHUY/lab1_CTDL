package lab6;

public class SinglyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;

	public SinglyLinkedList() {
		super();
	}

	// Returns the number of elements in the list.
	public int size() {
		return size;
	}

	// Returns true if the list is empty, and fals otherwise.
	public boolean isEmpty() {
		return size == 0;
	}

	// Returns (but does not remove) the first element in the list.
	public E first() {
		if (isEmpty()) {
			return null;
		}
		return head.getData();
	}

	// Returns (but does not remove) the last element in the list.
	public E last() {
		if (isEmpty()) {
			return null;
		}
		return tail.getData();
	}

	// Adds a new element to the front of the list.
	public void addFirst(E e) {
		Node<E> newNode = new Node<>(e, head);
		if (isEmpty()) {
			tail = newNode;
		}
		newNode.next = head;
		head = newNode;
		size = size + 1;
	}

	// Adds a new element to the end of the list.
	public void addLast(E e) {
		Node<E> newNode = new Node<E>(e);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = null;
			tail.next = newNode;
			tail = newNode;
			size = size + 1;
		}

	}

	// Removes and returns the first element of the list.
	public E removeFirst() {
		E FirstRemoved = head.getData();
		if (isEmpty()) {
			return null;
		}
		head = head.next;
		size = size - 1;
		return FirstRemoved;
	}

	// Removes and returns the last element of the list.
	public E removeLast() {
		E lastRemoved = tail.getData();
		if (isEmpty()) {
			return null;
		}
		Node<E> current = head;
		while (current.next != tail) {
			current = current.next;
		}
		tail = current;
		size = size - 1;
		tail.next = null;

		return lastRemoved;
	}

	public void display() {
		Node<E> current = head;
		if (head == null) {
			System.out.println("head is "
					+ "empty");
			return;
		} else {
			while (current != null) {
				System.out.print(current.getData() + " ");
				current = current.next;
			}
		}

	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(4);
		list.addFirst(7);
		list.addFirst(9);
		list.addLast(3);
		list.display();
		System.out.println("\nList First : " + list.first());
		System.out.println("List Last    : "  + list.last());
		System.out.println("removeFirst  : " + list.removeFirst());
		System.out.println("removeLast   : " + list.removeLast());
		
		System.out.println("List display is : ");
		list.display();
	}
}
