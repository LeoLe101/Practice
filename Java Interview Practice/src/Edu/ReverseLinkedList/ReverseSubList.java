package src.Edu.ReverseLinkedList;

import src.Edu.ListNode;

public class ReverseSubList {

    // Space (1) - Time (N)
    // Note: The p and q is not the value of the node.
    // These are the location/index within the linked list
    // p <= q <= N (N is the length of linked list)
    public static ListNode reverse(ListNode head, int p, int q) {
        if (p == q)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode start= dummy.next;
        ListNode prev = dummy;
        ListNode end = dummy;

        // traverse until reach first position
        for (int i = 0; i < p - 1; i++) {
            prev = prev.next;
        }
        start = prev.next;
        end = start.next;

        // Reverse Linked List
        int traverseAmount = q - p;
        while (curr.next != null && curr != end) {
            = curr.next;
            curr.next = end;
            end = curr;
            curr = temp;
        }


        return dummy.next;
    }
}
