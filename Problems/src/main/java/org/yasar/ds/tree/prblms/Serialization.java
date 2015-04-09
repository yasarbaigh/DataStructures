package org.yasar.ds.tree.prblms;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.yasar.ds.tree.TreeNode;
import org.yasar.ds.tree.TreeNode;

public class Serialization
{

	

	static StringBuilder serializeString = new StringBuilder();

	/**
	 * serializes tree in pre-order traversal
	 * 
	 * @param root
	 */
	public static void serializeTree(TreeNode root)
	{
		if(root == null) {
			serializeString.append("# ");
			return;
		}

		serializeString.append(root.data + " ");
		serializeTree(root.left);
		serializeTree(root.right);
	}

	
	static int index = 0;
	/**
	 * deserializes string
	 * 
	 * @param root
	 */
	public static TreeNode deSerializeTree(String[] tokens)
	{		

		if(tokens[index].equals("#"))
		{
			index++;
			return null;
		}
		
		TreeNode root = new TreeNode(Integer.parseInt(tokens[index++]));		
		
		root.left = deSerializeTree(tokens);		
		root.right = deSerializeTree(tokens);
		return root;
	}	

	public static void main(String[] args)
	{
		
		TreeNode root = TreeNode.getRoot1();
		
		System.out.print("In Order  : ");
		TreeNode.printTreeInOrder(root);		
		System.out.print("\nPre Order : ");
		TreeNode.printTreePreOrder(root);
		
		System.out.print("\nSerialized Tree : ");
		serializeTree(root);

		System.out.println(serializeString);

		
		
		
		System.out.println("Tree after DeSerializing");		
		TreeNode deSerializedRoot = deSerializeTree(serializeString.toString().split("\\s"));
		
		System.out.print("In Order  : ");
		TreeNode.printTreeInOrder(deSerializedRoot);
		System.out.print("\nPre Order : ");
		TreeNode.printTreePreOrder(deSerializedRoot);
		
		
		System.out.println("\nTree after Selva DeSerializing");	
		deSerializedRoot = deserializeSelva(serializeString.toString());
		
		System.out.print("In Order  : ");
		TreeNode.printTreeInOrder(deSerializedRoot);
		System.out.print("\nPre Order : ");
		TreeNode.printTreePreOrder(deSerializedRoot);
	}

	
	/**
	 * selva
	 * 
	 * @param str
	 * @return
	 */
	public static TreeNode deserializeSelva(final String str)
	{		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();

		TreeNode curNode = null;

		for (final String vle : str.split(" ")) 
		{

			if(vle.equalsIgnoreCase("#")) 
			{
				if(!stack.isEmpty()) 
				{
					if(map.containsKey(stack.peek())) 
					{
						curNode = stack.pop();
					}
					else
					{
						map.put(stack.peek(), 1);
					}
				}
			}
			else 
			{
				TreeNode node = new TreeNode(Integer.valueOf(vle));

				if(!stack.isEmpty() && !map.containsKey(stack.peek()))
				{
					stack.peek().left = node;
					map.put(stack.peek(), 1);
				}
				else if(!stack.isEmpty() && map.containsKey(stack.peek())) 
				{
					if(map.get(stack.peek()) == 2) 
					{
						map.remove(stack.peek());
						curNode = stack.pop();
					}
					stack.peek().right = node;
					map.put(stack.peek(), 2);
				}

				stack.push(node);
			}
		}
		while (!stack.isEmpty()) 
		{
			curNode = stack.pop();
		}
		return curNode;
	}
}
