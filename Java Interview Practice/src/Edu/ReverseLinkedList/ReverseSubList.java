package src.Edu.ReverseLinkedList;

import src.Edu.ListNode;

public class ReverseSubList {

    // #region Personal Solution
    // Space (1) - Time (N)
    // Note: The p and q is not the value of the node.
    // These are the location/index within the linked list
    // p <= q <= N (N is the length of linked list)
    public static ListNode reverse(ListNode head, int p, int q) {
        if (p == q || head == null)
            return head;

        // Dummy node to return at the end
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // Node before the node at p location (node before node to be reversed)
        ListNode prev = dummy;

        // traverse until reach a node before reverse location position
        for (int i = 0; i < p - 1; i++) {
            prev = prev.next;
        }

        // Start: Node at location to start reverse
        // Next To Reverese: Node will be reversed
        ListNode start = prev.next;
        ListNode curr = prev.next;
        ListNode nextToReverse = start.next;
        ListNode temp = null;

        // Reverse Linked List
        int traverseAmount = q - p;
        for (int i = 0; i < traverseAmount; i++) {
            temp = nextToReverse.next;
            nextToReverse.next = curr;
            curr = nextToReverse;
            nextToReverse = temp;
        }

        // Relink prev and end to the reversed linkedlist
        prev.next = curr;
        start.next = nextToReverse;
        return dummy.next;
    }
    // #endregion

    // #region EDUCATIVE SOLUTION
    // Space (1) - Time (N)
    public static ListNode reverseEdu(ListNode head, int p, int q) {
        if (p == q)
            return head;

        // after skipping 'p-1' nodes, current will point to 'p'th node
        ListNode current = head, previous = null;
        for (int i = 0; current != null && i < p - 1; ++i) {
            previous = current;
            current = current.next;
        }

        // we are interested in three parts of the LinkedList, part before index 'p',
        // part between 'p' and
        // 'q', and the part after index 'q'
        ListNode lastNodeOfFirstPart = previous; // points to the node at index 'p-1'
        // after reversing the LinkedList 'current' will become the last node of the
        // sub-list
        ListNode lastNodeOfSubList = current;
        ListNode next = null; // will be used to temporarily store the next node
        // reverse nodes between 'p' and 'q'
        for (int i = 0; current != null && i < q - p + 1; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        // connect with the first part
        if (lastNodeOfFirstPart != null)
            lastNodeOfFirstPart.next = previous; // 'previous' is now the first node of the sub-list
        else // this means p == 1 i.e., we are changing the first node (head) of the
             // LinkedList
            head = previous;

        // connect with the last part
        lastNodeOfSubList.next = current;

        return head;
    }
    // #endregion

}
