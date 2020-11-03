public class InsertionSortList147 {

    // Space O(1) Time (N2)
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;

        ListNode result = new ListNode();
        ListNode prevNode = result;
        ListNode nextNode = prevNode.next;

        // Loop and check each single node
        while (head != null) {
            
            // Reset Prev and Next nodes
            prevNode = result;
            nextNode = result.next;
            
            // Move both Prev and Next nodes forward until the head < next
            while (nextNode != null) {
                if (nextNode.val > head.val) break;
                prevNode = nextNode;
                nextNode = nextNode.next;
            }

            // Hold the next value from the original 
            // (Disconnect the current head from original LL)
            ListNode temp = head.next;

            // Put the node from the original LL into the result LL
            head.next = nextNode;
            prevNode.next = head;

            // Move on to the next value in original LL
            head = temp;
        }

        return result.next;
    }
}
