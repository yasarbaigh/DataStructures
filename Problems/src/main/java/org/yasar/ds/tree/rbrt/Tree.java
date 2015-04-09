package org.yasar.ds.tree.rbrt;

import java.util.Stack;

public class Tree
{
	Node root; // the only data field in Tree
	String[] treeValues = {"","","","","","","","","",""};

	public Node find(final int key)
	{
		Node current = root;

		while (current.iValue != key)
		{
			if (current.iValue < key)
			{
				current = current.rightChild;
			} else
			{
				current = current.leftChild;
			}

			if (current == null)
			{
				return null;
			}
		}

		// less optimized, since above code, does not even enter into while loop
		/*
		 * while(current != null) { if(current.iValue == key) { return current;
		 * } else if(current.iValue < key) { current = current.rightChild; }
		 * else { current = current.leftChild; } }
		 */
		return current;
	}

	public void insert(final int id, final double dd)
	{
		final Node tempNode = new Node();
		tempNode.iValue = id;
		tempNode.dValue = dd;

		if (root == null)
		{
			root = tempNode;
		} else
		{
			Node current = root;
			Node parent;
			while (true)
			{
				parent = current;
				if (current.iValue < id)
				{
					current = current.rightChild;
					if (current == null)
					{
						parent.rightChild = tempNode;
						return;
					}
				} else
				{
					current = current.leftChild;
					if (current == null)
					{
						parent.leftChild = tempNode;
						return;
					}
				}
			}
		}
	}

	public void delete(final int id)
	{
		Node current = root;
		Node parent = current;
		boolean isLeftChild = false;
		while (current.iValue != id)
		{
			parent = current;
			if (current.iValue < id)
			{
				current = current.rightChild;
				isLeftChild = false;
			} else if (current.iValue > id)
			{
				current = current.leftChild;
				isLeftChild = true;
			}
			if (current == null)
			{
				System.out.println("Key not available");
				return;
			}
		}
		//keynode which is a leaf node/top-root node.
		if(current == root || (current.leftChild == null && current.rightChild == null))
		{
			if (current == root)
			{
				root = null;
			}
			else if (isLeftChild)
			{
				parent.leftChild = null;
			} 
			else
			{
				parent.rightChild = null;
			}
			
		}
		//keynode with a single child
		else if (current.leftChild == null)
		{
			if (current == root)
			{
				root = current.leftChild;
			}
			else if (isLeftChild)
			{
				parent.leftChild = current.rightChild;
			} 
			else
			{
				parent.rightChild = current.rightChild;
			}
		}
		else if (current.rightChild == null)
		{
			if (current == root)
			{
				root = current.leftChild;
			}
			else if (isLeftChild)
			{
				parent.leftChild = current.leftChild;
			} 
			else
			{
				parent.rightChild = current.leftChild;
			}
			System.out.println("Tree.delete()");
		}
		//key node with 2 childs		
		else
		{
			Node successor = current.rightChild;
			if(successor.leftChild != null)
			{
				final Node minNode = getMinNode(successor);
				final Node tempNode = minNode.clone();
				delete(minNode.iValue);
				
				tempNode.rightChild = successor;
				tempNode.leftChild = current.leftChild;
				successor = tempNode;
			}
			
			if (isLeftChild)
			{
				parent.leftChild = successor;
			} 
			else
			{
				parent.rightChild = successor;
			}						
		}
	}

	public void inOrderTraversal(final boolean isRecursive)
	{
		/*
		 * 1. Call itself to traverse the node’s left subtree. 
		 * 2. Visit the node. 
		 * 3. Call itself to traverse the node’s right subtree.
		 */
		if (isRecursive)
		{
			inOrderRecursive(root);
		} else
		{
			inOrderWithouRecursive(root);
		}
		System.out.println();
	}

	private void inOrderWithouRecursive(final Node node)
	{
		Node current = node;		 
		Stack<Node> stack = new Stack<Node>();
		while(!stack.isEmpty() || current != null)
		{			
			if(current != null)
			{				
				stack.push(current);
				current = current.leftChild;
			}
			else
			{
				current = stack.pop();
				System.out.print(current.iValue + ",");
				current = current.rightChild;
			}			
		}
	}

