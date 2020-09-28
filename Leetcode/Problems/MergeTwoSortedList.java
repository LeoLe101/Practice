import java.util.*;

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

public class MergeTwoSortedList {

    public ListNode MergeTwoSortedList(ListNode l1, ListNode l2) {

        ListNode temp = l1.val < l2.val ? l1 : l2;
        ListNode ptr1 = l1.val < l2.val ? l1.next : l1;
        ListNode ptr2 = l1.val < l2.val ? l2 : l2.next;
        ListNode result = temp;

        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val <= ptr2.val) {
                result.next = ptr1;
                ptr1 = ptr1.next;
            } else {
                result.next = ptr2;
                ptr2 = ptr2.next;
            }
        }

        while (ptr1 != null) {
            result.next = ptr1;
            ptr1 = ptr1.next;
        }
        while (ptr2 != null) {
            result.next = ptr2;
            ptr2 = ptr2.next;
        }

        return temp;
    }

}
