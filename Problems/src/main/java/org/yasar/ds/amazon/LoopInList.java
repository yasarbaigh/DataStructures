package org.yasar.ds.amazon;

/**
 * http://coderevisited.com/how-to-detect-if-a-linked-list-has-a-loop/
 * 
 * @author jyasar
 * 
 * @param <T>
 */
public class LoopInList<T>
{

	private Node head;

	public class Node
	{
		private T item;
		private Node next;

		public Node(T item, Node next)
		{
			this.item = item;
			this.next = next;
		}
		
		@Override
		public String toString()
		{
			return this.item.toString();			
		}
	}

	public void addLast(T item)
	{
		if(item == null) {
			throw new NullPointerException("Item can't be null");
		}
		Node n = new Node(item, null);
		if(head == null) {
			head = n;
		}
		else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;

			temp.next = n;
		}
	}

	public void connectFromLast(T item)
	{
		Node n = seachForItem(item);
		if(n != null) {
			Node temp = n;
			while (temp.next != null)
				temp = temp.next;

			temp.next = n;
		}
		else {
			System.out.println("Item :" + item + "not found");
		}
	}

	private Node seachForItem(T item)
	{
		Node temp = head;
		while (temp != null) {
			if(temp.item.equals(item)) {
				return temp;
			}
			temp = temp.next;
		}
		return null;
	}

	public void printList()
	{
		Node temp = head;
		while (temp != null) {
			System.out.format("%d ", temp.item);
			temp = temp.next;
		}
		System.out.println();
	}

	public boolean ifLoopExists()
	{
		Node fastPtr = head;
		Node slowPtr = head;
		int count = 1;		
		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			
			System.out.print(fastPtr.item.toString());
			System.out.print(slowPtr.item.toString());
			System.out.println("Count " + count);
			count++;
			if(slowPtr == fastPtr)
				return true;

		}
		return false;
	}

	/**
	 * 
	 * Brent Cycle Detection Algorithm
	 * 
	 * @return
	 */
	public boolean ifLoopExistsBrents()
	{

		Node movingPtr = head;
		Node stationaryPtr = head;
		int stepsTaken = 0;
		int stepLimit = 2;
		while (movingPtr != null) {
			movingPtr = movingPtr.next;
			stepsTaken++;
			if(movingPtr == stationaryPtr)
				return true;
			if(stepsTaken == stepLimit) {
				stepLimit = 2 * stepLimit;
				stepsTaken = 0;
				stationaryPtr = movingPtr;
			}
		}
		return false;
	}

	public int FindLoopLength()
	{
		Node fastPtr = head;
		Node slowPtr = head;
		boolean loopExists = false;
		while (!loopExists && fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if(slowPtr == fastPtr)
				loopExists = true;
		}

		int length = 0;
		if(loopExists) {
			do {
				slowPtr = slowPtr.next;
				length++;
			}while (slowPtr != fastPtr);
		}
		return length;
	}

	private Node startNodeOfLoop()
	{
		Node fastPtr = head;
		Node slowPtr = head;
		boolean loopExists = false;
		while (!loopExists && fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if(slowPtr == fastPtr)
				loopExists = true;
		}

		if(loopExists) {
			slowPtr = head;
			while (slowPtr != fastPtr) {
				slowPtr = slowPtr.next;
				fastPtr = fastPtr.next;
			}
			return fastPtr;
		}
		else
			return null;
	}

}
