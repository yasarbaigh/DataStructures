package org.yasar.ds.tree;

public class TreeNode  implements Comparable<TreeNode> {

	public int data;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int data) {
		this.data = data;
		
		left = null;
		right = null;
	}
	
	@Override
	public int compareTo(TreeNode that) {
		return this.data - that.data ;
	}

	@Override
	public String toString(){
		return this.data + "";
	}

	public static TreeNode getRoot()
	{
		TreeNode root = new TreeNode(4);
		treeInsert(root, 2);
		treeInsert(root, 1);
		treeInsert(root, 3);
		treeInsert(root, 6);
		treeInsert(root, 5);
		treeInsert(root, 7);
		return root;
	}
	
	
	public static TreeNode getRoot1()
	{
		TreeNode root = new TreeNode(8);
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
	 * Given a non-empty tree, insert a new TreeNode in the proper place. The tree
	 * must be non-empty because Java's lack of reference variables makes that
	 * case and this method messier than they should be.
	 */
	public static void treeInsert(TreeNode root, int newData)
	{
		if(newData <= root.data) {
			if(root.left != null)
				treeInsert(root.left, newData);
			else
				root.left = new TreeNode(newData);
		}
		else {
			if(root.right != null)
				treeInsert(root.right, newData);
			else
				root.right = new TreeNode(newData);
		}
	}

	// Do an inorder traversal to print a tree
	// Does not print the ending "\n"
	public static void printTreeInOrder(TreeNode root)
	{
		if(root == null)
			return;
		printTreeInOrder(root.left);
		System.out.print(Integer.toString(root.data) + " ");
		printTreeInOrder(root.right);
	}
	
	// Do an pre-order traversal to print a tree
	// Does not print the ending "\n"
	public static void printTreePreOrder(TreeNode root)
	{
		if(root == null)
			return;
		System.out.print(Integer.toString(root.data) + " ");
		printTreePreOrder(root.left);		
		printTreePreOrder(root.right);
	}

	// Do a traversal of the list and print it out
	public static void printList(TreeNode head)
	{
		TreeNode current = head;

		while (current != null) {
			System.out.print(Integer.toString(current.data) + " ");
			current = current.right;
			if(current == head)
				break;
		}

		System.out.println();
	}
	
}
