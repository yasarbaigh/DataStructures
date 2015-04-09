package oy.ds.tree.rbrt;

public class CheckMorris
{
	/*
	 1. Initialize current as root 
2. While current is not NULL
   If current does not have left child
      a) Print current’s data
      b) Go to the right, i.e., current = current->right
   Else
      a) Make current as right child of the rightmost node in current's left subtree
      b) Go to this left child, i.e., current = current->left
      
      http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
	 */
	public static void main(String[] args)
	{
		Tree theTree = new Tree();
/*		theTree.insert(6, 1.6);
		theTree.insert(4, 1.4);
		theTree.insert(3, 1.3);
		theTree.insert(8, 1.8);
		theTree.insert(7, 1.7);
		theTree.insert(9, 1.9);				
		theTree.insert(5, 1.5);		
*/		
		
		theTree.insert(4, 1.4);
		theTree.insert(3, 1.3);
		theTree.insert(5, 1.5);
		theTree.insert(9, 1.9);
		theTree.insert(8, 1.8);
		theTree.insert(7, 1.7);						
		theTree.insert(6, 1.6);
		
		
				

		inOrderRecursive(theTree.root);
		System.out.println("\nInOrder WO Recursive/stack");
		inOrderMorrisTraversal(theTree.root);
	}

	static void inOrderRecursive(Node node)
	{		
		if(node != null)
		{
			inOrderRecursive(node.leftChild);
			System.out.print(node.iValue + ",");
			inOrderRecursive(node.rightChild);
		}
	}

	static void inOrderMorrisTraversal(Node root)
	{
		Node current = root, previous;
		
		while (current != null)
		{
			if(current.leftChild == null)
			{
				System.out.print(current.iValue + ",");
				current = current.rightChild;
			}
			else
			{
				previous = current.leftChild;

				while (previous.rightChild != null && previous.rightChild != current)
				{
					previous = previous.rightChild;
				}

				if(previous.rightChild == null)
				{
					previous.rightChild = current;
					current = current.leftChild;
				}
				else
				{
					previous.rightChild = null;
					System.out.print(current.iValue + ",");
					current = current.rightChild;
				}
			}
		}
	}
}
