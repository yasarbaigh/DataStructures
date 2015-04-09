package org.yasar.ds.tree.cnstrct;

/**
 * 
 * 
 * http://stackoverflow.com/questions/21173541/construct-binary-search-tree-from-post-order-traversal-in-java
 * @author jyasar
 *
 */
public class BSTFromPreOrPostOrder
{
	public static void main(String[] args)
	{
		int post[] = new int[] {1, 2, 4, 9, 10, 16, 15, 12, 8 };
		NodeBT op = BSTFromPreOrPostOrder.BSTFromPostOrder(post, 0, post.length - 1);
		
		System.out.println("BT From BSTFromPostOrder, result in : PRE, IN  POST");
		op.printPreOrder(op); System.out.println();
		op.printInOrder(op); System.out.println();
		op.printPostOrder(op);
		
		
		
		int pre[] = new int[] {5, 2, 1, 3, 7, 6, 8};
		op = BSTFromPreOrPostOrder.BSTfromPreOrder(pre, 0, pre.length - 1);
		
		System.out.println("\nBT From BSTFromPreOrder, result in : PRE, IN  POST");
		op.printPreOrder(op); System.out.println();
		op.printInOrder(op); System.out.println();
		op.printPostOrder(op);		
		
	}

	public static NodeBT BSTFromPostOrder(int[] post, int start, int end)
	{
	    if (end < start)
	        return null;

	    NodeBT root = new NodeBT(post[end]);

	    if (end == start)
	        return root;

	    int i;
	    for (i = end; i >= start; i--)
	        if (post[i] < root.value)
	            break;

	    root.left = BSTFromPostOrder(post, start, i);
	    root.right = BSTFromPostOrder(post, i + 1, end - 1);

	    return root;
	}
	
	public static NodeBT BSTfromPreOrder(int[] pre, int start, int end)
	{
	    if (end < start)
	        return null;

	    NodeBT root = new NodeBT(pre[start]);

	    if (end == start)
	        return root;

	    int i;
	    for (i = start +1; i <= end; i++)
	        if (pre[i] > root.value)
	            break;

	    root.left = BSTfromPreOrder(pre, start+1, i-1);
	    root.right = BSTfromPreOrder(pre, i, end);

	    return root;
	}
}
