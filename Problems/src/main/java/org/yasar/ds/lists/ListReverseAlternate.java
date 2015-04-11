package org.yasar.ds.lists;

// http://www.geeksforgeeks.org/given-linked-list-reverse-alternate-nodes-append-end/
public class ListReverseAlternate {

	public static void main(String[] args) {

		ListNode head = ListNode.getList();

		System.out.print("Before Reverse: ");
		ListNode.printList(head);

		ListNode newHead = reverseEntireListAlternate(head);

		System.out.print("\nAfter Reverse : ");
		ListNode.printList(newHead);
		System.out.println("---------------------------");
	}

	/**
	 * 
	 * ip : 1-2-3-4-5-6-7-8-9 
	 * op : 1-3-5-7-9-8-6-4-2
	 * 
	 * @param head
	 * @return
	 */
	private static ListNode reverseEntireListAlternate(ListNode head) {

		ListNode fwdCurr = head, fwdNext = null, revCurr = null;

		while (true) {
			if (fwdCurr.next == null) {
				// next node is null
				fwdCurr.next = revCurr;
				
				break;
			} else if (fwdCurr.next.next == null) {
				// next to next node is null
				fwdCurr.next.next = revCurr;
				
				break;
			} else {
				// both next nodes are present
				fwdNext = fwdCurr.next;
				fwdCurr.next = fwdCurr.next.next;
				fwdNext.next = revCurr;
				revCurr = fwdNext;
				fwdCurr = fwdCurr.next;
			}
		}

		return head;
	}

}
