package src.Leetcode.Linkedlist;

import java.util.*;
import src.Util.ListNode;

public class LC142LinkedListCycleII {

    /**
     * Space (N) and Time O(N), Unoptimized for space version
     * 
     * @param head The start of the LL
     * @return The ListNode which is the starting of the cycle
     */
    public ListNode detectCycleHashSet(ListNode head) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode node = head;
        while (node != null) {
            if (visited.contains(node)) {
                return node;
            }
            visited.add(node);
            node = node.next;
        }
        return null;
    }

    // Space (1) - Time (N)
    // 2 Ptrs to find the cycle meeting point first
    // Then reset the 1st ptr to starting point of the LL
    // 2nd ptr at the cycle meeting point
    // Move both ptr 1 by 1 until they collided.
    // The distance from 2 ptr and where they collideded will be the cycle begin
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return detectStartNode(head, fast);
        }
        return null;
    }

    private ListNode detectStartNode(ListNode left, ListNode right) {
        while (left != right) {
            left = left.next;
            right = right.next;
        }
        return left;
    }

    // ------------------------------ LEETCODE SOLUTION
    // --------------------------------
    // Similar to the optimized version, but clean code
    private ListNode getIntersect(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;

        // A fast pointer will either loop around a cycle and meet the slow
        // pointer or reach the `null` at the end of a non-cyclic list.
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                return tortoise;
            }
        }

        return null;
    }

    public ListNode detectCycleLCSolution(ListNode head) {
        if (head == null) {
            return null;
        }

        // If there is a cycle, the fast/slow pointers will intersect at some
        // node. Otherwise, there is no cycle, so we cannot find an entrance to
        // a cycle.
        ListNode intersect = getIntersect(head);
        if (intersect == null) {
            return null;
        }

        // To find the entrance to the cycle, we have two pointers traverse at
        // the same speed -- one from the front of the list, and the other from
        // the point of intersection.
        ListNode ptr1 = head;
        ListNode ptr2 = intersect;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    }
}