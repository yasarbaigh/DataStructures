package oy.ds.lists;

public class ListNode
{
	int value;
	ListNode next;
	
	public ListNode(int v)
	{
		next = null;
		value = v;
	}
	
	
	public void printList(ListNode  node)
	{
		while(node != null)
		{
			System.out.print(node.value + ", ");
			node = node.next;
		}
	}
	
	public static ListNode getList()
	{
		ListNode head = new ListNode(1);
		ListNode next = head;
		
		for(int i = 2 ; i< 10; i++)
		{
			next.next = new ListNode(i);
			next = next.next;
		}
		return head;
		
	}

}
