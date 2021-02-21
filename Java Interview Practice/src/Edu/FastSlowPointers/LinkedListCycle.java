package src.Edu.FastSlowPointers;

import java.util.HashSet;

import src.Edu.ListNode;

/**
 * Problem: Given the head of a Singly LinkedList, write a function to determine
 * if the LinkedList has a cycle in it or not.
 * 
 * Space (1) - Time (N)
 */

// #region ==== Personal Solution ====
class LinkedListCyclePersonal {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
}
// #endregion

// #region ---- EDUCATIVE Solution ----
class LinkedListCycleSolution {

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                return true; // found the cycle
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("LinkedList has cycle: " + LinkedListCycleSolution.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycleSolution.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycleSolution.hasCycle(head));
    }
}
// #endregion

/**
 * Problem: Given the head of a Singly LinkedList, write a function to find the
 * length of the Cycle
 * 
 * Space (1) - Time (N)
 */

// #region ==== Personal Solution ====
class LinkedListCycleLengthPersonal {
    public int findCycleLength(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return calLength(slow);
        }
        return 0;
    }

    private int calLength(ListNode curr) {
        ListNode temp = curr;
        int counter = 0;
        while (temp != curr) {
            counter++;
            temp = temp.next;
        }
        return counter;
    }

    private int calLength2(ListNode curr) {
        ListNode temp = curr;
        HashSet<ListNode> set = new HashSet<>();
        while (!set.contains(temp)) {
            set.add(temp);
        }
        return set.size();
    }
}
// #endregion

// #region ---- EDUCATIVE Solution ----
class LinkedListCycleLengthSolution {
    public static int findCycleLength(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) // found the cycle
                return calculateLength(slow);
        }
        return 0;
    }

    private static int calculateLength(ListNode slow) {
        ListNode current = slow;
        int cycleLength = 0;
        do {
            current = current.next;
            cycleLength++;
        } while (current != slow);
        return cycleLength;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle length: " + LinkedListCycleLengthSolution.findCycleLength(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle length: " + LinkedListCycleLengthSolution.findCycleLength(head));
    }
}
// #endregion
