package org.yasar.ds.tree.cnstrct;



public class BTFromInPreOrder
{
	static int preIndex = 0;

	public static void main(String[] args)
	{
		// int in[] = new int[]{1, 2, 4, 5, 6, 7};
		// int pre[] = new int[]{5, 2, 1, 4, 7, 6};

	/*	int in[] = new int[] { 1, 2, 4, 8, 9, 10, 12, 15, 16 };
		int pre[] = new int[] { 8, 4, 2, 1, 12, 10, 9, 15, 16 };
*/
		 int in[] = new int[] {8, 10, 11, 12};
		int pre[] = new int[] { 8, 12, 10, 11 };

		
		//One Approach
		/*
		NodeBT op = new BTFromInPreOrder().create(in, pre, 0, 8);
		
		System.out.println("BT From InPreOrder");
		op.printPreOrder(op); System.out.println();
		op.printInOrder(op); System.out.println();
		op.printPostOrder(op);
		*/
		

		// Second Approach
		NodeBT op = new BTFromInPreOrder().buildTree(pre, 0, pre.length -1 , in, 0, in.length -1);

		System.out.println("BT From InPreOrder, resutl in : PRE, IN POST");
		op.printPreOrder(op);		System.out.println();
		op.printInOrder(op);		System.out.println();
		op.printPostOrder(op);

	}
	
	/**
	 * 
	 * http://edwardliwashu.blogspot.in/2013/01/construct-binary-tree-from-preorder-and.html
	 * 
	 * @param pre
	 * @param preStart
	 * @param preEnd
	 * @param in
	 * @param inStart
	 * @param inEnd
	 * @return
	 */
	public NodeBT buildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd)
	{
		if(inStart > inEnd)
		{
			return null;
		}
		
		int rootVal = pre[preStart];
		int rootIndex = 0;
		
		for(int i = inStart; i <= inEnd; i++)
		{
			if(in[i] == rootVal){
				rootIndex = i;
				break;
			}
		}
		
		int len = rootIndex - inStart;
		NodeBT root = new NodeBT(rootVal);
		root.left = buildTree(pre, preStart+1, preStart+len, in, inStart, rootIndex-1);
		root.right = buildTree(pre, preStart+len+1, preEnd, in, rootIndex+1, inEnd);
		
		return root;
	}

	
	
	public NodeBT create(int[] in, int[] pre, int inStrt, int inEnd)
	{
		if(inStrt > inEnd)
			return null;

		int i;

		// create node from preOrder
		NodeBT temp = new NodeBT(pre[preIndex]);

		// find node in inOrder
		for (i = inStrt; i <= inEnd; i++)
			if(in[i] == pre[preIndex])
				break;

		preIndex++;

		// recursively call create for the left and right
		// half of inOrder created by preOrder
		temp.left = create(in, pre, inStrt, i - 1);
		temp.right = create(in, pre, i + 1, inEnd);

		return temp;
	}	
}
