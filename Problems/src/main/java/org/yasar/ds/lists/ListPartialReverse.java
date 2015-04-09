package oy.ds.lists;

/**
 * http://edwardliwashu.blogspot.in/2013/02/reverse-nodes-in-k-group.html
 * 
 * @author jyasar
 * 
 */
public class ListPartialReverse
{
	public static void main(String[] args)
	{
		ListNode head = reverseBetween(ListNode.getList(), 3, 8);
		head.printList(head);
		
	}

	/**
	 * Current pointer will be ahead than count,
	 * lastone pointer will pnt to a node before m.
	 * 
	 * in last if doing lastone adjustment.
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public static ListNode reverseBetween(ListNode head, int m, int n)
	{

		int count = 1;
		
		ListNode previousNode = head;
		ListNode currentNode = head.next;
		ListNode nextNode = null;
		ListNode lastOne = null;

		while (true)
		{
			if(count < m)
			{
				lastOne = previousNode;
				previousNode = currentNode;
				currentNode = currentNode.next;
			}
			else if(count >= m && count < n)
			{
				nextNode = currentNode.next;
				currentNode.next = previousNode;
				previousNode = currentNode;
				currentNode = nextNode;
			}
			else if(count >= n)
			{
				lastOne.next.next = currentNode;
				lastOne.next = previousNode;
				break;
			}
			count++;
		}
		return head;
	}

}
