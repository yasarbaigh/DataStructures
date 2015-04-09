package org.yasar.ds.tree.prblms;

import org.yasar.ds.tree.Node1;


/**
 * 
 * http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
 * 
 * @author jyasar
 * 
 *         Lowest Common Ancestor
 */
public class LCA
{

	/*
	 * http://opensourceforgeeks.blogspot.in/2014/02/lowest-common-ancestor-in-
	 * binary-search.html
	 */
	public static Node1 findLCABST(Node1 root, int n1, int n2)
	{
		if(root == null)
		{
			return null;
		}

		int data = root.data;
		if(data > n1 && data > n2)
		{
			return findLCABST(root.left, n1, n2);
		}

		if(data < n1 && data < n2)
		{
			return findLCABST(root.right, n1, n2);
		}
		return root;
	}
	
	/*
	 * http://opensourceforgeeks.blogspot.in/2014/02/lowest-common-ancestor-in-
	 * binary-search.html
	 */
	public static Node1 findLCAIterativeBST(Node1 root, int n1, int n2)
	{
		if(root == null)
		{
			return null;
		}

		while(root != null)
		{
			int data = root.data;
			if(data > n1 && data > n2)
			{
				root = root.left;
			}

			if(data < n1 && data < n2)
			{
				root = root.right;
			}
		}		
		return root;
	}

	public static void main(String args[])
	{
		
		Node1 root = new Node1(3);
		root.left = new Node1(5);
		root.right = new Node1(1);
		
		root.left.left = new Node1(6);
		root.left.right = new Node1(2);
		root.right.left = new Node1(0);
		root.right.right = new Node1(8);
		
		root.left.right.left = new Node1(7);
		root.left.right.right = new Node1(4);
		
		Node1 ances = LCABT(root, 6, 2);
		System.out.println(ances.data);
	}
	
	/*

	    _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
         */
	public static Node1 LCABT(Node1 root, int a, int b)
	{
		Node1 left = null, right = null;

		if(root == null)
		{
			return null;
		}

		// If the root is one of a or b, then it is the LCA
		if(root.data == a || root.data == b)
		{
			return root;
		}

		left = LCABT(root.left, a, b);
		right = LCABT(root.right, a, b);

		// If both nodes lie in left or right then their LCA is in left or
		// right,
		// Otherwise root is their LCA
		if(left != null && right != null)
		{
			return root;
		}

		return (left != null) ? left : right;
	}
	
}
