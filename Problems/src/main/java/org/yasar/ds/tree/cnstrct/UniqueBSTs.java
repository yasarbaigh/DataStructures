package org.yasar.ds.tree.cnstrct;

import java.util.ArrayList;

/**
 * http://edwardliwashu.blogspot.in/2013/01/unique-binary-search-tree-ii.html
 * 
 * 
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

Unique BSTii
 * 
 * @author jyasar
 *
 */
public class UniqueBSTs
{
	public ArrayList<NodeBT> generateTrees(int n)
	{
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<NodeBT> result = new ArrayList<NodeBT>();
		if(n == 0)
		{
			NodeBT root = null;
			result.add(root);
			return result;
		}
		result = generateTrees(1, n);
		return result;
	}

	public ArrayList<NodeBT> generateTrees(int start, int end)
	{
		ArrayList<NodeBT> result = new ArrayList<NodeBT>();
		if(start > end)
		{
			NodeBT root = null;
			result.add(root);
			return result;
		}
		for (int i = start; i <= end; i++)
		{
			ArrayList<NodeBT> leftList = generateTrees(start, i - 1);
			ArrayList<NodeBT> rightList = generateTrees(i + 1, end);
			for (int j = 0; j < leftList.size(); j++)
			{
				for (int k = 0; k < rightList.size(); k++)
				{
					NodeBT root = new NodeBT(i);
					root.left = leftList.get(j);
					root.right = rightList.get(k);
					result.add(root);
				}
			}
		}
		return result;
	}

}
