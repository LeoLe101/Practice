package src.Leetcode.Problems;

import src.Util.ListNode;

public class LC83RemoveDuplicatesFromSortedLL {

    // Iteration Space (1), Time (N)
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            // Check if ==, set currNode as next next node to skip duplication
            if (temp.val == temp.next.val)
                temp.next = temp.next.next;
            // Else move ptr to the next node
            else
                temp = temp.next;
        }
        return head;
    }

    // Space (N) - Time (N)
    public ListNode deleteDuplicatesRecur(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // Recur to the end of the linkedlist
        head.next = deleteDuplicates(head.next);

        // Iterate back and check curr with next if ==, set the next node as HEAD
        return (head.val == head.next.val) ? head.next : head;
    }
}
