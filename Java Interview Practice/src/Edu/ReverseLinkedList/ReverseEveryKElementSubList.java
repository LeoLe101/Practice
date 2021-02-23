package src.Edu.ReverseLinkedList;

import src.Edu.ListNode;

public class ReverseEveryKElementSubList {

    public static ListNode reverse(ListNode head, int k) {
        if (head == null || k <= 0)
            return head;

        ListNode prev = null;
        ListNode curr = head;

        // Do until reach the end
        while (curr != null) {

            // Change the start and last node to this current sub list
            ListNode lastOfCurrentSubList = curr;
            ListNode lastOfPreviousSubList = prev;
            ListNode tempNext = null;

            // Reverse each sub List
            for (int i = 0; i < k && curr != null; i++) {
                tempNext = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tempNext;
            }

            // Check if last of previous sublist is not null (which means not the first
            // time)
            // reconnect the node from list previous sub list to the new header
            if (lastOfPreviousSubList!= null) {
                lastOfPreviousSubList.next = prev;
            } else {
                head = prev;
            }
            lastOfCurrentSubList.next = curr;

            if (curr == null) break;


        }

        return dummy.next;
    }




}
