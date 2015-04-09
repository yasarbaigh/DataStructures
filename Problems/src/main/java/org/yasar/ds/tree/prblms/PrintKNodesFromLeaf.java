package oy.ds.tree.prblms;

import oy.ds.tree.Node1;

/**
 * 
 * http://www.geeksforgeeks.org/print-nodes-distance-k-leaf-node/
 * @author kingpin
 *
 */
public class PrintKNodesFromLeaf {
	
	int MAX_HEIGHT = 10000;
	
	
	/* This function prints all nodes that are distance k from a leaf node
	   path[] -. Store ancestors of a node
	   visited[] -. Stores true if a node is printed as output.  A node may be k
	                 distance away from many leaves, we want to print it once */
	void kDistantFromLeafUtil(Node1 node, int path[], boolean visited[],
	                          int pathLen, int k)
	{
	    // Base case
	    if (node==null) return;
	 
	    /* append this Node to the path array */
	    path[pathLen] = node.data;
	    visited[pathLen] = false;
	    pathLen++;
	 
	    /* it's a leaf, so print the ancestor at distance k only
	       if the ancestor is not already printed  */
	    if (node.left == null && node.right == null &&
	        pathLen-k-1 >= 0 && visited[pathLen-k-1] == false)
	    {
	        System.out.println(path[pathLen-k-1]+ ", ");
	        visited[pathLen-k-1] = true;
	        return;
	    }
	 
	    /* If not leaf node, recur for left and right subtrees */
	    kDistantFromLeafUtil(node.left, path, visited, pathLen, k);
	    kDistantFromLeafUtil(node.right, path, visited, pathLen, k);
	}
	 
	/* Given a binary tree and a nuber k, print all nodes that are k
	   distant from a leaf*/
	void printKDistantfromLeaf(Node1 node, int k)
	{
	    int[] path = new int[MAX_HEIGHT];
	    boolean visited[]= new boolean[MAX_HEIGHT];
	    kDistantFromLeafUtil(node, path, visited, 0, k);
	}
	/* 
	/* Driver program to test above functions*
	int main()
	{
	    // Let us create binary tree given in the above example
	    Node * root = newNode(1);
	    root.left = newNode(2);
	    root.right = newNode(3);
	    root.left.left = newNode(4);
	    root.left.right = newNode(5);
	    root.right.left = newNode(6);
	    root.right.right = newNode(7);
	    root.right.left.right = newNode(8);
	 
	    System.out.println("Nodes at distance 2 are: ";
	    printKDistantfromLeaf(root, 2);
	 
	    return 0;
	}
	*/

}
