package org.yasar.ds.tree;

/**
 * print post order traversal from given inorder and preorder values
 * 
 * @author Kingpin
 * 
 */
public class PostOrder
{
	/**
	 * print post order traversal from given inorder and preorder values
	 * 
	 * @author Kingpin
	 * 
	 */
	private int[] mapIndexs;

	private int index =0;
	public void getPostOrder(int[] inOrder, int[] preOrder)
	{
		performPostOrderRetrieval(inOrder, 0, preOrder.length-1, preOrder, 0);
	}

	private int getIndex(int[] inOrder, int start, int end, int value)
	{
		for (int i = 0; i < end; i++)
		{
			if(inOrder[i] == value)
				return i;
		}
		return -1;
	}

	private void performPostOrderRetrieval(int[] inOrder, int start, int end, int[] preOrder, int index)
	{
		if( start > end )
			return ;
		int root = getIndex(inOrder, start, end, preOrder[index]);
		index++;

		// If left subtree is not empty, print left subtree
		if(root !=0)
			performPostOrderRetrieval(inOrder,start, root-1, preOrder, index);

		// If right subtree is not empty, print right subtree
		//if(root != end )
			//performPostOrderRetrieval(inOrder, root +1, end, preOrder, index);

		// Print root
		System.out.println(inOrder[root] + " ");

	}

	public static void main(String[] args)
	{
		//int[] in = { 8, 4, 10, 9, 11, 2, 5, 1, 6, 3, 7 };
		//int[] pre = { 1, 2, 4, 8, 9, 10, 11, 5, 3, 6, 7 };
		
		int[] in = { 4, 2, 5, 1, 3, 6};
		int[] pre = { 1, 2, 4, 5, 3, 6 };
		int [] post = {4, 5, 2, 6, 3, 1};
		
		//int[] in = { 1,2,3};
		//int[] pre = { 2,1,3 };
		new PostOrder().getPostOrder(in, pre);
	}
}
