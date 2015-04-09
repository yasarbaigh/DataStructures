package oy.ds.tree.rbrt;

public class CheckTraversal
{
	public static void main(String[] args)
	{
		AdvancedTree theTree = new AdvancedTree();
		/*theTree.insert(6, 1.5);
		theTree.insert(2, 1.3);
		theTree.insert(1, 1.4);
		theTree.insert(4, 1.7);
		theTree.insert(5, 1.35);
		theTree.insert(3, 1.8);
		theTree.insert(7, 1.2);
		theTree.insert(9, 1.25);		
		theTree.insert(8, 1.6);*/
		
		theTree.insert(6, 1.6);
		theTree.insert(4, 1.4);
		theTree.insert(3, 1.3);
		//theTree.insert(5, 1.5);
		theTree.insert(8, 1.8);
		theTree.insert(7, 1.7);		
		theTree.insert(9, 1.9);				
		
		
		System.out.println("InOrderTraversal in Recursive");
		theTree.inOrderTraversal(true);
		
		System.out.println("InOrderTraversal without Recursive");
		theTree.inOrderTraversal(false);
		
		System.out.println("InOrderTraversal without Recursive/Stack, Using Morris");
		//theTree.inOrderWOStack();
		
		System.out.println("preOrderTraversal in Recursive");
		theTree.preOrderTraversal(true);
		
		System.out.println("preOrderTraversal without Recursive");
		theTree.preOrderTraversal(false);
		
		System.out.println("postOrderTraversal in Recursive");
		theTree.postOrderTraversal(true);
		
		System.out.println("postOrderTraversal without Recursive");
		theTree.postOrderTraversal(false);
		
		System.out.println("----------------------------------");
		long start = System.nanoTime();
		System.out.println("The Height of Tree Recursively "+ theTree.getHeight(true) + ". The time " + (System.nanoTime() - start));
		start = System.nanoTime();
		System.out.println("The Height of Tree Iteratively " + theTree.getHeight(false) + ". The time " + (System.nanoTime() - start));
		
		theTree.printTree(theTree.root);
	}
}
