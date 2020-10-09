import java.util.HashMap;
import java.util.Map;

public class RotateRight61 {

    // #region UnOptimized Time O(N*K) -- Exceed Given time
    // Kinda solved the problem but run time
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode temp = head;
        while (k > 0) {
            ListNode endNode = FindEndNode(temp);
            ListNode prevNode = FindNearEndNode(temp);

            endNode.next = temp;
            prevNode.next = null;
            temp = endNode;
            k--;
        }
        return temp;
    }

    private ListNode FindEndNode(ListNode head) {
        if (head == null)
            return null;
        while (head.next != null)
            head = head.next;
        return head;
    }

    private ListNode FindNearEndNode(ListNode head) {
        if (head == null)
            return null;
        while (head.next != null && head.next.next != null) {
            head = head.next;
        }
        return head;
    }
    // #endregion

    // #region Optimized

    public ListNode rotateRigtNodeOptimized(ListNode head, int k) {

        return head;
    }
    // #endregion
}
