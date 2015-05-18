package org.yasar.ds.tree.prblms;

import org.yasar.ds.tree.TreeNode;

//	http://opensourceforgeeks.blogspot.in/2014/01/sum-of-all-numbers-that-are-formed-from.html
public class SumOfBelowNodes {

	public static int treePathSum(TreeNode root, int val) {

		if (root == null) {
			return 0;
		}

		val = val * 10 + root.data;

		if (root.left == null && root.right == null) {
			return val;
		}

		return treePathSum(root.left, val) + treePathSum(root.right, val);

	}

	public static void main(String args[]) {

		System.out.println("Answer is = " + treePathSum(TreeNode.getRoot(), 0));
	}

}
