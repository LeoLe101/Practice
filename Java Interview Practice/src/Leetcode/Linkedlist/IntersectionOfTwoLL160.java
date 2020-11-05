package src.Leetcode.Linkedlist;

import java.util.*;
import src.Util.ListNode;

public class IntersectionOfTwoLL160 {

    // Space, Time O(N), Not efficent
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode result = null;
        Set<ListNode> s = new HashSet<ListNode>();
        while (headA != null) {
            if (!s.contains(headA)) {
                s.add(headA);
            }
            else {
                s.remove(headA);
            }
            headA = headA.next;
        }

        while (headB != null) {
            if (!s.contains(headB)) {
                s.add(headB);
            }
            else {
                result = headB;
                break;
            }
            headB = headB.next;
        }
        return result;
    }

    // Optimized version with 2 pointers
    // Once each pointer move to the end, swap the List of its current head and move until it hit each other
    // Space (1), Time (N)
    public ListNode getIntersectionNodeOptimized(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode tempA = headA;
        ListNode tempB = headB;
        // Loop until Node A == B
        while (tempA != tempB) {
            // Move to the end of 2 lists. If A = null, turn A back to the head of B and vice versa
            tempA = (tempA == null) ? headB : tempA.next;
            tempB = (tempB == null) ? headA : tempB.next;
        }
        return tempA;
    }

}
