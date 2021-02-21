package src.Educative.ReverseLinkedList;

import src.Educative.ListNode;

public class ReverseLinkedList {
    
    // Space (1) - Time (N)
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode temp = null;
        while (head != null) {
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
