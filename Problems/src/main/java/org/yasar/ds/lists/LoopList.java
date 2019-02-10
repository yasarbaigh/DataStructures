package org.yasar.ds.lists;

public class LoopList {

	static Node head; 
	  
    static class Node { 
  
        int data; 
        Node next; 
  
        Node(int d) { 
            data = d; 
            next = null; 
        } 
    } 
  
    // Function that detects loop in the list 
    void detectAndRemoveLoop(Node node) { 
  
        // If list is empty or has only one node 
        // without loop 
        if (node == null || node.next == null) 
            return; 
  
        Node slow = node, fast = node; 
  
        // Move slow and fast 1 and 2 steps 
        // ahead respectively. 
        slow = slow.next; 
        fast = fast.next.next; 
  
        // Search for loop using slow and fast pointers 
        while (fast != null && fast.next != null) { 
            if (slow == fast) {
            	removeLoop(slow, node);
            	break;
            }
            	 
              
            slow = slow.next; 
            fast = fast.next.next; 
        } 
  
        
    } 
    
 // Function to remove loop 
    void removeLoop(Node loop, Node head) { 
        Node ptr1 = loop; 
        Node ptr2 = loop; 
  
        // Count the number of nodes in loop 
        int k = 1, i; 
        while (ptr1.next != ptr2) { 
            ptr1 = ptr1.next; 
            k++; 
        } 
  
        // Fix one pointer to head 
        ptr1 = head; 
  
        // And the other pointer to k nodes after head 
        ptr2 = head; 
        for (i = 0; i < k; i++) { 
            ptr2 = ptr2.next; 
        } 
  
        /*  Move both pointers at the same pace, 
         they will meet at loop starting node */
        while (ptr2 != ptr1) { 
            ptr1 = ptr1.next; 
            ptr2 = ptr2.next; 
        } 
  
        // Get pointer to the last node 
        ptr2 = ptr2.next; 
        while (ptr2.next != ptr1) { 
            ptr2 = ptr2.next; 
        } 
  
        /* Set the next node of the loop ending node 
         to fix the loop */
        ptr2.next = null; 
    } 
  
    // Function to print the linked list 
    void printList(Node node) { 
        while (node != null) { 
            System.out.print(node.data + " "); 
            node = node.next; 
        } 
    } 
  
    // Driver program to test above functions 
    public static void main(String[] args) { 
    	LoopList list = new LoopList(); 
        list.head = new Node(50); 
        list.head.next = new Node(20); 
        list.head.next.next = new Node(15); 
        list.head.next.next.next = new Node(4); 
        list.head.next.next.next.next = new Node(10); 
  
        // Creating a loop for testing  
        head.next.next.next.next.next = head.next.next; 
        list.detectAndRemoveLoop(head); 
        System.out.println("Linked List after removing loop : "); 
        list.printList(head); 
    } 
}
