package org.yasar.ds.tree.prblms;

import java.util.Stack;

import org.yasar.ds.tree.Node1;
import org.yasar.ds.tree.TreeUtil;

/**
 * 
 * http://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
 * 
 * @author kingpin
 * 
 */
public class KDistanceFromTarget {

	/*
	 * Recursive function to print all the nodes at distance k in the tree (or
	 * subtree) rooted with given root. See
	 */
	public static void printkdistanceNodeDown(Node1 root, int k) {
		// Base Case
		if (root == null || k < 0)
			return;

		// If we reach a k distant node, print it
		if (k == 0) {
			System.out.print(root.data + ",");
			return;
		}

		// Recur for left and right subtrees
		printkdistanceNodeDown(root.left, k - 1);
		printkdistanceNodeDown(root.right, k - 1);
	}

	// Prints all nodes at distance k from a given target node.
	// The k distant nodes may be upward or downward. This function
	// Returns distance of root from target node, it returns -1 if target
	// node is not present in tree rooted with root.
	public static int printkdistanceNode(Node1 root, int target, int k) {
		// Base Case 1: If tree is empty, return -1
		if (root == null)
			return -1;

		// If target is same as root. Use the downward function
		// to print all nodes at distance k in subtree rooted with
		// target or root
		if (root.data == target) {
			printkdistanceNodeDown(root, k);
			return 0;
		}

		// Recur for left subtree
		int dl = printkdistanceNode(root.left, target, k);

		// Check if target node was found in left subtree
		if (dl != -1) {
			// If root is at distance k from target, print root
			// Note that dl is Distance of root's left child from target
			if (dl + 1 == k)
				System.out.print(root.data);

			// Else go to right subtree and print all k-dl-2 distant nodes
			// Note that the right child is 2 edges away from left child
			else
				printkdistanceNodeDown(root.right, k - dl - 2);

			// Add 1 to the distance and return value for parent calls
			return 1 + dl;
		}

		// MIRROR OF ABOVE CODE FOR RIGHT SUBTREE
		// Note that we reach here only when node was not found in left subtree
		int dr = printkdistanceNode(root.right, target, k);
		if (dr != -1) {
			if (dr + 1 == k)
				System.out.println(root.data);
			else
				printkdistanceNodeDown(root.left, k - dr - 2);
			return 1 + dr;
		}

		// If target was neither present in left nor in right subtree
		return -1;
	}
	
	public static void main(String[] args) {
		Node1 root = TreeUtil.getRoot();
		printkdistanceNode(root, 6, 1);
	}
	
	
	
	
	//Iterative Solution:
	
	public void printKDistanceNodes(Node1  root, int key, int k)
	{
		//find the given the key from root using DFS
		//so DFS stack will have key and all its parents node
		//pass this stack node and k value,
		//to printTreeBFS method tree
	}
	public void printTreeBFS(Stack<Node1> nodes, int k)
	{
		for (Node1 node : nodes) {
			
			printkdistanceNodeDown(node, k);
		}
		
	}

}
