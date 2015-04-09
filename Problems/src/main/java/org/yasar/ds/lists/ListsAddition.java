package org.yasar.ds.lists;

import java.util.List;
import java.util.Stack;

/**
 *  Given 2 linked lists representing 2 numbers, add them and return the result as another list
 * 
 * http://stackoverflow.com/questions/7294048/add-two-big-numbers-represented-as-linked-lists-without-reversing-the-linked-liss
 * @author jyasar
 *
 */
public class ListsAddition
{
	List<Integer> list1, list2;
	ListsAddition(List<Integer> l1, List<Integer> l2)
	{
		list1 = l1;
		list2 = l2;
	}
	
	public List<Integer> addLists()
	{
		Stack<Integer> addedList = new Stack<>();
		List<Integer> number1 = list1.size() >= list2.size()? list1: list2;
		List<Integer> number2 = list1.size() < list2.size()? list1: list2;
		
		
		int num = number2.size();
		int countNum1 = number1.size() -1;
		int countNum2 = number2.size() -1;
		int carry = 0;
		for(int i=0; i<num; i++)
		{
			int value = number1.get(countNum1 -i) + number2.get(countNum2 -i) + carry;
			addedList.push(value%10);
			carry = value/10;
		}
		
		
		return addedList;
	}

}
