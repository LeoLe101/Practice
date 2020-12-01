package src.Leetcode.Linkedlist;

import src.Util.ListNode;

public class LC2AddTwoNumbers {

    // Space(1) Time(N)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }

    // Personal code, use remainder and sum
    public ListNode addTwoNumbersLeo(ListNode l1, ListNode l2) {
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        ListNode result = new ListNode(-1);
        ListNode temp = result;
        int sum = 0, remain = 0;

        while (ptr1 != null || ptr2 != null) {
            if (ptr1 != null) {
                sum += ptr1.val;
                ptr1 = ptr1.next;
            }

            if (ptr2 != null) {
                sum += ptr2.val;
                ptr2 = ptr2.next;
            }

            if (remain > 0) {
                sum += remain;
                remain = 0;
            }

            if (sum >= 10) {
                remain = sum / 10;
                sum = sum % 10;
            }

            temp.next = new ListNode(sum);
            temp = temp.next;
            sum = 0;
        }

        if (remain > 0) {
            temp.next = new ListNode(remain);
        }
        return result.next;
    }
}
