package lab12_Tree;

public class Test {
	public static void main(String[] args) {
		// Tạo một cây BST
		BST<Integer> bst = new BST<>();
		System.out.println("-Task 1 :");
		// Add node in the tree
		bst.add(5);
		bst.add(3);
		bst.add(7);
		bst.add(2);
		bst.add(4);
		bst.add(6);
		bst.add(8);

		// test phương thức depth :
		testDepth(bst, 5); // kq nên là 0 vì 5 là nút gốc
		testDepth(bst, 3); // kq nên là 1 vì 3 là con của 5
		testDepth(bst, 7); // kq nên là 1 vì 7 là con của 5
		testDepth(bst, 2); // kq nên là 2 vì 2 là con của 3
		testDepth(bst, 4); // kq nên là 2 vì 4 là con của 3
		testDepth(bst, 6); // kq nên là 2 vì 6 là con của 7
		testDepth(bst, 8); // kq nên là 2 vì 8 là con của 7
		testDepth(bst, 9); // kq nên là -1 vì k tồn tại trong BST.
		
		


		System.out.println("-------------------------");
		// test phương thức height :
		int treeHeight = bst.height();
		System.out.println("Height of the BST: " + treeHeight);
		System.out.println("-------------------------");

		// test phương thức size
		int treeSize = bst.size();
		System.out.println("Size of the tree: " + treeSize);
		System.out.println("-------------------------");

		// test phương thức contains
		System.out.println("Does BST contain 9? " + " => " + bst.contains(9));
		System.out.println("Does BST contain 7? " + " => " + bst.contains(7));
		System.out.println("-------------------------");

		// test phương thức fineMin và findMax
		System.out.println("findMin int the BST is :" + bst.findMin());
		System.out.println("findMax int the BST is :" + bst.findMax());
		System.out.println("-------------------------");

		// test pthuc remove
		System.out.println("Original tree:");
		bst.inorder(); // Print the tree in-order
		int keyToRemove = 8;
		if (bst.remove(keyToRemove)) {
			System.out.println("\n\nRemoved " + keyToRemove + ":");
			bst.inorder();
		} else {
			System.out.println("\n\nKey " + keyToRemove + " not found.");
		}

		System.out.println();
		System.out.println("-------------------------");

		// test phuong thuc descendants
		System.out.println("descendants" + bst.descendants(7));
		System.out.println("-------------------------");

		// test phuong thuc ancestors
		System.out.println("ancestors" + bst.ancestors(7));

		System.out.println("_________________________");
		System.out.println("-Task 2 : ");
		System.out.println("Inorder: ");
		bst.inorder();
		System.out.println();
		System.out.println("Preorder: ");
		bst.preorder();
		System.out.println();
		System.out.println("Postorder: ");
		bst.postorder();

	}

	private static void testDepth(BST<Integer> bst, int i) {
		int depth = bst.depth(i);
		if (depth != -1) {
			System.out.println("Depth of " + i + ": " + depth);
		} else {
			System.out.println(i + " not found in the BST.");
		}
	}

}
