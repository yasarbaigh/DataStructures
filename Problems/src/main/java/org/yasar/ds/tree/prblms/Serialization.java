package oy.ds.tree.prblms;

import static oy.ds.tree.TreeUtil.treeInsert;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import oy.ds.tree.Node1;
import oy.ds.tree.TreeUtil;

public class Serialization
{

	public static Node1 getRoot1()
	{
		Node1 root = new Node1(8);
		treeInsert(root, 4);
		treeInsert(root, 12);

		treeInsert(root, 2);
		treeInsert(root, 6);
		treeInsert(root, 10);
		treeInsert(root, 15);

		treeInsert(root, 1);
		//treeInsert(root, 3);
		//treeInsert(root, 5);
		treeInsert(root, 7);
		//treeInsert(root, 9);
		treeInsert(root, 11);
		treeInsert(root, 14);
		//treeInsert(root, 16);
		

		return root;
	}

	static StringBuilder serializeString = new StringBuilder();

	/**
	 * serializes tree in pre-order traversal
	 * 
	 * @param root
	 */
	public static void serializeTree(Node1 root)
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
	public static Node1 deSerializeTree(String[] tokens)
	{		

		if(tokens[index].equals("#"))
		{
			index++;
			return null;
		}
		
		Node1 root = new Node1(Integer.parseInt(tokens[index++]));		
		
		root.left = deSerializeTree(tokens);		
		root.right = deSerializeTree(tokens);
		return root;
	}	

	public static void main(String[] args)
	{
		
		Node1 root = getRoot1();
		
		System.out.print("In Order  : ");
		TreeUtil.printTreeInOrder(root);		
		System.out.print("\nPre Order : ");
		TreeUtil.printTreePreOrder(root);
		
		System.out.print("\nSerialized Tree : ");
		serializeTree(root);

		System.out.println(serializeString);

		
		
		
		System.out.println("Tree after DeSerializing");		
		Node1 deSerializedRoot = deSerializeTree(serializeString.toString().split("\\s"));
		
		System.out.print("In Order  : ");
		TreeUtil.printTreeInOrder(deSerializedRoot);
		System.out.print("\nPre Order : ");
		TreeUtil.printTreePreOrder(deSerializedRoot);
		
		
		System.out.println("\nTree after Selva DeSerializing");	
		deSerializedRoot = deserializeSelva(serializeString.toString());
		
		System.out.print("In Order  : ");
		TreeUtil.printTreeInOrder(deSerializedRoot);
		System.out.print("\nPre Order : ");
		TreeUtil.printTreePreOrder(deSerializedRoot);
	}

	
	/**
	 * selva
	 * 
	 * @param str
	 * @return
	 */
	public static Node1 deserializeSelva(final String str)
	{		
		Stack<Node1> stack = new Stack<Node1>();
		Map<Node1, Integer> map = new HashMap<Node1, Integer>();

		Node1 curNode = null;

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
				Node1 node = new Node1(Integer.valueOf(vle));

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
