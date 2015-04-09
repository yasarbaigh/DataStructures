package org.yasar.ds.tree.cnstrct;

public class NodeBT
{
	NodeBT left;

	NodeBT right;

	int value;

	public NodeBT(int value)
	{
		this.value = value;
	}

	public void printInOrder(NodeBT node)
	{
		if(node == null)
		{
			return;
		}
		printInOrder(node.left);
		System.out.print(node.value + ", ");
		printInOrder(node.right);
	}

	public void printPreOrder(NodeBT node)
	{
		if(node == null)
		{
			return;
		}
		System.out.print(node.value + ", ");
		printPreOrder(node.left);
		printPreOrder(node.right);
	}

	public void printPostOrder(NodeBT node)
	{
		if(node == null)
		{
			return;
		}
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(node.value + ", ");
	}
	
	
	
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
     _______8_______
    /               \
 ___4             ___12__
/               /       \
2              10       15
/              /		  \ 
1         	  9			   16
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
//int in[] = new int[] {8, 10, 11, 12};
//int post[] = new int[] { 11, 10, 12, 8 };
	
	
	/*
	      _______5_______
	    /                \
	 ___2___          ___7__
	/       \        /       \
	1        3      6         8
	

	*/
	
	//int pre[] = new int[] {5, 2, 1, 3, 7, 6, 8}; 
	//int in[] = new int[] {1, 2, 3, 5, 6, 7, 8}; 
	//int post[] = new int[] {1, 3, 2, 6, 8, 7, 5}; 
	
	
	
	
	
	
	
	
	
	
	
}