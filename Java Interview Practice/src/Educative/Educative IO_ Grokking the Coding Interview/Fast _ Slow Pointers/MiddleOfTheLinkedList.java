package src.Educative.FastSlowPointers;

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
    public ListNode findMiddleSolution(ListNode head) {

    }
    // #endregion

}
