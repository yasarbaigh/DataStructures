package oy.ds.tree;

public class TreeUtil
{
	public static Node1 getRoot()
	{
		Node1 root = new Node1(4);
		treeInsert(root, 2);
		treeInsert(root, 1);
		treeInsert(root, 3);
		treeInsert(root, 6);
		treeInsert(root, 5);
		treeInsert(root, 7);
		return root;
	}
	
	
	public static Node1 getRoot1()
	{
		Node1 root = new Node1(8);
		treeInsert(root, 4);
		treeInsert(root, 12);
		
		treeInsert(root, 2);
		treeInsert(root, 6);
		treeInsert(root, 10);
		treeInsert(root, 15);
		
		treeInsert(root, 1);
		treeInsert(root, 3);
		treeInsert(root, 5);
		treeInsert(root, 7);
		treeInsert(root, 9);
		treeInsert(root, 11);
		treeInsert(root, 14);
		treeInsert(root, 16);
		
		return root;
	}
	
	/*
	 * Given a non-empty tree, insert a new Node1 in the proper place. The tree
	 * must be non-empty because Java's lack of reference variables makes that
	 * case and this method messier than they should be.
	 */
	public static void treeInsert(Node1 root, int newData)
	{
		if(newData <= root.data) {
			if(root.left != null)
				treeInsert(root.left, newData);
			else
				root.left = new Node1(newData);
		}
		else {
			if(root.right != null)
				treeInsert(root.right, newData);
			else
				root.right = new Node1(newData);
		}
	}

	// Do an inorder traversal to print a tree
	// Does not print the ending "\n"
	public static void printTreeInOrder(Node1 root)
	{
		if(root == null)
			return;
		printTreeInOrder(root.left);
		System.out.print(Integer.toString(root.data) + " ");
		printTreeInOrder(root.right);
	}
	
	// Do an pre-order traversal to print a tree
	// Does not print the ending "\n"
	public static void printTreePreOrder(Node1 root)
	{
		if(root == null)
			return;
		System.out.print(Integer.toString(root.data) + " ");
		printTreePreOrder(root.left);		
		printTreePreOrder(root.right);
	}

	// Do a traversal of the list and print it out
	public static void printList(Node1 head)
	{
		Node1 current = head;

		while (current != null) {
			System.out.print(Integer.toString(current.data) + " ");
			current = current.right;
			if(current == head)
				break;
		}

		System.out.println();
	}
	


}
