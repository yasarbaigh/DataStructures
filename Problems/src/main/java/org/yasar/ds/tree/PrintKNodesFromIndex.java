package oy.ds.tree;

import oy.ds.tree.PrintBTVertical.Node;

/**
 * http://stackoverflow.com/questions/7865055/nodes-at-a-distance-k-in-binary-tree
 * 
 * 
 * @author kingpin
 *
 */
public class PrintKNodesFromIndex {
	private void printNodeAtN(Node root, Node start, int k) {
	    if (root != null) {
	        // calculate if the start is in left or right subtree - if start is
	        // root this variable is null
	        Boolean left = false;//isLeft(root, start);
	        int depth = depth(root, start, 0);

	        if (depth == -1)
	            return;
	        printNodeDown(root, k);

	        if (root == start)
	            return;

	        if (left) {
	            if (depth > k) {
	                // print the nodes at depth-k level in left tree
	                printNode(depth - k - 1, root.left);
	            } else if (depth < k) {
	                // print the nodes at right tree level k-depth
	                printNode(k - depth - 1, root.right);
	            } else {
	                System.out.println(root.data);
	            }
	        } else {
	            // similar if the start is in right subtree
	            if (depth > k) {
	                // print the nodes at depth-k level in left tree
	                printNode(depth - k - 1, root.right);
	            } else if (depth < k) {
	                // print the nodes at right tree level k-depth
	                printNode(k - depth - 1, root.left);
	            } else {
	                System.out.println(root.data);
	            }
	        }
	    }
	}

	    // print the nodes at depth - "level" from root
	void printNode(int level, Node root) {
	    if (level == 0 && root != null) {
	        System.out.println(root.data);
	    } else {
	        printNode(level - 1, root.left);
	        printNode(level - 1, root.right);
	    }

	}

	// print the children of the start
	void printNodeDown(Node start, int k) {
	    if (start != null) {
	        if (k == 0) {
	            System.out.println(start.data);
	        }
	        printNodeDown(start.left, k - 1);
	        printNodeDown(start.right, k - 1);
	    }
	}

	private int depth(Node root, Node node, int d) {
	    if (root == null)
	        return -1;
	    if (root != null && node == root) {
	        return d;
	    } else {
	        int left = depth(root.left, node, d + 1);
	        int right = depth(root.right, node, d + 1);
	        if (left > right)
	            return left;
	        else
	            return right;
	    }
	}

	

}
