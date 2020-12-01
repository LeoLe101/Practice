package src.Leetcode.Linkedlist;

import java.util.ArrayList;
import java.util.List;

import src.Util.ListNode;

public class LC234PalindromeLL {

    // Space (N) Time (N)
    public boolean isPalindromeIter(ListNode head) {
        List<Integer> vals = new ArrayList<>();

        // Convert LinkedList into ArrayList.
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // Use two-pointer technique to check for palindrome.
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            // Note that we must use ! .equals instead of !=
            // because we are comparing Integer, not int.
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

    // Space (1) Time (N)
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast!= null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = reverseLL(slow);
        slow = head;

        while (fast != null) {
            if (slow.val != fast.val) {
                // Return to original LL
                fast = reverseLL(slow);
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode temp = prev;

        while (head != null) {
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

}
