import java.util.*;

public class ListNode {
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

public class ReverseLL {

    // unoptimized
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode prevNode = null;
        ListNode nextNode = head.next;

        while (head != null) {
            head.next = prevNode;
            prevNode = head;
            head = nextNode;
            if (nextNode != null) {
                nextNode = nextNode.next;
            }
        }
        
        return prevNode;
    }

    // Clean and Optimized solution
    public ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return head;
    }
}