	private void inOrderRecursive(final Node node)
	{		
		if (node != null)
		{
			inOrderRecursive(node.leftChild);
			System.out.print(node.iValue + ",");
			inOrderRecursive(node.rightChild);
		}		
	}

	public void preOrderTraversal(final boolean isRecursive)
	{
		/*
		 * 1. Visit the node.
		 * 2. Call itself to traverse the node’s left subtree.
		 * 3. Call itself to traverse the node’s right subtree.
		 */
		if (isRecursive)
		{
			preOrderRecursive(root);
		}
		else
		{
			preOrderWithouRecursive(root);
		}
		System.out.println();
	}

	private void preOrderWithouRecursive(final Node node)
	{
		Node current = node;		 
		Stack<Node> stack = new Stack<Node>();
		while(!stack.isEmpty() || current != null)
		{			
			if(current != null)
			{				
				stack.push(current);
				System.out.print(current.iValue + ",");
				current = current.leftChild;
			}
			else
			{
				current = stack.pop();				
				current = current.rightChild;
			}			
		}

	}

	private void preOrderRecursive(final Node node)
	{
		if (node != null)
		{
			System.out.print(node.iValue + ",");
			preOrderRecursive(node.leftChild);
			preOrderRecursive(node.rightChild);
		}		
	}

	public void postOrderTraversal(final boolean isRecursive)
	{
		/*
		 * 1. Call itself to traverse the node’s left subtree.
		 * 2. Call itself to traverse the node’s right subtree.
		 * 3. Visit the node.
		 */
		if (isRecursive)
		{
			postOrderRecursive(root);
		}
		else
		{
			postOrderWithouRecursive(root);
		}
		System.out.println();
	}

	private void postOrderWithouRecursive(final Node node)
	{
		Node current = node;
		Node prevNode = null;
		Stack<Node> stack = new Stack<>();
		stack.push(current);
		while(!stack.isEmpty())
		{
			current = stack.peek();
			if(prevNode == null || prevNode.leftChild == current || prevNode.rightChild == current)
			{
				if(current.leftChild !=null )
				{
					stack.push(current.leftChild);
				}
				else if(current.rightChild !=null )
				{
					stack.push(current.rightChild);
				}				
			}
			else if(current.leftChild == prevNode)
			{
				if(current.rightChild !=null )
				{
					stack.push(current.rightChild);
				}
			}
			else
			{				
				System.out.print(current.iValue + ",");
				stack.pop();				
			}
			prevNode = current;
		}
	}

	private void postOrderRecursive(final Node node)
	{
		if (node != null)
		{			
			postOrderRecursive(node.leftChild);
			postOrderRecursive(node.rightChild);
			System.out.print(node.iValue + ",");
		}		
	}

	public Node getMinNode(final Node node)
	{
		Node current = node == null? root: node;
		while (current.leftChild != null)
		{
			current = current.leftChild;
		}
		return current;
	}

	public Node getMaxmNode(final Node node)
	{
		Node current = node == null? root: node;
		while (current.rightChild != null)
		{
			current = current.rightChild;
		}
		return current;
	}
	
	public void displayTree()
	{		
		generateViewTree(root, 0);
		for (int i = 0; i < treeValues.length; i++)
		{
			if(!treeValues[i].equals(""))
			{
				System.out.println(treeValues[i]);
				treeValues[i] = "";				
			}			
		}
	}

	private void generateViewTree(Node node, int depth)
	{	
		if(node!= null)
		{				
			treeValues[depth] += node.iValue + ",";
			depth++;
			for(int i=0; i<depth; i++)
				System.out.print("\t" );
			
			System.out.println(node.iValue);
			generateViewTree(node.leftChild, depth);
			generateViewTree(node.rightChild, depth);
		}
		else
		{
			treeValues[depth] += "-,";
		}		
	}
	
	
}