import java.util.ArrayList;

public class RemoveLLElements203 {

    // Space O(1), Time (N)
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;

        while (fast != null) {
            if (fast.val == val) {
                slow.next = fast.next;
            } else 
                slow = slow.next;
            fast = fast.next;
        }
        return dummy.next;
    }

    public ListNode removeElementsRecursion(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head = removeElements(head.next, val);
    }

}
