package src.Edu.FastSlowPointers;

import src.Edu.ListNode;

public class Problem1PalindromeLinkedList {

    // #region ==== Personal Solution ====
    // Space (1) - Time (N)
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Move slow to the middle point in LL
        while (fast != null && fast.next == null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // In case of odd number node in the LL
        if (fast != null) {
            slow = slow.next;
        }

        // Reverse the LL from middle point, which is slow pointer
        fast = reverseLL(slow);
        ListNode middlePoint = fast; // For reversing the LL back to the original
        slow = head;
        while (fast != null ) {
            if (slow.value != fast.value) {
                reverseLL(middlePoint);
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;

    }

    private ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }
    // #endregion

    // #region ---- EDUCATIVE Solution ----
    public static boolean isPalindromeSolution(ListNode head) {
        if (head == null || head.next == null)
            return true;

        // find middle of the LinkedList
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode headSecondHalf = reverse(slow); // reverse the second half
        ListNode copyHeadSecondHalf = headSecondHalf; // store the head of reversed part to revert back later

        // compare the first and the second half
        while (head != null && headSecondHalf != null) {
            if (head.value != headSecondHalf.value) {
                break; // not a palindrome
            }
            head = head.next;
            headSecondHalf = headSecondHalf.next;
        }

        reverse(copyHeadSecondHalf); // revert the reverse of the second half
        if (head == null || headSecondHalf == null) // if both halves match
            return true;
        return false;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    // #endregion
}
