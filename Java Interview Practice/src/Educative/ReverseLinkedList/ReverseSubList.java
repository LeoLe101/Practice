package src.Educative.ReverseLinkedList;

import src.Educative.ListNode;

public class ReverseSubList {

    // Space () - Time ()
    public ListNode ReverseSubList(ListNode head, int p, int q) {
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode curr = head;

        // Traverse until curr reaches node p
        for (int i = 0; i < p; i++) {
            if (curr.value == p)
                break;
            prev = prev.next;
            curr = curr.next;
        }

        // Reverse curr of val p until curr is q
        


        return null;
    }

    private ListNode reverse(ListNode curr, ListNode end) {
        ListNode temp = null;
        while (curr != end) {
            
        }

    }
}
