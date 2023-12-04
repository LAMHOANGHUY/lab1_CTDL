package lab12_Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class BNode<E extends Comparable<E>> {
	private E data;
	private BNode<E> left;
	private BNode<E> right;

	public BNode(E data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public BNode(E data, BNode<E> left, BNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public E getData() {
		return data;
	}

	public BNode<E> getLeft() {
		return left;
	}

	public BNode<E> getRight() {
		return right;
	}

	public void setData(E data) {
		this.data = data;
	}

	public void setLeft(BNode<E> left) {
		this.left = left;
	}

	public void setRight(BNode<E> right) {
		this.right = right;
	}

	// Task 1

	// Add element e into BNode
	public void add(E e) {
		int cmp = e.compareTo(this.data);
		if (cmp < 0) {
			if (this.left == null) {
				this.left = new BNode<>(e);
			} else {
				this.left.add(e);
			}
		} else if (cmp > 0) {
			if (this.right == null) {
				this.right = new BNode<>(e);
			} else {
				this.right.add(e);
			}
		} else {
			System.out.println("Bỏ qua phần tử trùng lặp " + e);
		}
	}

	// Add a collection of elements col into BNode
	public void add(Collection<E> col) {
		for (E element : col) {
			add(element);
		}
	}

	// compute the depth of a node in BNode
	public int depth(E value) {
		return depthHelper(this, value);
	}

	private int depthHelper(BNode<E> bNode, E value) {
		if (bNode == null) {
			return -1; // Giả sử nút không tồn tại trong cây
		}
		if (value.equals(bNode.data)) {
			return 0; // Nút hiện tại chính là nút cần tìm
		} else if (value.compareTo(bNode.data) < 0) {
			// Nếu giá trị cần tìm nhỏ hơn giá trị của nút hiện tại, điều này nằm ở cây con
			// bên trái
			int leftDepth = depthHelper(bNode.left, value);
			return leftDepth != -1 ? leftDepth + 1 : -1;
		} else {
			// Nếu giá trị cần tìm lớn hơn giá trị của nút hiện tại, điều nà
			int rightDepth = depthHelper(bNode.right, value);
			return rightDepth != -1 ? rightDepth + 1 : -1;
		}
	}

	// compute the height of BNode
	public int height() {
		return 1 + Math.max(getHeight(left), getHeight(right));
	}

	private int getHeight(BNode<E> node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}

	// Compute total nodes in BNode
	public int size() {
		// TODO
		return -1;
	}

	// Check whether element e is in BNode
	public boolean contains(E e) {
		int comp = e.compareTo(data);
		if (comp == 0) {
			return true; // Phần tử e được tìm thấy ở nút hiện tại
		} else if (comp < 0 && left != null) {
			return left.contains(e); // Tìm kiếm trong cây con bên trái
		} else if (comp > 0 && right != null) {
			return right.contains(e); // Tìm kiếm trong cây con bên phải
		}
		return false; // Phần tử không được tìm thấy trong cây
	}

	// Find the minimum element in BNode
	public E findMin() {
		if (left != null) {
			return left.findMin();
		} else {
			return data;
		}

	}

	// Find the maximum element in BNode
	public E findMax() {
		if (right != null) {
			return right.findMax();
		} else {
			return data;
		}
	}

	// Remove element e from BNode
	public boolean remove(E target, BNode<E> parent) {
		if (target.compareTo(data) < 0) {
			if (left != null) {
				return left.remove(target, this);
			} else {
				return false;
			}
		} else if (target.compareTo(data) > 0) {
			if (right != null) {
				return right.remove(target, this);
			} else {
				return false;
			}
		} else {
			if (left != null && right != null) {
				data = right.getMin();
				right.remove(data, this);
			} else if (parent.left == this) {
				parent.left = (left != null) ? left : right;
			} else if (parent.right == this) {
				parent.right = (left != null) ? left : right;
			}
			return true;
		}
	}

	private E getMin() {
		if (left == null) {
			return data;
		} else {
			return left.getMin();
		}
	}

	public BNode<E> findNode(BNode<E> tree, E e) {
		if (tree == null)
			return null;
		if (tree.getData().compareTo(e) == 0)
			return tree;
		if (tree.getData().compareTo(e) < 0) {
			return findNode(tree.getRight(), e);
		} else
			return findNode(tree.getLeft(), e);
	}

	public boolean isLeaf(BNode<E> t) {
		return t.getLeft() == null && t.getRight() == null;
	}

	public void descendants(BNode<E> t, E data, List<E> list) {
		if (t.getData().compareTo(data) != 0)
			list.add(t.getData());
		if (t.getData().compareTo(data) > 0 && t.getLeft() != null && t.getLeft().getData().compareTo(data) != 0) {
			descendants(t.getLeft(), data, list);
		} else if (t.getData().compareTo(data) < 0 && t.getRight() != null
				&& t.getRight().getData().compareTo(data) != 0) {
			descendants(t.getRight(), data, list);
		}
	}

	public void ancestors(BNode<E> t, List<E> list) {
		if (t != null) {
			if (t.getLeft() != null)
				list.add(t.getLeft().getData());
			ancestors(t.getLeft(), list);
			if (t.getRight() != null)
				list.add(t.getRight().getData());
			ancestors(t.getRight(), list);
		}
	}

	// Task2

	public void inorder() {
		if (left != null) {
			left.inorder();
		}
		System.out.print(data + " ");
		if (right != null) {
			right.inorder();
		}
	}

	public void preorder() {
		System.out.print(data + " "); // duyệt và xử lí nút hiện tại

		if (left != null) {
			left.preorder(); // duyệt cây con bên trái đệ quy
		}

		if (right != null) {
			right.preorder(); // duyệt cây con bên phải đệ quy
		}
	}

	public void postorder() {
		if (left != null) {
			left.postorder();
		}
		if (right != null) {
			right.postorder();
		}
		System.out.print(data + " ");
	}

}
