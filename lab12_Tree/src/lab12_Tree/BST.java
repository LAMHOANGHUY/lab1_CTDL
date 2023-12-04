package lab12_Tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	public BNode<E> getRoot() {
		return root;
	}

	// Add element e into BST
	public void add(E e) {
		if (root == null) {
			root = new BNode<E>(e);

		} else {
			root.add(e);
		}
	}

	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		for (E element : col) {
			add(element);
		}
	}

	// compute the depth of a node in BST
	public int depth(E value) {
		return root != null ? root.depth(value) : -1;
	}

	// compute the height of BST
	public int height() {
		return root != null ? root.height() - 1 : -1;
	}

	// Compute total nodes in BST
	public int size() {
		return size(root);
	}

	private int size(BNode<E> node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + size(node.getLeft()) + size(node.getRight());
		}
	}

	// Check whether element e is in BST
	public boolean contains(E e) {
		if (root == null) {
			return false; // Tree is empty
		}
		return root.contains(e);
	}

	// Find the minimum element in BST
	public E findMin() {
		if (root == null) {
			return null;
		}
		return root.findMin();
	}

	// Find the maximum element in BST
	public E findMax() {
		if (root == null) {
			return null;
		}
		return root.findMax();
	}
	public boolean remove(E e) {
        if (root == null) {
            return false;
        } else {
            if (e.equals(root.getData())) {
                BNode<E> auxRoot = new BNode<>(null);
                auxRoot.setLeft(root);
                boolean result = root.remove(e, auxRoot);
                root = auxRoot.getLeft();
                return result;
            } else {
                return root.remove(e, null);
            }
        }
    }

	// get the descendants of a node
	public List<E> descendants(E data) {
		List<E> descendantsList = new ArrayList<>();
		if (this.root.findNode(root, data) != null) {
			if (root.getData().compareTo(data) == 0)
				return descendantsList;
			this.root.descendants(root, data, descendantsList);
		} else {
			return null;
		}
		return descendantsList;
	}

	// get the ancestors of a node
    public List<E> ancestors(E data) {
        List<E> ancestorList = new ArrayList<>();
        if (this.root.findNode(root, data) == null || this.root.isLeaf(this.root.findNode(root, data)))
            return ancestorList;
        BNode<E> flagNode = this.root.findNode(root, data);
        this.root.ancestors(flagNode, ancestorList);
        return ancestorList;
    }

	// display BST using inorder approach
	public void inorder() {
		inorder(root);
	}

	private void inorder(BNode<E> node) {
		if (node != null) {
			inorder(node.getLeft());
			System.out.print(node.getData() + " ");
			inorder(node.getRight());
		}
	}

	public void preorder() {
		if (root != null) {
			root.preorder(); // Start the preorder traversal from the root
		}
	}

	public void postorder() {
		if (root != null) {
			root.postorder();
		}
		System.out.println(); // Print a new line after the traversal
	}

}


