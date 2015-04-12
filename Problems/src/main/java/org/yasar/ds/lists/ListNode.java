package org.yasar.ds.lists;

public class ListNode
{
	int value;
	public ListNode next;
	
	public ListNode(int v)
	{
		next = null;
		value = v;
	}
	
	public  void printList()
	{
		printList(this);
	}
	
	public static void printList(ListNode node)
	{
		ListNode temp = node;
		while(temp != null)
		{
			System.out.print(temp.value + ", ");
			temp = temp.next;
		}
	}
	
	public static ListNode getList()
	{		
		return getList(10);		
	}
	
	public static ListNode getList(int index)
	{
		ListNode head = new ListNode(1);
		
		ListNode next = head;
				
		for(int i = 2 ; i<= index; i++)
		{
			next.next = new ListNode(i);
			next = next.next;
		}
		return head;
		
	}

}
