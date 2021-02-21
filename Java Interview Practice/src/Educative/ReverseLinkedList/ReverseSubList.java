package src.Educative.ReverseLinkedList;

import src.Educative.ListNode;

/**
 * ReverseSubList
 */
public class ReverseSubList {

    // Space (1) - Time (N)
    // Note: The p and q is not the value of the node.
    //       These are the location/index within the linked list
    //       p <= q <= N (N is the length of linked list)
    public static ListNode reverse(ListNode head, int p, int q) {
        if (p == q) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy.next;
        ListNode prev = dummy;
        ListNode end = dummy.next;

        // traverse until reach first position 
        for (int i = 0; i < p - 1; i++) {
            prev = prev.next;
        }
        curr = prev.next;

        // traverse until reach second position
        for (int i = 0; i < p - 1; i++) {
            prev = prev.next;
        }
        curr = prev.next;


        // Reverse and relink the list
        prev.next = reverseInnerList(curr, end);
        return dummy.next;
    }

    // Reverse only from curr to end node given
    private static ListNode reverseInnerList(ListNode curr, ListNode end) {
        ListNode temp = null;
        while (curr.next != null && curr != end) {
            temp = curr.next;
            curr.next = end;
            end = curr;
            curr = temp;
        }
        return curr;
    }

} 