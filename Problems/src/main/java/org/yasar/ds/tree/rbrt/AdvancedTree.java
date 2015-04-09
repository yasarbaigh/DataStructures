package org.yasar.ds.tree.rbrt;

import java.util.LinkedList;
import java.util.Queue;

public class AdvancedTree extends Tree
{
	/**
	 * Using Morris traversal, no Recursion & no Stack 
	 */
	public void inOrderWOStack()
	{
		Node current = root, previous;
		
		while(current != null)
		{
			if(current.leftChild == null)
			{
				System.out.println(current.iValue + ",");
				current = current.rightChild;
			}
			else
			{
				previous = current.leftChild;
				
				while(previous.rightChild != null && previous != current)
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
					System.out.println(current.iValue + ",");
					current = current.rightChild;					
				}
			}			
		}		
	}
	
	public int getHeight(boolean isRecursive)	
	{
		if(isRecursive)
		{
			return getHeightRecursively(root);
		}			
		else
		{
			return getHeightIteratively(root);
		}			
	}
	
	/**
	 * BFS
	 * 
	 * @param node
	 * @return
	 */
	public int getHeightIteratively(Node node)
	{		
		if(node == null)
		{
			return 0;
		}
		
		Queue<Node> levelQueue = new LinkedList<>();
		levelQueue.add(node);
		int height = 0;
		
		while(!levelQueue.isEmpty())
		{
			int nodeCount = levelQueue.size();			
			height++;
			
			while(nodeCount > 0)				
			{
				Node currentTop= levelQueue.poll();
				if(currentTop.leftChild != null)
					levelQueue.add(currentTop.leftChild);
				
				if(currentTop.rightChild != null)
					levelQueue.add(currentTop.rightChild);
				nodeCount--;				
			}
		}
		return height;
	}

	public int getHeightRecursively(Node node)
	{
		if(node == null)
		{
			return 0;
		}
		return 1 + Math.max(getHeightRecursively(node.leftChild), getHeightRecursively(node.rightChild));  
	}
	
	public void printTree(Node node)
	{		
		if(node == null)
		{
			return;
		}
		StringBuilder builder = new StringBuilder();
		Queue<Node> levelQueue = new LinkedList<>();
		levelQueue.add(node);
				
		while(!levelQueue.isEmpty())
		{			
			int nodeCount = levelQueue.size();
			
			while(nodeCount > 0)				
			{
				Node currentTop= levelQueue.poll();
				if(currentTop != null)
				{
					levelQueue.add(currentTop.leftChild);
					levelQueue.add(currentTop.rightChild);					
					builder.append(currentTop.iValue);			
				}	
				
				if(--nodeCount > 0)
					builder.append(",");	
			}
			
			if(!levelQueue.isEmpty())
			{
				builder.append('|');				
			}
			else
			{
				break;
			}
			
		}
		
		System.out.println(builder.toString());
		printTreeinTree(builder.toString());
	}
	
	void printTreeinTree(String tree)
	{
		String[] rows = tree.split("\\|");
		StringBuilder rowData = new StringBuilder();
		
		for(int i = 0; i< rows.length -1; i++)
		{
			String[] childs = rows[i].split(",");
			int z = rows.length - 1 -i;
						
			for(int t =0; t<z*3+2;t++)
					rowData.append("\t");
					
			for(int j=0; j<childs.length; j++)
			{
				for(int t =0; t<z*3+j-1;t++)
					rowData.append("\t");
				
				rowData.append(childs[j]+ "->");				
			}
			rowData.append("\n");
		}
		
		System.out.println(rowData.toString());
	}
}
