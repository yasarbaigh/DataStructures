package org.yasar.ds.tree.cnstrct;

/**
 * 
 * 
 * http://www.programcreek.com/2013/01/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 
 * From the post-order array, we know that last element is the root.
 *  We can find the root in in-order array. Then we can identify the left 
 *  and right sub-trees of the root from in-order array.

	Using the length of left sub-tree, we can identify left and right sub-trees 
	in post-order array. Recursively, we can build up the tree.
 * 
 * @author jyasar
 *
 */

public class BTFromInPostOrder
{
	
	public static void main(String[] args)
	{
		
		/*

			    _______5______
		       /              \
		    ___2___            7
		   /       \          /      
		  1         4        6      
		
		 */		
		
		//int pre[] = new int[]{5, 2, 1, 4, 7, 6};
		//int in[] = new int[]{1, 2, 4, 5, 6, 7};
		//int post[] = new int[]{1, 4, 2, 6, 7, 5};
		
		
		
		/*
			    _______8______
		       /              \
		    ___4            ___12__
		   /               /       \
		   2              10       15
		  /               /			\ 
		  1         	 9			 16
		  */
		//int pre[] = new int[] { 8, 4, 2, 1, 12, 10, 9, 15, 16 };
		//int in[] = new int[] { 1, 2, 4, 8, 9, 10, 12, 15, 16 };
		//int post[] = new int[] {1, 2, 4, 9, 10, 16, 15, 12, 8 };

		
	
		/*
			    	   8______
		               		  \
		                	___12
		                  /       
		                 10       
		                   \			 
		           	 	   11		 
		  */
		//int pre[] = new int[] { 8, 12, 10, 11 };		
		int in[] = new int[] {8, 10, 11, 12};
		int post[] = new int[] { 11, 10, 12, 8 };

		NodeBT op = new BTFromInPostOrder().buildTree(in, post);
		
		System.out.println("BT From InPostOrder, result in : PRE, IN  POST");
		op.printPreOrder(op); System.out.println();
		op.printInOrder(op); System.out.println();
		op.printPostOrder(op);
	}
	
	
	
	/**
	 * 
	 * http://edwardliwashu.blogspot.in/2013/01/construct-binary-tree-from-inorder-and.html
	 * 
	 * 
	 * @param inorder
	 * @param postorder
	 * @return
	 */
	public NodeBT buildTree(int[] inorder, int[] postorder) 
	{
        int inStart = 0;
        int inEnd = inorder.length-1;
        int postStart =0;
        int postEnd = postorder.length-1;
 
        return buildTree(inorder, inStart, inEnd, postorder, postStart, postEnd);
    }
 
	/**
	 * 
	 * http://edwardliwashu.blogspot.in/2013/01/construct-binary-tree-from-inorder-and.html
	 * 
	 * @param inorder
	 * @param inStart
	 * @param inEnd
	 * @param postorder
	 * @param postStart
	 * @param postEnd
	 * @return
	 */
    public NodeBT buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd)
    {
        if(inStart > inEnd)
            return null;
 
        int rootValue = postorder[postEnd];
        int rootIndex=0;
        
        
        for(int i=inStart; i<= inEnd; i++){
            if(inorder[i]==rootValue){
                rootIndex = i;
                break;
            }
        }
        
        int len = rootIndex - inStart;
        NodeBT root = new NodeBT(rootValue);
 
        root.left = buildTree(inorder, inStart, rootIndex-1, postorder, postStart, postStart+ len-1);
        // Becuase k is not the length, it it need to -(inStart+1) to get the length
        root.right = buildTree(inorder, rootIndex+1, inEnd, postorder, postStart+len, postEnd-1);
        // postStart+k-inStart = postStart+k-(inStart+1) +1
 
        return root;
    }

}
