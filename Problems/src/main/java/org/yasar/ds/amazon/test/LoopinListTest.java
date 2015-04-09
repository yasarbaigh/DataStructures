package oy.ds.amazon.test;

import org.junit.Test;

import oy.ds.amazon.LoopInList;
import oy.ds.amazon.LoopInList.Node;

public class LoopinListTest
{
	@Test
	public void main()
	{
		LoopInList<Integer> list = new LoopInList<Integer>();
		/*
		 * // Creating a random list list.addLast(6); list.addLast(3);
		 * list.addLast(1); list.addLast(8); list.addLast(7); list.addLast(4);
		 * list.addLast(2); list.addLast(1);
		 * 
		 * // Did we create list as we expected? list.printList(); // Now create
		 * a loop list.connectFromLast(8); // Test if loop existed
		 * System.out.println("Whether Loop existed " + list.ifLoopExists());
		 */

		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		/*
		 * list.addLast(5); list.addLast(6); list.addLast(7); list.addLast(3);
		 */
		// Did we create list as we expected?
		list.printList();
		// Now create a loop
		list.connectFromLast(1);

		// Test if loop existed
		System.out.println("Whether Loop existed " + list.ifLoopExists());

	}
	
	@Test
	public void countNodesinCircularList()
	{
		//you can insert node in hash-set, before insert check for contains method, if returns true,
		///this is chaining point, return counter at that point
		
		//if no DS should be used means, have to research.
	}

}
