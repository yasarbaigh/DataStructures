package org.yasar.ds.lists;

// http://www.geeksforgeeks.org/write-a-function-to-reverse-the-nodes-of-a-linked-list/
public class ListReverse {

	public static void main(String[] args) {

		ListNode head = ListNode.getList();

		System.out.print("Before Reverse: ");
		ListNode.printList(head);

		ListNode newHead = reverseEntireList(head);

		System.out.print("\nAfter Reverse : ");
		ListNode.printList(newHead);
		System.out.println("\n---------------------------");
		
		
		head = ListNode.getList();

		System.out.print("Before Reverse: ");
		ListNode.printList(head);

		newHead = reverseListRecursive(head);

		System.out.print("\nAfter Reverse : ");
		ListNode.printList(newHead);
		System.out.println("\n---------------------------");
	}

	public static ListNode reverseEntireList(ListNode head) {

		ListNode prev = null;
		ListNode current = head;
		ListNode next = null;

		while (current != null) {

			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}

	public static ListNode reverseListRecursive(ListNode head) {

		ListNode first = null;
		ListNode rest = null;

		if (head == null)
			return null;

		first = head;
		rest = first.next;

		if (rest == null) {
			return first;
		}

		ListNode start = reverseListRecursive(rest);
		first.next.next = first;
		first.next = null;

		head = start;

		return head;

	}

}
