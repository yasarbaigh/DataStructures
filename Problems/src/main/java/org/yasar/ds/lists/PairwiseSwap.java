package org.yasar.ds.lists;

// http://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list-by-changing-links/
public class PairwiseSwap {

	public static void main(String[] args) {

		ListNode head = ListNode.getList(4);

		System.out.print("Before SWap: ");
		ListNode.printList(head);

		ListNode newHead = swapPairWise(head);

		System.out.print("\nAfter SWap : ");
		ListNode.printList(newHead);
		System.out.println("\n---------------------------");
	}

	
	public static ListNode swapPairWise(ListNode head) {

		// 	sample ip : 1-2-3-4-5-6-7-8-9
		if (head == null || head.next == null) {

			return head;
		}

		ListNode curr, currNext, currPrev = null;

		//	curr = 1, currNext = 2
		curr = head;
		currNext = head.next;

		//	temp = 3/null, returnHead = 2;
		ListNode temp = currNext.next, returnHead = currNext;
		
		// swap 2.1
		currNext.next = curr;
		
		// swap 1.2
		curr.next = temp;
		
		//	currPrev = 1, curr = 3/null
		currPrev = curr;
		curr = temp;
				
		while (curr != null && curr.next != null) {

			// currNext = 4
			currNext = curr.next;
			
			// 1->4
			currPrev.next = currNext;
			
			// temp = 5/null //reserving next pair
			temp = currNext.next;
			
			// 4.3
			currNext.next = curr;
			
			// 3.5/null
			curr.next = temp;

			currPrev = curr;
			curr = temp;			
		}
		
		return returnHead;
	}

	
	static ListNode pairWiseSwapRecur(ListNode head) {
		// Base Case: The list is empty or has only one node
		if (head == null || head.next == null)
			return head;

		// Store head of list after two nodes
		ListNode remaing = head.next.next;

		// Change head
		ListNode newhead = head.next;

		// Change next of second node
		head.next.next = head;

		// Recur for remaining list and change next of head
		head.next = pairWiseSwapRecur(remaing);

		// Return new head of modified list
		return newhead;
	}
}
