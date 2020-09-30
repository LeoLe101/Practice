import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}

public class PalindromeLL234 {

    // Not optimized solution
    public boolean isPalindrome(ListNode head) {

        int left = 0;
        int right = 0;
        List<Integer> arr = new ArrayList<>();
        ListNode temp = head;

        while (temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }

        right = arr.size() - 1;

        while (left < right) {
            if (!arr.get(left).equals(arr.get(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // #region OPTIMAL with SLOW AND FAST POINTER
    // https://leetcode.com/problems/palindrome-linked-list/discuss/64501/Java-easy-to-understand
    /** 
     * 1 of the best solution using fast and slow pointers
     * Cons: Alter the structure of the LL -> this is bad for other functions that access the LL at the same time (Threading)
     * Pros: Space O(1) Time O(N)
     */
    public boolean isPalindromeSlowAndFastPointers(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
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

    // #region RECURSION (Best and practical)
    // https://leetcode.com/problems/palindrome-linked-list/discuss/181453/Java-or-5-lines-method-or-2ms-or-O(n)-or-recursive-or-easy-to-understand
    /**
     * Use Recursion to move to the end of the LL
     * Then pop each of the call out and check whether or not current value == ref
     * ref's value update every single recursion pop
     * Cons: Space and Time O(N)
     * Pros: Doesn't alter the linked list so there is no problem for other functions or system design
     */
    private ListNode ref;

    public boolean isPalindromeRecur(ListNode head) {
        ref = head;
        return check(head);
    }

    public boolean check(ListNode node) {
        if (node == null)
            return true;
        boolean ans = check(node.next);
        boolean isEqual = (ref.val == node.val) ? true : false;
        ref = ref.next;
        return ans && isEqual;
    }
    // #endregion
}
