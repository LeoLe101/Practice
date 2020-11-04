package src.Leetcode.Linkedlist;

import java.util.ArrayList;
import src.Util.ListNode;

public class RemoveNodeFromEndLL19 {

    // BF, Space, Time (N)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Loop and put to array as NEW Node
        ArrayList<ListNode> arr = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            arr.add(new ListNode(temp.val));
            temp = temp.next;
        }

        // Reset Head and Temp
        head = new ListNode(-1);
        temp = head;

        // Put every single Node back to the new LL
        // Skip the target Node
        int target = arr.size() - n;
        for (int i = 0; i < arr.size(); i++) {
            if (i != target) {
                temp.next = arr.get(i);
                temp = temp.next;
            }
        }
        return head.next;
    }

    // Optimized version Space O(1), Time (N)
    public ListNode removeNthFromEndOptimized(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes
        // apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

}
