package org.yasar.ds.stack;

import java.util.Stack;

/**
 * 
 * Find max and min element in a stack at O(1)
 * 
 * @author jyasar
 *
 *
 *http://stackoverflow.com/questions/7134129/stack-with-find-min-find-max-more-efficient-than-on
 */

public class StackWithMaxMin extends Stack<Integer>
{
	
	private Stack<Integer> minStack, maxStack;
	
	public int getMin()
	{
		return minStack.peek();
	}
	
	public int getMax()
	{
		return maxStack.peek();
	}
	
	public void push(int value)
	{
		super.push(value);
		
		if(value < getMin())
		{
			minStack.push(value);
		}
		
		if(value > getMax())
		{
			maxStack.push(value);
		}		
	}
	
	public Integer pop()
	{		
		Integer value = super.pop();
		if(value == getMin())
		{
			minStack.pop();
		}
		
		if(value == getMax())
		{
			maxStack.pop();
		}	
		return value;
	}
}
