package src.Leetcode.Linkedlist;

import src.Util.ListNode;

public class RemoveLLElements203 {

    // Space O(1), Time (N)
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;

        while (fast != null) {
            if (fast.val == val) {
                slow.next = fast.next;
            } else
                slow = slow.next;
            fast = fast.next;
        }
        return dummy.next;
    }

}
