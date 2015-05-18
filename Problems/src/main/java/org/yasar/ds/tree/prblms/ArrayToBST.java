package org.yasar.ds.tree.prblms;

import java.util.Arrays;

import org.yasar.ds.tree.TreeNode;

//	http://opensourceforgeeks.blogspot.in/2014/01/converting-array-to-balanced-bstbinary.html

public class ArrayToBST {
	
	public static TreeNode convert(int[] ar, int start, int end){
		 
        if(start > end)
            return null;
 
        int mid = start + ((end - start)/2);
        TreeNode root = new TreeNode(ar[mid]);
        root.setLeft(convert(ar,start,mid-1));
        root.setRight(convert(ar,mid+1,end));
 
        return root;
 
    }
 
    public static void main(String args[]){
 
        int array[] = new int[]{1,2,3,4,5,6,7,8};
        System.out.println("Array is : " + Arrays.toString(array));
 
 
        System.out.println("BST in pre order : ");
        TreeNode res = ArrayToBST.convert(array,0,array.length-1);
        TreeNode.printTreeInOrder(res);
 
    }
 


}
