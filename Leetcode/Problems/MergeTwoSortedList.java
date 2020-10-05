public class MergeTwoSortedList {

    public ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {

        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        ListNode result = new ListNode(-1);
        ListNode temp = result;

        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val <= ptr2.val) {
                temp.next = ptr1;
                ptr1 = ptr1.next;
            } else {
                temp.next = ptr2;
                ptr2 = ptr2.next;
            }
            temp = temp.next;
        }

        while (ptr1 != null) {
            temp.next = ptr1;
            temp = temp.next;
            ptr1 = ptr1.next;
        }
        while (ptr2 != null) {
            temp.next = ptr2;
            temp = temp.next;
            ptr2 = ptr2.next;
        }

        return result.next;
    }

}
