package org.yasar.ds.lists;

// http://www.geeksforgeeks.org/merge-a-linked-list-into-another-linked-list-at-alternate-positions/
public class Merge2ListsAlternatively {

	public static void main(String[] args) {
		
		ListNode l1 = ListNode.getList(20), l2 = ListNode.getList(15);
		
		ListNode.printList(mergeList(l1, l2));
	}

	public static ListNode mergeList(ListNode l1, ListNode l2) {

		ListNode curr1 = l1, curr2 = l2;
		ListNode curr1Next, curr2Next, prev = null;

		
		while (curr1 != null && curr2 != null) {
			// Save next pointers
			curr1Next = curr1.next;
			curr2Next = curr2.next;

			// Make curr2 as next of curr1
			curr2.next = curr1Next; // Change next pointer of curr2
			curr1.next = curr2; // Change next pointer of curr1

			
			prev = curr2;
			
			
			// Update current pointers for next iteration
			curr1 = curr1Next;
			curr2 = curr2Next;
			
			
		}

		if( curr1 == null) {
			prev.next = curr2;
		} else if (curr2 == null) {
			prev.next = curr1;
		}
		
		return l1 == null ? l2 : l1;
	}
}
