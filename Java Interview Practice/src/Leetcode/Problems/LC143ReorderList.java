package src.Leetcode.Problems;

import src.Util.ListNode;

public class LC143ReorderList {

    // Space (1) - Time (N)
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = reverseLL(slow);
        slow = head;

        while (slow != null) {
            ListNode slowNext = slow.next;
            slow.next = fast;
            slow = fast;
            fast = slowNext;
        }
    }

    private ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
