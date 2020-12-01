package src.Leetcode.Linkedlist;

import java.util.ArrayList;

import src.Util.ListNode;

public class LC92ReverseLL {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head != null)
            return null;

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode preNode = dummy;
        ListNode currNode = dummy;
        ListNode nextCurrNode = dummy;
        int revRange = n - m;

        // Traverse prevNode to the node before m-index
        for (int i = 0; i < m - 1; i++) {
            preNode = preNode.next;
        }

        // Keep track of node at m-index and the next m-index node  
        currNode = preNode.next;
        nextCurrNode = currNode.next;

        // Reverse all the nodes in the range from m to n index
        for (int i = 0; i < revRange; i++) {
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextCurrNode;
            nextCurrNode = nextCurrNode.next;
        }
        

        return dummy.next; // Which is the new head
    }
}
