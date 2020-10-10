import java.util.ArrayList;

public class RemoveLLElements203 {

    // Space O(1), Time (N)
    public ListNode removeElements(ListNode head, int val) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null) {
            if (fast.val == val) {
                slow.next = fast.next;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return head;
    }
}
