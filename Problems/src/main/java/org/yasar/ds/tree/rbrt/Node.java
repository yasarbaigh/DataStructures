package oy.ds.tree.rbrt;

public class Node {
	int iValue;
	double dValue;
	Node leftChild, rightChild;

	protected Node clone() {
		Node tempNode = new Node();
		tempNode.iValue = iValue;
		tempNode.dValue = dValue;
		return tempNode;
	}
}
