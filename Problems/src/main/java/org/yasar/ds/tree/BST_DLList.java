package org.yasar.ds.tree;

import java.util.LinkedList;
import java.util.Queue;


/*
 Demonstrates the greatest recursive pointer problem ever --
 recursively changing an ordered binary tree into a circular
 doubly linked list.
 See http://cslibrary.stanford.edu/109/
 
 This is the simple Node1 class from which the tree and list
 are built. This does not have any methods -- it's just used
 as dumb storage by Tree_DL_List.
 The code below tries to be clear where it treats a Node1 pointer
 as a tree vs. where it is treated as a list.
 */

//http://cslibrary.stanford.edu/109/TreeListRecursion.html

//not yet understood properly



/*
 * Tree_DL_List main methods: -join() -- utility to connect two list Node1s
 * -append() -- utility to append two lists -treeToList() -- the core recursive
 * function -treeInsert() -- used to build the tree
 */
public class BST_DLList
{
	/*
	 * helper function -- given two list Node1s, join them together so the
	 * second immediately follow the first. Sets the .next of the first and the
	 * .previous of the second.
	 */
	public static void join(Node1 a, Node1 b)
	{
		a.right = b;
		b.left = a;
	}

	/*
	 * helper function -- given two circular doubly linked lists, append them
	 * and return the new list.
	 */
	public static Node1 append(Node1 a, Node1 b)
	{
		// if either is null, return the other
		if(a == null)
			return (b);
		if(b == null)
			return (a);

		// find the last Node1 in each using the .previous pointer
		Node1 aLast = a.left;
		Node1 bLast = b.left;

		// join the two together to make it connected and circular
		join(aLast, b);
		join(bLast, a);

		return (a);
	}

	/*
	 * --Recursion-- Given an ordered binary tree, recursively change it into a
	 * circular doubly linked list which is returned.
	 */
	public static Node1 treeToCircularDLList(Node1 root)
	{
		// base case: empty tree -> empty list
		if(root == null)
			return (null);

		// Recursively do the subtrees (leap of faith!)
		Node1 aList = treeToCircularDLList(root.left);
		Node1 bList = treeToCircularDLList(root.right);

		// Make the single root Node1 into a list length-1
		// in preparation for the appending
		root.left = root;
		root.right = root;

		// At this point we have three lists, and it's
		// just a matter of appending them together
		// in the right order (aList, root, bList)
		aList = append(aList, root);
		aList = append(aList, bList);

		return (aList);
	}

	
	
	/**
	 * its a DLL which returns first node of list
	 * 
	 * http://stackoverflow.com/questions/11511898/converting-a-binary-search-tree-to-doubly-linked-list
	 * 
	 * @param root
	 * @return firstNodeofDLL
	 */
	public static Node1 bstToDll(Node1 root)
	{
		if(root != null) {
			Node1 smallhead = bstToDll(root.left); // traverse down to small
			Node1 largehead = bstToDll(root.right); // traverse down to large
			Node1 temp = null;
			/*
			 * smallhead represents head of link list created in small of Node1
			 * largehead represents head of link list created in large travel to
			 * end of small link list and add the current Node1 in end
			 */
			if(smallhead != null) {
				temp = smallhead;
				while (temp.right != null) {
					temp = temp.right;
				}
				temp.right = root;
			}
			else {
				smallhead = root;
			}
			root.left = temp;
			/*
			 * set the large Node1 of current root to large head of large list
			 */
			if(largehead != null) {
				root.right = largehead;
				largehead.left = root;
			}
			else {
				largehead = root;
			}
			return smallhead;// return small head as the head of the list added
								// with current Node1
		}
		return null;
	}
	
	
	
	/**
	 * Creates a DLL as in tree structure
	 * 
	 * @param root
	 * @return
	 */
	static Node1 BSTtoDoublyLLinTreeOrder(Node1 root)
	{
		if(root == null)
			return null;
		Queue<Node1> queue = new LinkedList<Node1>();
		
		queue.add(root);
		Node1 head = root;
		Node1 prev = null, curr = null;
		
		while (!queue.isEmpty() )
		{
			//curr = queue.peek();
            curr = queue.poll();
            if(curr.left != null)
                queue.add(curr.left);
            if(curr.right != null)
                queue.add(curr.right);
            curr.right = queue.peek();
            curr.left = prev;
            prev = curr;	
		}
		return head;

    }
	
	
	// Demonstrate tree->list with the list 1..5
	public static void main(String[] args)
	{

		// first build the tree shown in the problem document
		// http://cslibrary.stanford.edu/109/
		Node1 root = TreeUtil.getRoot();
		

		System.out.println("tree:");
		TreeUtil.printTreeInOrder(root); // 1 2 3 4 5
		System.out.println();

		System.out.println("list:");
		Node1 head1;
		
		//creates a circular DLL
		//head1 = treeToCircularDLList(root);
		
		//creates a DLL
		//head1 = bstToDll(root);
		
		//creates a DLL in zig-zag order of a tree
		//4 2 6 7 5 3 1 
		head1 = BSTtoDoublyLLinTreeOrder(root);
		
		TreeUtil.printList(head1); // 1 2 3 4 5 yay!
	}
	
	
	
	
}
