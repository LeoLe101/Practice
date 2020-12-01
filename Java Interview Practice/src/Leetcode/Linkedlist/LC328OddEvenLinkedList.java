package src.Leetcode.Linkedlist;

import src.Util.ListNode;

public class LC328OddEvenLinkedList {
    
    // Space (1) Time (N)
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;

        ListNode oddPtr = head;
        ListNode evenPtr = head.next;
        ListNode currEvenHead = evenPtr; // Keep track of the head of Even List

        // Remapping the whole linked list into 2 different linked lists. 
        // Even and Odd List
        while (evenPtr != null && evenPtr.next != null) {
            oddPtr.next = evenPtr.next; // the next node of Even is an Odd node
            oddPtr = oddPtr.next; // move Odd Pointer forward
            evenPtr.next = oddPtr.next; // the next node of Odd is an Even node
            evenPtr = evenPtr.next; // move Even Pointer forward
        }

        oddPtr.next = currEvenHead;

        return head;
    }
}
