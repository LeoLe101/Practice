package src.Edu.FastSlowPointers;

import src.Edu.ListNode;

public class MiddleOfTheLinkedList {

    // #region ==== Personal Solution ====
    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    // #endregion

    // #region ---- EDUCATIVE Solution ----
    // SAME THING AS ABOVE!
    // #endregion

}
