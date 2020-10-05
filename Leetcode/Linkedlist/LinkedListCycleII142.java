public class LinkedListCycleII142 {

    public ListNode detectCycleStartNode(ListNode head) {

        if (head == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            if (slow == fast)
                break;
            slow = slow.next;
            fast = fast.next.next;
        }
        return detectStartNode(head, fast);
    }

    private ListNode detectStartNode(ListNode left, ListNode right) {

        while (left != null && right != null) {
            if (left == right)
                return left;
            
            left = left.next;
            right = right.next;
        }
        return null;
    }
}