package src.Leetcode.Problems;

import src.Util.ListNode;

public class RemoveDuplicatesFromSortedLL83 {
    // Iteration Space (1), Time (N)
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val)
                temp.next = temp.next.next;
            else
                temp = temp.next;
        }
        return head;
    }

    public ListNode deleteDuplicatesRecur(ListNode head) {
        if (head == null || head.next == null)
            return head;

        head.next = deleteDuplicates(head.next);

        if (head.val == head.next.val) {
            return head.next;
        }
        return head;
    }
}
