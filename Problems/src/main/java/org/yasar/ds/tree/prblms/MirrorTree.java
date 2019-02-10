package org.yasar.ds.tree.prblms;

// https://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
//Java program to convert binary tree into its mirror 

/* Class containing left and right child of current 
node and key value*/

/* Change a tree so that the roles of the  left and 
right pointers are swapped at every node. 
So the tree... 
   4 
  / \ 
 2   5 
/ \ 
1   3 

is changed to... 
   4 
  / \ 
 5   2 
    / \ 
   3   1 
*/

class MirrorTreeNode {
	int data;
	MirrorTreeNode left, right;

	public MirrorTreeNode(int item) {
		data = item;
		left = right = null;
	}
}

public class MirrorTree {
	MirrorTreeNode root;

	void mirror() {
		root = mirror(root);
	}

	MirrorTreeNode mirror(MirrorTreeNode node) {
		if (node == null)
			return node;

		/* do the subtrees */
		MirrorTreeNode left = mirror(node.left);
		MirrorTreeNode right = mirror(node.right);

		/* swap the left and right pointers */
		node.left = right;
		node.right = left;

		return node;
	}

	void inOrder() {
		inOrder(root);
	}

	/*
	 * Helper function to test mirror(). Given a binary search tree, print out
	 * its data elements in increasing sorted order.
	 */
	void inOrder(MirrorTreeNode node) {
		if (node == null)
			return;

		inOrder(node.left);
		System.out.print(node.data + " ");

		inOrder(node.right);
	}

	/* testing for example nodes */
	public static void main(String args[]) {
		/* creating a binary tree and entering the nodes */
		MirrorTree tree = new MirrorTree();
		tree.root = new MirrorTreeNode(1);
		tree.root.left = new MirrorTreeNode(2);
		tree.root.right = new MirrorTreeNode(3);
		tree.root.left.left = new MirrorTreeNode(4);
		tree.root.left.right = new MirrorTreeNode(5);

		/* print inorder traversal of the input tree */
		System.out.println("Inorder traversal of input tree is :");
		tree.inOrder();
		System.out.println("");

		/* convert tree to its mirror */
		tree.mirror();

		/* print inorder traversal of the minor tree */
		System.out.println("Inorder traversal of binary tree is : ");
		tree.inOrder();

	}
}
