package src.Educative.FastSlowPointers;

import src.Educative.ListNode;

public class StartOfLinkedListCycle {

    /**
     * Problem: Given the head of a Singly LinkedList that contains a cycle, write a
     * function to find the starting node of the cycle.
     * 
     * Space (1) - Time (N)
     */

    // #region ==== Personal Solution ====
    public ListNode findCycleStart(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Find the meeting point first
            if (slow == fast)
                return findStart(slow, head);
        }
        return null;
    }

    // Start moving pointer from the head and the meetup node forward 1 by 1
    // When they meet up again, that node will be the starting of the cycle
    private ListNode findStart(ListNode meetupNode, ListNode headNode) {
        while (meetupNode != headNode) {
            meetupNode = meetupNode.next;
            headNode = headNode.next;
        }
        return meetupNode;
    }
    // #endregion

    // #region ---- EDUCATIVE Solution ----
    public static ListNode findCycleStartSolution(ListNode head) {
        int cycleLength = 0;
        // find the LinkedList cycle
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) { // found the cycle
                cycleLength = calculateCycleLength(slow);
                break;
            }
        }

        return findStart(head, cycleLength);
    }

    private static int calculateCycleLength(ListNode slow) {
        ListNode current = slow;
        int cycleLength = 0;
        do {
            current = current.next;
            cycleLength++;
        } while (current != slow);

        return cycleLength;
    }

    private static ListNode findStart(ListNode head, int cycleLength) {
        ListNode pointer1 = head, pointer2 = head;
        // move pointer2 ahead 'cycleLength' nodes
        while (cycleLength > 0) {
            pointer2 = pointer2.next;
            cycleLength--;
        }

        // increment both pointers until they meet at the start of the cycle
        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer1;
    }
    // #endregion
}
