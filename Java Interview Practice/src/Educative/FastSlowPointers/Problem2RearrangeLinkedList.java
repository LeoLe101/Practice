package src.Educative.FastSlowPointers;

public class Problem2RearrangeLinkedList {

    /**
     * Problem: Given the head of a Singly LinkedList, write a method to modify the
     * LinkedList such that the nodes from the second half of the LinkedList are
     * inserted alternately to the nodes from the first half in reverse order. So if
     * the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null, your method
     * should return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.
     * 
     * @param head ListNode
     */

    // #region ==== Personal Solution ====
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
    //#endregion

    //#region ---- EDUCATIVE Solution ----
    //#endregion
}
